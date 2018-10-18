package org.transbox.entity;

public class Organ {
    private String organ;
    private int organCount;

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

    public Organ(String organ, int organCount) {
        this.organ = organ;
        this.organCount = organCount;
    }

    public Organ() {

    }

    @Override
    public String toString() {
        return "Organ{" +
                "organ='" + organ + '\'' +
                ", organCount=" + organCount +
                '}';
    }
}
