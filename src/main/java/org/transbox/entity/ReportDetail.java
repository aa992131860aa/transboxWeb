package org.transbox.entity;

public class ReportDetail {
    private int id;
    private String organSeg;
    private String organ;
    private String transferPerson;
    private String fromCity;
    private String toHospName;
    private String getTime;
    private double avgT;
    private int open;
    private int collision;

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
}
