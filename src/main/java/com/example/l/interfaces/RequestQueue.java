package com.example.l.interfaces;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Android on 2016/11/25.
 */

public class RequestQueue extends LinkedBlockingQueue<Request>
{
    private static volatile RequestQueue sRequestQueue;

    private RequestQueue()
    {

    }

    public static RequestQueue get()
    {
        if (sRequestQueue == null) {
            synchronized (RequestQueue.class) {
                if (sRequestQueue == null) {
                    sRequestQueue = new RequestQueue();
                }
            }
        }

        return sRequestQueue;
    }
}
