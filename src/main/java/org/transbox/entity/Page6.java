package org.transbox.entity;

public class Page6 {
    //  {'color': '#4EBFFD', 'y': 11, name: 'gg'},
    private String color;
    private long y;
    private String name;
    private int ratio;

    //是否为其中最大的值
    private int flag;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Page6() {

    }

    public Page6(String color, long y, String name, int ratio, int flag) {
        this.color = color;
        this.y = y;
        this.name = name;
        this.ratio = ratio;
        this.flag = flag;
    }

}
