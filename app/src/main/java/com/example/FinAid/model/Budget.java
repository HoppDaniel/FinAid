package com.example.FinAid.model;

import java.util.ArrayList;
import java.util.List;

public class Budget {
    private int id;
    private String name;
    private double totalAmount;
    private List<Transaction> transactions = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalAmount() {
        // This could be a method that calculates the total amount based on the transactions
        return calculateTotalAmount();
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
        calculateTotalAmount(); // We recalculate the total amount whenever we set the transactions
    }

    private double calculateTotalAmount() {
        double total = 0.0;
        for (Transaction transaction : transactions) {
            if ("Income".equals(transaction.getType())) {
                total += transaction.getAmount();
            } else if ("Expense".equals(transaction.getType())) {
                total -= transaction.getAmount();
            }
        }
        return total;
    }
}
