package com.fit2cloud.ksyun.instance.responses;

import java.util.List;

import com.fit2cloud.ksyun.CommonResponse;
import com.fit2cloud.ksyun.instance.model.CustomImage;

/**
 * Created by chixq on 9/8/15.
 */
public class DescribeCustomInstanceImageResponse extends CommonResponse {
    private List<CustomImage> CustomInstanceImageList;

	public List<CustomImage> getCustomInstanceImageList() {
		return CustomInstanceImageList;
	}

	public void setCustomInstanceImageList(List<CustomImage> customInstanceImageList) {
		CustomInstanceImageList = customInstanceImageList;
	}
}
