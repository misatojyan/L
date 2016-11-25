package com.example.l.interfaces;

import java.io.File;

/**
 * Created by Android on 2016/11/24.
 */

public class UploadTask
{
    private String mUrl;

    private byte[] mData;

    private String mMD5;

    public UploadTask(String url)
    {
        mUrl = url;
        mMD5 = MD5.getInstance().getMD5(url);
    }

    public String getUrl()
    {
        return mUrl;
    }

    public void setUrl(String url)
    {
        mUrl = url;
    }

    public boolean isCached()
    {
        return new File(mMD5).exists();
    }

    public byte[] getData()
    {
        if (mData == null) {
            if (isCached()) {
                return getFromDisk();
            } else {
                return null;
            }
        } else {
            return mData;
        }
    }

    private byte[] getFromDisk()
    {
        File file = new File(mMD5);
        if (!file.exists()) {
            return null;
        } else {
            return new byte[0];
        }
    }
}
