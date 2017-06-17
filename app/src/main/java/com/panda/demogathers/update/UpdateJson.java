package com.panda.demogathers.update;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.panda.demogathers.domain.Update;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 版本升级
 */

public class UpdateJson {

    private static final String updateUrl = "http://ocf5858b1.bkt.clouddn.com/demo_version.json";

    private Gson gson;
    private Context context;

    public UpdateJson(Context context) {
        gson = new Gson();
        this.context = context;
    }

    /**
     * 获取网络上的XML
     */
    public void getUpdate() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    HttpURLConnection conn = (HttpURLConnection) new URL(updateUrl).openConnection();
                    conn.setConnectTimeout(5000);//设置连接超时
                    conn.setRequestMethod("GET");
                    if (conn.getResponseCode() == 200) {
                        InputStream inputStream = conn.getInputStream();
                        String json = getStreamString(inputStream);
                        Update update = gson.fromJson(json, Update.class);
                        int oldVersion = getVersionCode(context);
                        int newVersion = update.getVersionCode();
                        if (newVersion > oldVersion) {
                            final String url = update.getUrl();
                            AlertDialog.Builder builder = new AlertDialog.Builder(context);
                            builder.setMessage("有新版本，需要升级吗？");
                            builder.setTitle("升级提示框");
                            builder.setPositiveButton("立即升级", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    updateNow(url);
                                    dialog.dismiss();
                                }
                            });
                            builder.setNegativeButton("下次再说", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                            builder.create().show();
                        }


                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }//和服务器建立连接
            }
        }).start();
    }

    //    download(String url, String target, RequestCallBack<File> callback) {
    public void updateNow(String downloadUrl) {
        Log.e("error", "downloadedUrl:onStart");
        final String downloadedUrl = Environment.getExternalStorageDirectory() + "/" + System.currentTimeMillis() + ".apk";
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.download(downloadUrl, downloadedUrl, new RequestCallBack<File>() {
            @Override
            public void onSuccess(ResponseInfo<File> responseInfo) {
                int code = responseInfo.statusCode;
                if (200 == code) {
                    install(downloadedUrl);
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                Log.e("error", "downloadedUrl:onFailure" + e.toString());
            }
        });


    }

    public static String getStreamString(InputStream tInputStream) {
        if (tInputStream != null) {
            try {
                BufferedReader tBufferedReader = new BufferedReader(new InputStreamReader(tInputStream));
                StringBuffer tStringBuffer = new StringBuffer();
                String sTempOneLine = new String("");
                while ((sTempOneLine = tBufferedReader.readLine()) != null) {
                    tStringBuffer.append(sTempOneLine);
                }
                return tStringBuffer.toString();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;

    }

    private void install(String installUrl) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(new File(installUrl)), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    /**
     * 获取软件版本号
     *
     * @return versionCode
     */
    public static int getVersionCode(Context context) {
        int versionCode = 0;
        try {
            // 获取软件版本号，对应AndroidManifest.xml下的versionCode
            versionCode = context.getPackageManager().
                    getPackageInfo("com.panda.demogathers", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

}
