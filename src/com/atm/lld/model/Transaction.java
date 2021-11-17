package com.atm.lld.model;

import java.sql.Timestamp;

public class Transaction {

    private String acId;
    private Timestamp tranTime;
    private Double closingBal;
    private Double widrawalAmt;

    @Override
    public String toString() {
        return "Transaction{" +
                "acId='" + acId + '\'' +
                ", tranTime=" + tranTime +
                ", closingBal=" + closingBal +
                ", widrawalAmt=" + widrawalAmt +
                '}';
    }

    public Transaction(String acId, Timestamp tranTime, Double closingBal, Double widrawalAmt) {
        this.acId = acId;
        this.tranTime = tranTime;
        this.closingBal = closingBal;
        this.widrawalAmt = widrawalAmt;
    }

}
