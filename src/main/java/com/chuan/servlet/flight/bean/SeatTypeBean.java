package com.chuan.servlet.flight.bean;

public class SeatTypeBean {
    private int seatTypeId;
    private String seatTypeName;

    public SeatTypeBean(int seatTypeId, String seatTypeName) {
        this.seatTypeId = seatTypeId;
        this.seatTypeName = seatTypeName;
    }

    @Override
    public String toString() {
        return "SeatTypeBean{" +
                "seatTypeId=" + seatTypeId +
                ", seatTypeName='" + seatTypeName + '\'' +
                '}';
    }

    public int getSeatTypeId() {
        return seatTypeId;
    }

    public void setSeatTypeId(int seatTypeId) {
        this.seatTypeId = seatTypeId;
    }

    public String getSeatTypeName() {
        return seatTypeName;
    }

    public void setSeatTypeName(String seatTypeName) {
        this.seatTypeName = seatTypeName;
    }
}
