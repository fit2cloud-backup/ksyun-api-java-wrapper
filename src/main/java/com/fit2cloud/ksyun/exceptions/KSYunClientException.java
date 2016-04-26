package com.fit2cloud.ksyun.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: zhcloud
 * Date: 11/19/14
 * Time: 4:17 PM
 * Email: zhcloud@fit2cloud.com
 */
public class KSYunClientException extends Exception{
    private static final long serialVersionUID = -4776633044048303307L;
    public KSYunClientException() {
        super();
    }

    public KSYunClientException(String message) {
        super(message);
    }

    public KSYunClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public KSYunClientException(Throwable cause) {
        super(cause);
    }

    protected KSYunClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
