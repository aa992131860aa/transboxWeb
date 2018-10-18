package org.transbox.entity;

public class ReportList {
    private String time;
    private String name;
    private Hospital hospital;

    public ReportList(String time, String name, Hospital hospital) {
        this.time = time;
        this.name = name;
        this.hospital = hospital;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
