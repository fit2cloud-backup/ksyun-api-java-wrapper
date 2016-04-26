package com.fit2cloud.ksyun.instance.responses;

import com.fit2cloud.ksyun.CommonResponse;

import java.util.List;

/**
 * Created by chixq on 4/25/16.
 */
public class DescribeRegionResponse extends CommonResponse {
    List<String> RegionList;

    public List<String> getRegionList() {
        return RegionList;
    }

    public void setRegionList(List<String> regionList) {
        RegionList = regionList;
    }
}
