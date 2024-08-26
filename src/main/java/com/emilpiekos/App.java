package com.emilpiekos;

import java.security.InvalidKeyException;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        TransactionDao tdao = new TransactionDao();

        while (true) {
            UsersInOut.printOptions();
            Integer option = UsersInOut.inputNumber();
            switch (option) {
                case 1 -> {
                    tdao.insertTransaction();
                }
                case 2 -> {
                    tdao.updateTransaction();
                }
                case 3 -> {
                    tdao.deleteTransaction();
                }
                case 4 -> {
                    tdao.showTransactions("income");
                }
                case 5 -> {
                    tdao.showTransactions("outgo");
                }
                case 6 -> {
                    return;
                }
                default -> throw new RuntimeException("Invalid option");
            }
        }
    }
}