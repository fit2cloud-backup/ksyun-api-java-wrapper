package com.fit2cloud.ksyun.instance.responses;

import com.fit2cloud.ksyun.CommonResponse;
import com.fit2cloud.ksyun.instance.model.Instance;

/**
 * Created with IntelliJ IDEA.
 * User: zhcloud
 * Date: 11/10/14
 * Time: 2:40 PM
 * Email: zhcloud@fit2cloud.com
 */
public class DescribeInstanceResponse extends CommonResponse {
    private Instance Instance;

	public Instance getInstance() {
		return Instance;
	}

	public void setInstance(Instance instance) {
		Instance = instance;
	}
}
