package com.onlinebanking;

import java.awt.*;
import java.util.List;
import javax.swing.*;

public class TransactionHistoryGUI extends JFrame {
    public TransactionHistoryGUI(Bank bank, Account account) {
        setTitle("Transaction History - Account: " + account.getAccountNumber());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        setLayout(new BorderLayout());

        JLabel lblTitle = new JLabel("Transaction History", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblTitle, BorderLayout.NORTH);

        // Fetch transactions
        List<String> transactions = account.getTransactionHistory();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String transaction : transactions) {
            listModel.addElement(transaction);
        }

        // Display transaction list
        JList<String> transactionList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(transactionList);
        add(scrollPane, BorderLayout.CENTER);

        // Back button
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(e -> {
            new MainMenuGUI(bank, account);
            dispose();
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(btnBack);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}