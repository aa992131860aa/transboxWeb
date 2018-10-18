package org.transbox.entity;

public class TransferInfo {
    /**
     * 筛选条件  箱子  医院  时间  合并(合并时间不超过48小时)
     */
    private int id;
    private String organSeg;
    private String organ;
    private String transferPerson;
    private String fromCity;
    private String toHospName;
    private String getTime;
    private double avgT;
    private double maxAvg;
    private double minAvg;
    //实际持续的时间
    private String trueDurationTime;
    //处理后持续的时间
    private String correctDurationTime;
    private int open;
    private int collision;
    //行动的距离
    private double distance;
    private int power;
    private String boxNo;
    //是否隐藏的标识 0不隐藏   5通过网页端操作隐藏的箱子
    private int filterStatus;

    private String hospital;

    //是否显示合并框
    private boolean isShowMerge;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrganSeg() {
        return organSeg;
    }

    public void setOrganSeg(String organSeg) {
        this.organSeg = organSeg;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    public String getTransferPerson() {
        return transferPerson;
    }

    public void setTransferPerson(String transferPerson) {
        this.transferPerson = transferPerson;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToHospName() {
        return toHospName;
    }

    public void setToHospName(String toHospName) {
        this.toHospName = toHospName;
    }

    public String getGetTime() {
        return getTime;
    }

    public void setGetTime(String getTime) {
        this.getTime = getTime;
    }

    public double getAvgT() {
        return avgT;
    }

    public void setAvgT(double avgT) {
        this.avgT = avgT;
    }

    public double getMaxAvg() {
        return maxAvg;
    }

    public void setMaxAvg(double maxAvg) {
        this.maxAvg = maxAvg;
    }

    public double getMinAvg() {
        return minAvg;
    }

    public void setMinAvg(double minAvg) {
        this.minAvg = minAvg;
    }

    public String getTrueDurationTime() {
        return trueDurationTime;
    }

    public void setTrueDurationTime(String trueDurationTime) {
        this.trueDurationTime = trueDurationTime;
    }

    public String getCorrectDurationTime() {
        return correctDurationTime;
    }

    public void setCorrectDurationTime(String correctDurationTime) {
        this.correctDurationTime = correctDurationTime;
    }

    public int getOpen() {
        return open;
    }

    public void setOpen(int open) {
        this.open = open;
    }

    public int getCollision() {
        return collision;
    }

    public void setCollision(int collision) {
        this.collision = collision;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getBoxNo() {
        return boxNo;
    }

    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo;
    }

    public int getFilterStatus() {
        return filterStatus;
    }

    public void setFilterStatus(int filterStatus) {
        this.filterStatus = filterStatus;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public boolean isShowMerge() {
        return isShowMerge;
    }

    public void setShowMerge(boolean showMerge) {
        isShowMerge = showMerge;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
