package com.example.l.interfaces;

/**
 * Created by Android on 2016/11/24.
 */

public class UncachedException extends RuntimeException
{
    public UncachedException()
    {
    }

    public UncachedException(String message)
    {
        super(message);
    }

    public UncachedException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public UncachedException(Throwable cause)
    {
        super(cause);
    }

    public UncachedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
