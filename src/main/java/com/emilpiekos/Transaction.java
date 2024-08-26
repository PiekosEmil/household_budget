package com.emilpiekos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private Type type;
    private String description;
    private BigDecimal amount;
    private LocalDateTime transactionDate;

    public Transaction(Type type, String description, BigDecimal amount, LocalDateTime transactionDate) {
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}


//                    id INT PRIMARY KEY AUTO_INCREMENT,
//                    type ENUM('income', 'outgo') NOT NULL,
//                    description varchar(100),
//                    amount decimal(6, 2),
//                    data datetime