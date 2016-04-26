package com.fit2cloud.ksyun.instance.model;


/**
 * Created with IntelliJ IDEA.
 * User: zhcloud
 * Date: 11/10/14
 * Time: 2:42 PM
 * Email: zhcloud@fit2cloud.com
 */
public class Instance {

    private String CreationTime;
    private String InstanceId;
    private String InstanceName;
    private int CpuCount;
    private int MemSize; // unit : GB
    private String InternalIpAddress;
    private String PublicEipAddress;
    private String DataDiskType;
    private int DataDiskSize; // unit : GB
    private String ImageId;
    private String Status;
	public String getCreationTime() {
		return CreationTime;
	}
	public void setCreationTime(String creationTime) {
		CreationTime = creationTime;
	}
	public String getInstanceId() {
		return InstanceId;
	}
	public void setInstanceId(String instanceId) {
		InstanceId = instanceId;
	}
	public String getInstanceName() {
		return InstanceName;
	}
	public void setInstanceName(String instanceName) {
		InstanceName = instanceName;
	}
	public int getCpuCount() {
		return CpuCount;
	}
	public void setCpuCount(int cpuCount) {
		CpuCount = cpuCount;
	}
	public int getMemSize() {
		return MemSize;
	}
	public void setMemSize(int memSize) {
		MemSize = memSize;
	}
	public String getInternalIpAddress() {
		return InternalIpAddress;
	}
	public void setInternalIpAddress(String internalIpAddress) {
		InternalIpAddress = internalIpAddress;
	}
	public String getPublicEipAddress() {
		return PublicEipAddress;
	}
	public void setPublicEipAddress(String publicEipAddress) {
		PublicEipAddress = publicEipAddress;
	}
	public String getDataDiskType() {
		return DataDiskType;
	}
	public void setDataDiskType(String dataDiskType) {
		DataDiskType = dataDiskType;
	}
	public int getDataDiskSize() {
		return DataDiskSize;
	}
	public void setDataDiskSize(int dataDiskSize) {
		DataDiskSize = dataDiskSize;
	}
	public String getImageId() {
		return ImageId;
	}
	public void setImageId(String imageId) {
		ImageId = imageId;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
}
