package com.zhihuishu.athomework.dto;

import java.io.Serializable;
import java.sql.Date;

public class HomeworkDirFileDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long homeworkId;

    private Long fileId;

    private String fileTitle;

    private Integer fileSize;

    private String fileUrl;

    private Date uploadTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Long homeworkId) {
        this.homeworkId = homeworkId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFileTitle() {
        return fileTitle;
    }

    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Override
    public String toString() {
        return "HomeworkDirFileDto{" +
                "id=" + id +
                ", homeworkId=" + homeworkId +
                ", fileId=" + fileId +
                ", fileTitle='" + fileTitle + '\'' +
                ", fileSize=" + fileSize +
                ", fileUrl='" + fileUrl + '\'' +
                ", uploadTime=" + uploadTime +
                '}';
    }
}
