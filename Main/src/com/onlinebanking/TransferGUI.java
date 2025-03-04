package com.onlinebanking;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferGUI extends JFrame {
    public TransferGUI(Bank bank, Account account) {
        setTitle("Transfer - Account: " + account.getAccountNumber());
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblTargetAccount = new JLabel("Target Account No:");
        lblTargetAccount.setBounds(20, 30, 150, 25);
        add(lblTargetAccount);

        JTextField txtTargetAccount = new JTextField();
        txtTargetAccount.setBounds(170, 30, 120, 25);
        add(txtTargetAccount);

        JLabel lblAmount = new JLabel("Transfer Amount:");
        lblAmount.setBounds(20, 70, 150, 25);
        add(lblAmount);

        JTextField txtAmount = new JTextField();
        txtAmount.setBounds(170, 70, 120, 25);
        add(txtAmount);

        JButton btnTransfer = new JButton("Transfer");
        btnTransfer.setBounds(50, 120, 100, 25);
        add(btnTransfer);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(170, 120, 90, 25);
        add(btnBack);

        btnTransfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int targetAccNo = Integer.parseInt(txtTargetAccount.getText());
                    double amount = Double.parseDouble(txtAmount.getText());

                    Account targetAccount = bank.getAccount(targetAccNo);
                    if (targetAccount != null && amount > 0 && account.transfer(targetAccount, amount)) {
                        JOptionPane.showMessageDialog(null, "Transfer Successful! New Balance: $" + account.getBalance());
                        new MainMenuGUI(bank, account);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid account or insufficient funds.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Enter numeric values.");
                }
            }
        });

        btnBack.addActionListener(e -> {
            new MainMenuGUI(bank, account);
            dispose();
        });

        setVisible(true);
    }
}