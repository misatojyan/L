package com.example.l.interfaces;

/**
 * Created by Android on 2016/11/25.
 */

public interface UploadStateListener
{
    void onUploadStart();
    void onUpload(float persent);
    void onUploadCompleted();
}
