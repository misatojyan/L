package com.example.l.interfaces;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Android on 2016/11/25.
 */

public class DiskCache
{
    private final String mMD5;

    private String mUrl;

    private File mCacheFile;

    public DiskCache(String url)
    {
        mUrl = url;
        mMD5 = MD5.getInstance().getMD5(url);
        mCacheFile = new File(mMD5);
    }

    public boolean isCached()
    {
        return mCacheFile.exists();
    }

    public long cacheSize()
    {
        return mCacheFile.length();
    }

    private byte[] read()
    {
        if (!isCached()) {
            throw new UncachedException("uncached for " + mUrl);
        }

        if (cacheSize() >= 1024 * 1024 * 64) {
            throw new FileTooLargeException("file " + mMD5 + " too large");
        }

        FileInputStream fileInputStream = null;

        byte[] result = null;

        try {
            fileInputStream = new FileInputStream(mCacheFile);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024 * 8];
            int len = 0;
            while ((len = fileInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, len);
            }
            result = byteArrayOutputStream.toByteArray();
        } /*catch (FileNotFoundException e) {
            result = new byte[0];
        } catch (IOException e) {
            result = new byte[0];
        }*/ catch (Exception e) {
            result = new byte[0];
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return result;
        }
    }

    private void write(byte[] data)
    {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(mCacheFile);
            fileOutputStream.write(data);
        } /*catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/ catch (Exception e) {

        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public byte[] load()
    {
        return read();
    }

    public void save(byte[] data)
    {
        write(data);
    }
}
