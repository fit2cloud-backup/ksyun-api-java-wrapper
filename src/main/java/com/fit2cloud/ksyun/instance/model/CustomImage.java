package com.fit2cloud.ksyun.instance.model;

public class CustomImage {
	private String ImageId;
	private String InstanceId;
	private String CreationTime;
	private String Status;
	private String OsVersion;
	private String ImageName;
	private int Progress;
	public String getImageId() {
		return ImageId;
	}
	public void setImageId(String imageId) {
		ImageId = imageId;
	}
	public String getInstanceId() {
		return InstanceId;
	}
	public void setInstanceId(String instanceId) {
		InstanceId = instanceId;
	}
	public String getCreationTime() {
		return CreationTime;
	}
	public void setCreationTime(String creationTime) {
		CreationTime = creationTime;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getOsVersion() {
		return OsVersion;
	}
	public void setOsVersion(String osVersion) {
		OsVersion = osVersion;
	}
	public String getImageName() {
		return ImageName;
	}
	public void setImageName(String imageName) {
		ImageName = imageName;
	}
	public int getProgress() {
		return Progress;
	}
	public void setProgress(int progress) {
		Progress = progress;
	}
}
