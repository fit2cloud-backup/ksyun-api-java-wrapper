package com.fit2cloud.ksyun;

import junit.framework.TestCase;

import org.junit.Test;

import com.fit2cloud.ksyun.exceptions.KSYunClientException;
import com.fit2cloud.ksyun.exceptions.KSYunServiceException;
import com.fit2cloud.ksyun.instance.requests.DescribeCustomInstanceImageRequest;
import com.fit2cloud.ksyun.instance.requests.DescribeInstanceRequest;
import com.fit2cloud.ksyun.instance.requests.DescribeInstanceStatusRequest;
import com.fit2cloud.ksyun.instance.requests.DescribeRegionRequest;
import com.fit2cloud.ksyun.instance.requests.DescribeSystemInstanceImageRequest;
import com.fit2cloud.ksyun.instance.responses.DescribeCustomInstanceImageResponse;
import com.fit2cloud.ksyun.instance.responses.DescribeInstanceResponse;
import com.fit2cloud.ksyun.instance.responses.DescribeInstanceStatusResponse;
import com.fit2cloud.ksyun.instance.responses.DescribeRegionResponse;
import com.fit2cloud.ksyun.instance.responses.DescribeSystemInstanceImageResponse;
import com.google.gson.Gson;

/**
 * Created by chixq on 8/17/15.
 */
public class InstanceTest extends TestCase {
	private KSYunClient client;
	private String instanceId = "YOUR_INSTANCE_ID";
    private String region = "cn-shanghai-1";
    @Override
    public void setUp() throws Exception {
        String secretId = "YOUR_SECRET_ID";
        String secretKey = "YOUR_SECRET_KEY";
        KSYunCredential cloudCredential = new KSYunCredential(secretId, secretKey);
        client = new KSYunClient(cloudCredential, "api.ksyun.com/");
    }

    @Override
    public void tearDown() throws Exception {
    }

    @Test
    public void testDescribeRegionList() throws Exception {
        DescribeRegionRequest request = new DescribeRegionRequest();
        DescribeRegionResponse response = client.DescribeRegion(request);
        System.out.println(new Gson().toJson(response));
    }

    @Test
    public void testDescribeInstanceStatus() throws KSYunClientException, KSYunServiceException {
    	DescribeInstanceStatusRequest describeInstanceStatusRequest = new DescribeInstanceStatusRequest();
        describeInstanceStatusRequest.setRegion(region);
        DescribeInstanceStatusResponse describeInstanceStatusResponse = client.DescribeInstanceStatus(describeInstanceStatusRequest);
        System.out.println(new Gson().toJson(describeInstanceStatusResponse));
    }
    
    @Test
    public void testDescribeInstance() throws KSYunClientException, KSYunServiceException {
    	DescribeInstanceRequest describeInstanceRequest = new DescribeInstanceRequest();
    	describeInstanceRequest.setRegion(region);
    	describeInstanceRequest.setInstanceId(instanceId);
    	DescribeInstanceResponse describeInstanceResponse = client.DescribeInstance(describeInstanceRequest);
    	System.out.println(new Gson().toJson(describeInstanceResponse));
    }

    @Test
    public void testDescribeSystemInstanceImage() throws KSYunClientException, KSYunServiceException {
        DescribeSystemInstanceImageRequest describeImagesRequest = new DescribeSystemInstanceImageRequest();
        describeImagesRequest.setRegion(region);
        DescribeSystemInstanceImageResponse describeSystemInstanceImageResponse = client.DescribeSystemInstanceImage(describeImagesRequest);
        System.out.println(new Gson().toJson(describeSystemInstanceImageResponse));
    }
    
    @Test
    public void testDescribeCustomInstanceImage() throws KSYunClientException, KSYunServiceException {
    	DescribeCustomInstanceImageRequest describeImagesRequest = new DescribeCustomInstanceImageRequest();
    	describeImagesRequest.setRegion(region);
    	DescribeCustomInstanceImageResponse describeCustomInstanceImageResponse = client.DescribeCustomInstanceImage(describeImagesRequest);
    	System.out.println(new Gson().toJson(describeCustomInstanceImageResponse));
    }
}
