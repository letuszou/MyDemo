package com.panda.demogathers.domain;

/**
 * 版本升级
 */

public class Update {

    private int versionCode;
    private String url;
    private String mypackage;

    public String getMypackage() {
        return mypackage;
    }

    public void setMypackage(String mypackage) {
        this.mypackage = mypackage;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
