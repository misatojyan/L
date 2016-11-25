package com.example.l.interfaces;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.WeakHashMap;

/**
 * Created by Android on 2016/11/25.
 */

public class MemoryCache
{
    private static WeakHashMap<String, byte[]> sMemoryCache = new WeakHashMap<>();

    public static byte[] getCache(String url)
    {
        return  sMemoryCache.get(url);
    }

    public void cache(String url, byte[] data)
    {
        sMemoryCache.put(url, data);
    }
}
