package com.fastcoo.fastcoowms.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Schedule_Data {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("Awb")
    @Expose
    private String awb;
    @SerializedName("onHold_Confirm")
    @Expose
    private String onHoldConfirm;
    @SerializedName("shelv_no")
    @Expose
    private String shelvNo;
    @SerializedName("Schedule")
    @Expose
    private String schedule;
    @SerializedName("schedule_date")
    @Expose
    private String scheduleDate;
    @SerializedName("messanger_id")
    @Expose
    private String messangerId;
    @SerializedName("destination")
    @Expose
    private String destination;
    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("driver_code")
    @Expose
    private String driverCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAwb() {
        return awb;
    }

    public void setAwb(String awb) {
        this.awb = awb;
    }

    public String getOnHoldConfirm() {
        return onHoldConfirm;
    }

    public void setOnHoldConfirm(String onHoldConfirm) {
        this.onHoldConfirm = onHoldConfirm;
    }

    public String getShelvNo() {
        return shelvNo;
    }

    public void setShelvNo(String shelvNo) {
        this.shelvNo = shelvNo;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getMessangerId() {
        return messangerId;
    }

    public void setMessangerId(String messangerId) {
        this.messangerId = messangerId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDriverCode() {
        return driverCode;
    }

    public void setDriverCode(String driverCode) {
        this.driverCode = driverCode;
    }}
