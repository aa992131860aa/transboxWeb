package org.transbox.enums;

/**
 * 状态的常理字典
 */
public enum TransferWebStateEnum {
    SUCCESS(1, "获取成功"),
    NO_DATA(0,"没有数据"),
    NO_MORE(-1,"没有更多"),
    INNER_ERROR(-2,"内部错误"),
    DATA_REWRITE(-3,"数据篡改");


    private int state;
    private String stateInfo;

    TransferWebStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public static TransferWebStateEnum stateOf(int index) {
        for (TransferWebStateEnum seckillStateEnum : values()) {
            if (seckillStateEnum.getState() == index) {
                return seckillStateEnum;
            }
        }
        return null;
    }
}
