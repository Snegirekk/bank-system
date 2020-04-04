package com.snegirekk.bank_system.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "transaction_participants")
public class TransactionParticipant {

    @Id
    private UUID id;

    @Column
    @Enumerated(EnumType.STRING)
    private Type type;

    public TransactionParticipant() {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public TransactionParticipant setId(UUID id) {
        this.id = id;
        return this;
    }

    public Type getType() {
        return type;
    }

    public TransactionParticipant setType(Type type) {
        this.type = type;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionParticipant that = (TransactionParticipant) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public enum Type {
        ACCOUNT
    }
}
