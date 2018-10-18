package org.transbox.entity;

import java.util.List;

public class OrganAnalysis {
    private List<String> organ;
    private List<Integer> organCount;
    private List<OrganPie> organList;

    public List<String> getOrgan() {
        return organ;
    }

    public void setOrgan(List<String> organ) {
        this.organ = organ;
    }

    public List<Integer> getOrganCount() {
        return organCount;
    }

    public void setOrganCount(List<Integer> organCount) {
        this.organCount = organCount;
    }

    public List<OrganPie> getOrganList() {
        return organList;
    }

    public void setOrganList(List<OrganPie> organList) {
        this.organList = organList;
    }

    @Override
    public String toString() {
        return "OrganAnalysis{" +
                "organ=" + organ +
                ", organCount=" + organCount +
                ", organList=" + organList +
                '}';
    }
}
