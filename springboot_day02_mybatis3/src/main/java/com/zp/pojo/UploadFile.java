package com.zp.pojo;
import java.util.Date;
/**
 *
 * @author zhaopeng
 * <p>Description:文件上传的实体类</p>  
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class UploadFile{
    private Integer fileId;
    private String fileName;
    private String fileDescription;
    private String fileSize;
    private String fileUrl;
    private Date createTime;
    private Integer uploadCount;
	@Override
	public String toString() {
		return "UploadFile [fileId=" + fileId + ", fileName=" + fileName + ", fileDescription=" + fileDescription
				+ ", fileSize=" + fileSize + ", fileUrl=" + fileUrl + ", createTime=" + createTime + ", uploadCount="
				+ uploadCount + "]";
	}
	public UploadFile() {
		super();
	}
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileDescription() {
		return fileDescription;
	}
	public void setFileDescription(String fileDescription) {
		this.fileDescription = fileDescription;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getUploadCount() {
		return uploadCount;
	}
	public void setUploadCount(Integer uploadCount) {
		this.uploadCount = uploadCount;
	}
    
}