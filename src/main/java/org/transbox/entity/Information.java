package org.transbox.entity;

import java.sql.Timestamp;

public class Information {
    private int id;
    private String fileNo;
    private String fileName;
    private String createTime;
    private int downloadNum;
    private String fileUrl;

    public Information() {

    }

    //id,file_no,file_name,file_url,create_time,download_num
    public Information(int id, String fileNo, String fileName, String fileUrl, String createTime, int downloadNum) {
        this.id = id;
        this.fileNo = fileNo;
        this.fileName = fileName;
        this.createTime = createTime;
        this.downloadNum = downloadNum;
        this.fileUrl = fileUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileNo() {
        return fileNo;
    }

    public void setFileNo(String fileNo) {
        this.fileNo = fileNo;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getDownloadNum() {
        return downloadNum;
    }

    public void setDownloadNum(int downloadNum) {
        this.downloadNum = downloadNum;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public String toString() {
        return "Information{" +
                "id=" + id +
                ", fileNo='" + fileNo + '\'' +
                ", fileName='" + fileName + '\'' +
                ", createTime=" + createTime +
                ", downloadNum=" + downloadNum +
                ", fileUrl='" + fileUrl + '\'' +
                '}';
    }
}
