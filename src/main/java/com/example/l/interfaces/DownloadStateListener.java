package com.example.l.interfaces;

/**
 * Created by Android on 2016/11/25.
 */

public interface DownloadStateListener
{
    void onDownloadStart();
    void onDownload(float persent);
    void onDownloadCompleted();
}
