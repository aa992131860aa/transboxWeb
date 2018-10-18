package org.transbox.entity;

public class Page4 {
    private String name;
    private int num;
    private int ratio;
    private int flag;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getRatio() {
        return ratio;
    }

    public void setRatio(int ratio) {
        this.ratio = ratio;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Page4() {

    }

    public Page4(String name, int num, int ratio) {
        this.name = name;
        this.num = num;
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        return "Page4{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", ratio=" + ratio +
                '}';
    }
}
