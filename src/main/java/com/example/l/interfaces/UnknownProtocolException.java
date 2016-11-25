package com.example.l.interfaces;

/**
 * Created by Android on 2016/11/24.
 */

public class UnknownProtocolException extends RuntimeException
{
    public UnknownProtocolException()
    {
    }

    public UnknownProtocolException(String message)
    {
        super(message);
    }

    public UnknownProtocolException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public UnknownProtocolException(Throwable cause)
    {
        super(cause);
    }

    public UnknownProtocolException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
