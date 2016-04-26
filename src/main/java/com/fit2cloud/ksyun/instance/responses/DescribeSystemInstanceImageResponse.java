package com.fit2cloud.ksyun.instance.responses;

import java.util.List;

import com.fit2cloud.ksyun.CommonResponse;
import com.fit2cloud.ksyun.instance.model.SystemImage;

/**
 * Created by chixq on 9/8/15.
 */
public class DescribeSystemInstanceImageResponse extends CommonResponse {
    private List<SystemImage> SystemInstanceImageList;

	public List<SystemImage> getSystemInstanceImageList() {
		return SystemInstanceImageList;
	}

	public void setSystemInstanceImageList(List<SystemImage> systemInstanceImageList) {
		SystemInstanceImageList = systemInstanceImageList;
	}
}
