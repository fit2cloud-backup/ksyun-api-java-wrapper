package com.fit2cloud.ksyun.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: zhcloud
 * Date: 11/19/14
 * Time: 4:18 PM
 * Email: zhcloud@fit2cloud.com
 */
public class KSYunServiceException extends Exception{
    private static final long serialVersionUID = -7296361394906881990L;
    private int errorCode;
    private int requestId;
    private String errorMessage;
    private String service;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "QCloudServiceException{" +
                "errorCode=" + errorCode +
                ", requestId=" + requestId +
                ", errorMessage='" + errorMessage + '\'' +
                ", service='" + service + '\'' +
                '}';
    }

    public KSYunServiceException() {
        super();
    }

    public KSYunServiceException(String message) {
        super(message);
    }

    public KSYunServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public KSYunServiceException(Throwable cause) {
        super(cause);
    }

    protected KSYunServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
