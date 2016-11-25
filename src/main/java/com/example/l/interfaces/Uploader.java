package com.example.l.interfaces;

import com.example.l.Scheme;

import java.io.File;

/**
 * Created by Android on 2016/11/24.
 */

public class Uploader
{
    private static volatile Uploader sDownloader;

    private Uploader()
    {
    }

    public static Uploader get()
    {
        if (sDownloader == null) {
            synchronized (Uploader.class) {
                if (sDownloader == null) {
                    sDownloader = new Uploader();
                }
            }
        }
        return sDownloader;
    }

    public byte[] download(String url)
    {
        Scheme scheme = Scheme.ofUri(url);
        switch (scheme) {
        case HTTP:
            return getFromHttp(url);
            // break;
        case HTTPS:
        case FILE:
        case CONTENT:
        case ASSETS:
        case DRAWABLE:
            throw new UnsupportedException("unsupported protocol exception" + scheme);
            // break;
        case UNKNOWN:
        default:
            throw new UnknownProtocolException("unknown protocol for exception" + scheme);
            // break;
        }
    }

    public byte[] download(DownloadTask task)
    {
        return download(task.getUrl());
    }

    private byte[] getFromHttp(String url)
    {
        byte[] b = getFromDisk(url);
        if (b != null) {
            return b;
        }
        return new byte[0];
    }

    private byte[] getFromDisk(String path)
    {
        File file = new File(path);
        if (!file.exists()) {
            return null;
        } else {
            return new byte[0];
        }
    }

    private boolean isCached(String url)
    {
        return new File(MD5.getInstance().getMD5(url)).exists();
    }
}
