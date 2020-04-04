package com.snegirekk.bank_system.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    private UUID id;

    @OneToOne(targetEntity = TransactionParticipant.class)
    private TransactionParticipant source;

    @OneToOne(targetEntity = TransactionParticipant.class)
    private TransactionParticipant target;

    @Column
    private BigDecimal amount;

    public Transaction() {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public Transaction setId(UUID id) {
        this.id = id;
        return this;
    }

    public TransactionParticipant getSource() {
        return source;
    }

    public Transaction setSource(TransactionParticipant source) {
        this.source = source;
        return this;
    }

    public TransactionParticipant getTarget() {
        return target;
    }

    public Transaction setTarget(TransactionParticipant target) {
        this.target = target;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Transaction setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
