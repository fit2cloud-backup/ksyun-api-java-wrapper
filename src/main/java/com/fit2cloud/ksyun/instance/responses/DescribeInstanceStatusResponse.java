package com.fit2cloud.ksyun.instance.responses;

import com.fit2cloud.ksyun.instance.model.InstanceStatus;
import com.fit2cloud.ksyun.CommonResponse;
import com.google.gson.Gson;

import java.util.List;

public class DescribeInstanceStatusResponse extends CommonResponse {
    private int Offset;
    private int Count;
    private List<InstanceStatus> InstanceStatusList;

    public int getOffset() {
		return Offset;
	}

	public void setOffset(int offset) {
		Offset = offset;
	}

	public int getCount() {
		return Count;
	}

	public void setCount(int count) {
		Count = count;
	}

	public List<InstanceStatus> getInstanceStatusList() {
		return InstanceStatusList;
	}

	public void setInstanceStatusList(List<InstanceStatus> instanceStatusList) {
		InstanceStatusList = instanceStatusList;
	}

	public static DescribeInstanceStatusResponse fromJson(String json){
        return new Gson().fromJson(json, DescribeInstanceStatusResponse.class);
    }
}
