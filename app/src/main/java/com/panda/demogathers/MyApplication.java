package com.panda.demogathers;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;
import java.util.List;


/**
 * Created by admin on 2016/8/1.
 */
public class MyApplication extends Application {
    private static String TAG = "MyApplication";
    private static MyApplication mInstance = null;
    private int netState;    //网络状态
    private DisplayImageOptions options;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        initImageOptions();
        initImageLoader(getApplicationContext());
        initConfig();
    }

    private void initConfig(){


    }



    public static MyApplication getInstance() {
        if (null == mInstance) {
            mInstance = new MyApplication();
        }
        return mInstance;
    }

    public boolean isPkgMainProc() {
        ActivityManager am = ((ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE));
        List<ActivityManager.RunningAppProcessInfo> processInfos = am.getRunningAppProcesses();
        String mainProcessName = this.getPackageName();
        int myPid = android.os.Process.myPid();
        for (ActivityManager.RunningAppProcessInfo info : processInfos) {
            if (info.pid == myPid && mainProcessName.equals(info.processName)) {
                return true;
            }
        }
        return false;
    }

    private void initImageOptions() {
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher) //设置图片在下载期间显示的图片
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .resetViewBeforeLoading(true)
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .considerExifParams(true)
                .displayer(new FadeInBitmapDisplayer(0))
                .build();
    }

    public DisplayImageOptions getImageOptions() {
        return options;
    }

    private void initImageLoader(Context context) {
        // This configuration tuning is custom. You can tune every option, you may tune some of them,
        // or you can create default configuration by
        //  ImageLoaderConfiguration.createDefault(this);
        // method.
        File cacheDir = StorageUtils.getOwnCacheDirectory(context, "demo/imageloader/Cache");
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .memoryCache(new WeakMemoryCache())
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .threadPoolSize(3)//线程池内加载的数量
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .diskCacheSize(100 * 1024 * 1024) // 50 Mb
                .diskCache(new UnlimitedDiskCache(cacheDir))
                .discCacheFileCount(200) //缓存的文件数量
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .writeDebugLogs() // Remove for release app
                .build();
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);
    }

    /**
     * 获得当前进程的名字
     *
     * @param context
     * @return 进程号
     */
    public static String getCurProcessName(Context context) {

        int pid = android.os.Process.myPid();

        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);

        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager
                .getRunningAppProcesses()) {

            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }


}
