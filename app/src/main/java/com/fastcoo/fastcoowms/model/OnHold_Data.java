package com.fastcoo.fastcoowms.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OnHold_Data {

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
    @SerializedName("onHold")
    @Expose
    private String onHold;
    @SerializedName("schedule_date")
    @Expose
    private String scheduleDate;
    @SerializedName("time_slot")
    @Expose
    private String timeSlot;
    @SerializedName("destination")
    @Expose
    private String destination;
    @SerializedName("origin")
    @Expose
    private String origin;

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

    public String getOnHold() {
        return onHold;
    }

    public void setOnHold(String onHold) {
        this.onHold = onHold;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
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
}
