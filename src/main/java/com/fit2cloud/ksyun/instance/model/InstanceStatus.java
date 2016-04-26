package com.fit2cloud.ksyun.instance.model;


/**
 * Created with IntelliJ IDEA.
 * User: zhcloud
 * Date: 11/10/14
 * Time: 2:42 PM
 * Email: zhcloud@fit2cloud.com
 */
public class InstanceStatus {

    private String InstanceId;
    private String InstanceStatus;
	public String getInstanceId() {
		return InstanceId;
	}
	public void setInstanceId(String instanceId) {
		InstanceId = instanceId;
	}
	public String getInstanceStatus() {
		return InstanceStatus;
	}
	public void setInstanceStatus(String instanceStatus) {
		InstanceStatus = instanceStatus;
	}
}
