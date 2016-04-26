package com.fit2cloud.ksyun.instance.requests;

import com.fit2cloud.ksyun.CommonRequest;

/**
 * Created with IntelliJ IDEA.
 * User: zhcloud
 * Date: 11/10/14
 * Time: 2:38 PM
 * Email: zhcloud@fit2cloud.com
 */
public class DescribeInstanceRequest extends CommonRequest {

    private String InstanceId;

	public String getInstanceId() {
		return InstanceId;
	}

	public void setInstanceId(String instanceId) {
		InstanceId = instanceId;
	}
}
