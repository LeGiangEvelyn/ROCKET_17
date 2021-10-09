package com.vti.backend;

import com.vti.entity.Account;

import java.time.LocalDate;

public class Exercise2 {
    public static void main(String[] args) {
        question1();
    }

    private static void question1() {
        //create Array  insist of 5 Accounts
        Account[] accounts = new Account[5];
        for (int i = 0; i < accounts.length; i++) {
            Account acc = new Account();
            acc.email = "Email " + i;
            acc.userName = "User name " + i;
            acc.fullName = "Full name " + i;
            acc.createDate = LocalDate.now();
            accounts[i] = acc;
            System.out.println(
                    "Account " + i + " Email: " + accounts[i].email + " UserName: " + accounts[i].userName
                            + " FullName: " + accounts[i].fullName + " CreateDate: " + accounts[i].createDate);
        }
    }
}
