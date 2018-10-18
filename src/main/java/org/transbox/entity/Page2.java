package org.transbox.entity;

public class Page2 {
    private int y;
    private String name;

    private int z;

    public Page2(){
    }
    public Page2(int y, String name, int z) {
        this.y = y;
        this.name = name;
        this.z = z;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Page2{" +
                "y=" + y +
                ", name='" + name + '\'' +
                ", z=" + z +
                '}';
    }
}
