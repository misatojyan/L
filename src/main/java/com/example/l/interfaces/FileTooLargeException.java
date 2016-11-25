package com.example.l.interfaces;

/**
 * Created by Android on 2016/11/24.
 */

public class FileTooLargeException extends RuntimeException
{
    public FileTooLargeException()
    {
    }

    public FileTooLargeException(String message)
    {
        super(message);
    }

    public FileTooLargeException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public FileTooLargeException(Throwable cause)
    {
        super(cause);
    }

    public FileTooLargeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
