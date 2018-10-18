package org.transbox.entity;

import java.util.List;

public class Region {
    private String province;
    private String organ;
    private int organCount;


    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    public int getOrganCount() {
        return organCount;
    }

    public void setOrganCount(int organCount) {
        this.organCount = organCount;
    }

    @Override
    public String toString() {
        return "Region{" +
                "province='" + province + '\'' +
                ", organ='" + organ + '\'' +
                ", organCount='" + organCount + '\'' +
                '}';
    }
}
