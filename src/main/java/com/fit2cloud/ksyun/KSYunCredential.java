package com.fit2cloud.ksyun;

/**
 * Created with IntelliJ IDEA.
 * User: zhcloud
 * Date: 11/11/14
 * Time: 6:49 PM
 * Email: zhcloud@fit2cloud.com
 */
public class KSYunCredential {
    private String accessKeyId;
    private String accessKeySecret;

    public KSYunCredential(String accessKeyId, String accessKeySecret){
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
    }

    public KSYunCredential(){
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }
}
