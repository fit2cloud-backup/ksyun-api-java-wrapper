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
    private int Code;
    private int RequestId;
    private String Message;
    private String service;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public int getRequestId() {
        return RequestId;
    }

    public void setRequestId(int requestId) {
        RequestId = requestId;
    }

    @Override
    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "KSYunServiceException{" +
                "Code=" + Code +
                ", RequestId=" + RequestId +
                ", Message='" + Message + '\'' +
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
