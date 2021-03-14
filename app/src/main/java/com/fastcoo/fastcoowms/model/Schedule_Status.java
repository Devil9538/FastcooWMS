package com.fastcoo.fastcoowms.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Schedule_Status {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private Schedule_Data data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Schedule_Data getData() {
        return data;
    }

    public void setData(Schedule_Data data) {
        this.data = data;
    }
}
