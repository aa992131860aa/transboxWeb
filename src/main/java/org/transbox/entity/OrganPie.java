package org.transbox.entity;

public class OrganPie {
    private String name;
    private int y;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public OrganPie(String name, int y, String color) {
        this.name = name;
        this.y = y;
        this.color = color;
    }
}
