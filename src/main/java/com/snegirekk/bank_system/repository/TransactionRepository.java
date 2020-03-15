package com.snegirekk.bank_system.repository;

import com.snegirekk.bank_system.entity.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, UUID> {
}
