package org.transbox.entity;

public class Page7 {

    //y: 12.8,
    // sliced: true,
    // selected: true,
    private long y;
    private String name;
    private boolean sliced;
    private boolean selected;
    private int total;


    public boolean isSliced() {
        return sliced;
    }

    public void setSliced(boolean sliced) {
        this.sliced = sliced;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Page7() {

    }

    @Override
    public String toString() {
        return "Page7{" +
                "y=" + y +
                ", name='" + name + '\'' +
                ", sliced=" + sliced +
                ", selected=" + selected +
                ", total=" + total +
                '}';
    }
}
