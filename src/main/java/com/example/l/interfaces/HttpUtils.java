package com.example.l.interfaces;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Android on 2016/11/24.
 */

public class HttpUtils
{
    public static byte[] get(String urlString)
    {
        try {
            URL url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
