package com.fit2cloud.ksyun;

/**
 * Created by chixq on 7/22/15.
 */
public class CommonErrorResponse {
    private String RequestId;
    private String Code;
    private String Message;

    public String getRequestId() {
        return RequestId;
    }

    public void setRequestId(String requestId) {
        RequestId = requestId;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}

