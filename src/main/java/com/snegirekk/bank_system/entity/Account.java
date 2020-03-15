package com.snegirekk.bank_system.entity;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Account {

    @Id
    private UUID id;
    private Customer customer;
    private TransactionParticipant transactionParticipant;
    private BigDecimal amount;

    public Account() {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public Account setId(UUID id) {
        this.id = id;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Account setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public TransactionParticipant getTransactionParticipant() {
        return transactionParticipant;
    }

    public Account setTransactionParticipant(TransactionParticipant transactionParticipant) {
        this.transactionParticipant = transactionParticipant;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Account setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id.equals(account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
