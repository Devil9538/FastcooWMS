package com.fastcoo.fastcoowms.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OnHold_Status {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private OnHold_Data data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public OnHold_Data getData() {
        return data;
    }

    public void setData(OnHold_Data data) {
        this.data = data;
    }
}
