package com.fit2cloud.ksyun;

import com.fit2cloud.ksyun.exceptions.KSYunClientException;
import com.fit2cloud.ksyun.exceptions.KSYunServiceException;
import com.fit2cloud.ksyun.instance.requests.*;
import com.fit2cloud.ksyun.instance.responses.*;
import com.fit2cloud.ksyun.util.GlobalConst;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by chixq on 14-11-17.
 */
public class KSYunClient {

    private BaseModuleRequest request;
    private Gson gson = new GsonBuilder().create();

    public KSYunClient(KSYunCredential credential) {
        this.request = new BaseModuleRequest(credential, GlobalConst.DEFAULT_BASE_URL);
    }

    public KSYunClient(KSYunCredential credential, String apiEndpoint) {
        this.request = new BaseModuleRequest(credential, apiEndpoint);
    }

    public KSYunClient(String secretId, String secretKey) {
        KSYunCredential qcloudCredential = new KSYunCredential(secretId, secretKey);
        this.request = new BaseModuleRequest(qcloudCredential, GlobalConst.DEFAULT_BASE_URL);
    }

//   instance API
    @SuppressWarnings("unchecked")
	public DescribeRegionResponse DescribeRegion(DescribeRegionRequest describeRegionRequest) throws KSYunServiceException, KSYunClientException {
        return gson.fromJson(this.request.execute("DescribeRegion", describeRegionRequest.toMap()), DescribeRegionResponse.class);
    }
    @SuppressWarnings("unchecked")
    public DescribeInstanceStatusResponse DescribeInstanceStatus(DescribeInstanceStatusRequest describeInstanceStatusRequest) throws KSYunClientException, KSYunServiceException {
    	return gson.fromJson(this.request.execute("DescribeInstanceStatus", describeInstanceStatusRequest.toMap()), DescribeInstanceStatusResponse.class);
    }
    @SuppressWarnings("unchecked")
    public DescribeInstanceResponse DescribeInstance(DescribeInstanceRequest describeInstanceRequest) throws KSYunClientException, KSYunServiceException {
        return gson.fromJson(this.request.execute("DescribeInstance", describeInstanceRequest.toMap()), DescribeInstanceResponse.class);
    }
    @SuppressWarnings("unchecked")
    public DescribeSystemInstanceImageResponse DescribeSystemInstanceImage(DescribeSystemInstanceImageRequest describeSystemInstanceImageRequest) throws KSYunClientException, KSYunServiceException {
        return gson.fromJson(this.request.execute("DescribeSystemInstanceImage", describeSystemInstanceImageRequest.toMap()), DescribeSystemInstanceImageResponse.class);
    }
    @SuppressWarnings("unchecked")
    public DescribeCustomInstanceImageResponse DescribeCustomInstanceImage(DescribeCustomInstanceImageRequest describeCustomInstanceImageRequest) throws KSYunClientException, KSYunServiceException {
    	return gson.fromJson(this.request.execute("DescribeCustomInstanceImage", describeCustomInstanceImageRequest.toMap()), DescribeCustomInstanceImageResponse.class);
    }
}

