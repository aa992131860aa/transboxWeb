package org.transbox.entity;

public class TransferPerson {
    private String phone;
    private String trueName;
    private String photoUrl;
    private int total;
    private int allTotal;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAllTotal() {
        return allTotal;
    }

    public void setAllTotal(int allTotal) {
        this.allTotal = allTotal;
    }

    @Override
    public String toString() {
        return "TransferPerson{" +
                "phone='" + phone + '\'' +
                ", trueName='" + trueName + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", total=" + total +
                ", allTotal=" + allTotal +
                '}';
    }
}
