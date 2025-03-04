package com.onlinebanking;

import javax.swing.SwingUtilities;

public class BankingGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Bank bank = new Bank();
            new LoginGUI(bank);
        });
    }
}