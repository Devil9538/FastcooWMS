package com.fastcoo.fastcoowms.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Loginmodel {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("result")
    @Expose
    private Login_Result result;

    /**
     * No args constructor for use in serialization
     *
     */
    public Loginmodel() {
    }

    /**
     *
     * @param result
     * @param status
     */
    public Loginmodel(Integer status, Login_Result result) {
        super();
        this.status = status;
        this.result = result;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Login_Result getResult() {
        return result;
    }

    public void setResult(Login_Result result) {
        this.result = result;
    }
}
