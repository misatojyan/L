package com.example.l.interfaces;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Android on 2016/11/25.
 */

public class UploadManager
{
    private static volatile UploadManager sDownloadManager;

    private ThreadPoolExecutor mThreadPoolExecutor;

    private UploadManager()
    {
        Executors.newFixedThreadPool(10);
        mThreadPoolExecutor = new ThreadPoolExecutor(10, 200, 10, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
    }

    public static UploadManager get()
    {
        if (sDownloadManager == null) {
            synchronized (UploadManager.class) {
                if (sDownloadManager == null) {
                    sDownloadManager = new UploadManager();
                }
            }
        }
        return sDownloadManager;
    }

    public void download(DownloadTask downloadTask)
    {

    }
}
