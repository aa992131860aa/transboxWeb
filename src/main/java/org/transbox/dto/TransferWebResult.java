package org.transbox.dto;

import org.transbox.enums.TransferWebStateEnum;

public class TransferWebResult<T> {
    private boolean success;
    private T data;
    private TransferWebStateEnum transferWebStateEnum;

    public TransferWebResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public TransferWebResult(boolean success, TransferWebStateEnum transferWebStateEnum) {
        this.success = success;
        this.transferWebStateEnum = transferWebStateEnum;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TransferWebStateEnum getTransferWebStateEnum() {
        return transferWebStateEnum;
    }

    public void setTransferWebStateEnum(TransferWebStateEnum transferWebStateEnum) {
        this.transferWebStateEnum = transferWebStateEnum;
    }

    @Override
    public String toString() {
        return "TransferWebResult{" +
                "success=" + success +
                ", data=" + data +
                ", transferWebStateEnum=" + transferWebStateEnum +
                '}';
    }
}
