package com.atm.lld.service;

import com.atm.lld.database.AccountManager;
import com.atm.lld.database.CardManager;
import com.atm.lld.model.Account;
import com.atm.lld.model.Card;
import com.atm.lld.model.Transaction;

import java.util.ArrayList;
import java.util.List;

class ATMTestTest {

    private static ATM atm;

    public static void main(String[] args) {

        setUp();
    }

    public static void setUp(){


        AccountManager accManager = new AccountManager();
        CardManager cardManager = new CardManager();
        ATM atm = new ATM(accManager, cardManager);
        Card card = new Card("abdvcc", null, "2345");
        Account ac = new Account("SBI435635463", card);
        card.setAc(ac);
        ac.setCurrBalance(1000.0);

        atm.acManager.accMap.put("SBI435635463", ac);
        atm.cardmanager.cardMap.put("abdvcc", card);

        Double amt = atm.disAmmount("abdvcc", "2345", 400.0);

        System.out.println(amt);
        System.out.println(atm.checkAccountBal("SBI435635463"));

        List<Transaction> transactions = atm.showLastTran("SBI435635463", 5);


        System.out.println(transactions);

    }
}