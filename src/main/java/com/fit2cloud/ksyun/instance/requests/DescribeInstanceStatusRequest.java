package com.fit2cloud.ksyun.instance.requests;

import com.fit2cloud.ksyun.CommonRequest;

public class DescribeInstanceStatusRequest extends CommonRequest {

    private int Offset;
    private int Count = 100;
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
}
