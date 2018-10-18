package org.transbox.entity;

public class Transfer {

    private String trueName;
    private int trueNameCount;

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public int getTrueNameCount() {
        return trueNameCount;
    }

    public void setTrueNameCount(int trueNameCount) {
        this.trueNameCount = trueNameCount;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "trueName='" + trueName + '\'' +
                ", trueNameCount=" + trueNameCount +
                '}';
    }

}
