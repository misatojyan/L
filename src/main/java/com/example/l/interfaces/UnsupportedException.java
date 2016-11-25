package com.example.l.interfaces;

/**
 * Created by Android on 2016/11/24.
 */

public class UnsupportedException extends RuntimeException
{
    public UnsupportedException()
    {
    }

    public UnsupportedException(String message)
    {
        super(message);
    }

    public UnsupportedException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public UnsupportedException(Throwable cause)
    {
        super(cause);
    }

    public UnsupportedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
