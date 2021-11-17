package com.atm.lld.service;

import com.atm.lld.database.AccountManager;
import com.atm.lld.database.CardManager;
import com.atm.lld.model.Account;
import com.atm.lld.model.Card;
import com.atm.lld.model.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ATM {
    private static Map<String, List<Transaction>> tranMap = new HashMap<>();
    public AccountManager acManager;
    public CardManager cardmanager;

    public ATM(final AccountManager acManager, final CardManager cardmanager){
       this.cardmanager = cardmanager;
       this.acManager = acManager;

    }

    public List<Transaction> showLastTran(String accountNo, Integer last){

        List<Transaction> result = new ArrayList<>();
        if(!tranMap.containsKey(accountNo)){
            throw new RuntimeException("No A/C found");
        }
        List<Transaction> allVal = tranMap.get(accountNo);
        int index = allVal.size()-1;
        while(last >=0 || index >=0){
            result.add(allVal.get(index--));
            last--;
        }
        return result;
    }

    public Double checkAccountBal(String accountNo){

        if(!acManager.accMap.containsKey(accountNo)){
            throw new RuntimeException("No A/C found");
        }
        return acManager.accMap.get(accountNo).getLatestBal();
    }

    public boolean changePin(String cardId, String oldPin, String newPin){
        if(!cardmanager.cardMap.containsKey(cardId)){
            throw new RuntimeException("No Card found");
        }
        Card card = cardmanager.cardMap.get(cardId);
        if(card.validateAndUpdateCardPinAgainstNewPin(oldPin, newPin)){
            return true;
        }
        else{
            throw new RuntimeException("PIN validation failed");
        }
        //card.validateAndUpdateCardPinAgainstNewPin(oldPin, newPin) == true ? return true : throw new RuntimeException("PIN validation failed");
    }

    public Double disAmmount(String cardId, String cardPin, Double requestedAmmount){
        Card card = cardmanager.cardMap.get(cardId);
        if(card.validatePin(cardPin)){
            if(!card.getAc().validateAmount(requestedAmmount)){
                throw new RuntimeException("Insuffecient A/C Balance");
            }
            card.getAc().updateCurrBalance(requestedAmmount);
            return requestedAmmount;
        }
        else{
            throw new RuntimeException("PIN is incorrect");
        }

    }

}
