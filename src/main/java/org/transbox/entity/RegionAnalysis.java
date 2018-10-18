package org.transbox.entity;

import java.util.List;

public class RegionAnalysis {

    private List<Integer> heartList;
    private List<Integer> liverList;
    private List<Integer> kidneyList;
    private List<Integer> lungList;
    private List<Integer> spleenList;
    private List<Integer> corneaList;
    private List<String> typeList;
    private List<String> provinceList;

    public List<Integer> getHeartList() {
        return heartList;
    }

    public void setHeartList(List<Integer> heartList) {
        this.heartList = heartList;
    }

    public List<Integer> getLiverList() {
        return liverList;
    }

    public void setLiverList(List<Integer> liverList) {
        this.liverList = liverList;
    }

    public List<Integer> getKidneyList() {
        return kidneyList;
    }

    public void setKidneyList(List<Integer> kidneyList) {
        this.kidneyList = kidneyList;
    }

    public List<Integer> getLungList() {
        return lungList;
    }

    public void setLungList(List<Integer> lungList) {
        this.lungList = lungList;
    }

    public List<Integer> getSpleenList() {
        return spleenList;
    }

    public void setSpleenList(List<Integer> spleenList) {
        this.spleenList = spleenList;
    }

    public List<Integer> getCorneaList() {
        return corneaList;
    }

    public void setCorneaList(List<Integer> corneaList) {
        this.corneaList = corneaList;
    }

    public List<String> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<String> typeList) {
        this.typeList = typeList;
    }

    public List<String> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<String> provinceList) {
        this.provinceList = provinceList;
    }

    @Override
    public String toString() {
        return "RegionAnalysis{" +
                "heartList=" + heartList +
                ", liverList=" + liverList +
                ", kidneyList=" + kidneyList +
                ", lungList=" + lungList +
                ", spleenList=" + spleenList +
                ", corneaList=" + corneaList +
                ", typeList=" + typeList +
                ", provinceList=" + provinceList +
                '}';
    }
}
