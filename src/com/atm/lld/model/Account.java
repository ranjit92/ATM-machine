package com.atm.lld.model;

public class Account {
    private String acId;
    private Card card;
    private Double currBalance;

    public void setCurrBalance(Double currBalance) {
        this.currBalance = currBalance;
    }


    public Account(final String acId, final Card card){
        this.acId = acId;
        this.card = card;
    }

    public boolean validateAmount(Double requestAmount){
          if(this.currBalance >= requestAmount){
              return true;
          }
          return false;
    }

    public void updateCurrBalance(Double widrawalAmt){
        this.currBalance -= widrawalAmt;
    }

    public Double getLatestBal(){
        return this.currBalance;
    }

}
