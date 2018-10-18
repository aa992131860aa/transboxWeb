package org.transbox.entity;

public class Page3 {
    //  {'color': '#4EBFFD', 'y': 11, name: 'gg'},
    private String color;
    private long value;
    private String name;

    private int ratio;

    //是否为其中最大的值
    private int flag;

    private String address;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Page3() {

    }

    @Override
    public String toString() {
        return "Page3{" +
                "color='" + color + '\'' +
                ", value=" + value +
                ", name='" + name + '\'' +
                ", ratio=" + ratio +
                ", flag=" + flag +
                '}';
    }

    public Page3(String color, long value, String name, int ratio, int flag) {
        this.color = color;
        this.value = value;
        this.name = name;
        this.ratio = ratio;
        this.flag = flag;
    }
    public Page3(String color, long value, String name, int ratio, int flag,String address) {
        this.color = color;
        this.value = value;
        this.name = name;
        this.ratio = ratio;
        this.flag = flag;
        this.address = address;
    }

}
