package com.atm.lld.model;

public class Card {
    private String cardId;
    private String cardPIN;
    private Account ac;

    public String getCardId() {
        return cardId;
    }

    public String getCardPIN() {
        return cardPIN;
    }

    public Account getAc() {
        return ac;
    }

    public void setAc(Account ac) {
        this.ac = ac;
    }



    public Card(final String cardId, final Account ac, final String cardPIN){
        this.cardId = cardId;
        this.ac = ac;
        this.cardPIN = cardPIN;
    }

  public boolean validateAndUpdateCardPinAgainstNewPin(String oldPin, String newPin){
        if(oldPin.equals(this.cardPIN)){
            changeCardPIN(newPin);
            return true;
        }
        return false;
  }

  private void changeCardPIN(String newPin){
        this.cardPIN = newPin;
  }

  public boolean validatePin(String cardPIN){
        return this.cardPIN == cardPIN;
  }

}
