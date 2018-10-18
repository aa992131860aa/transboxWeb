package org.transbox.entity;

import java.util.List;

public class TransferAnalysis {
    private List<String> trueNameList;
    private List<Integer> trueNameCountList;

    public List<String> getTrueNameList() {
        return trueNameList;
    }

    public void setTrueNameList(List<String> trueNameList) {
        this.trueNameList = trueNameList;
    }

    public List<Integer> getTrueNameCountList() {
        return trueNameCountList;
    }

    public void setTrueNameCountList(List<Integer> trueNameCountList) {
        this.trueNameCountList = trueNameCountList;
    }

    @Override
    public String toString() {
        return "TransferAnalysis{" +
                "trueNameList=" + trueNameList +
                ", trueNameCountList=" + trueNameCountList +
                '}';
    }
}
