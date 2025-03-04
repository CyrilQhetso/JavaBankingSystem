package com.onlinebanking;

import java.awt.*;
import javax.swing.*;

public class MainMenuGUI extends JFrame {
    public MainMenuGUI(Bank bank, Account account) {
        setTitle("Main Menu - Account: " + account.getAccountNumber());
        setSize(350, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        setLayout(new GridLayout(6, 1, 10, 10));

        JLabel lblBalance = new JLabel("Balance: $" + account.getBalance(), SwingConstants.CENTER);
        lblBalance.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblBalance);

        JButton btnDeposit = new JButton("Deposit");
        JButton btnWithdraw = new JButton("Withdraw");
        JButton btnTransfer = new JButton("Transfer");
        JButton btnHistory = new JButton("Transaction History");
        JButton btnLogout = new JButton("Logout");

        add(btnDeposit);
        add(btnWithdraw);
        add(btnTransfer);
        add(btnHistory);
        add(btnLogout);

        btnDeposit.addActionListener(e -> {
            new DepositGUI(bank, account);
            dispose();
        });

        btnWithdraw.addActionListener(e -> {
            new WithdrawGUI(bank, account);
            dispose();
        });

        btnTransfer.addActionListener(e -> {
            new TransferGUI(bank, account);
            dispose();
        });

        btnHistory.addActionListener(e -> {
            new TransactionHistoryGUI(bank, account); // Fix: Ensure this is called
            dispose();
        });

        btnLogout.addActionListener(e -> {
            new LoginGUI(bank);
            dispose();
        });

        setVisible(true);
    }
}