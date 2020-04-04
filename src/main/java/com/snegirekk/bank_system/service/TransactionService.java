package com.snegirekk.bank_system.service;

import com.snegirekk.bank_system.entity.Account;
import com.snegirekk.bank_system.entity.Transaction;
import com.snegirekk.bank_system.entity.TransactionParticipant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

@Service
public class TransactionService {

    private EntityManager entityManager;

    @Autowired
    public TransactionService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void transfer(Account sourceAccount, Account targetAccount, BigDecimal amount) throws Exception {

        if (sourceAccount.getAmount().compareTo(amount) < 0) {
            throw new Exception("Insufficient funds.");
        } else if (amount.compareTo(BigDecimal.valueOf(0)) <= 0) {
            throw new Exception("Only positive amounts are allowed.");
        }

        TransactionParticipant source = sourceAccount.getTransactionParticipant();
        TransactionParticipant target = targetAccount.getTransactionParticipant();

        sourceAccount.setAmount(sourceAccount.getAmount().subtract(amount));
        targetAccount.setAmount(targetAccount.getAmount().add(amount));

        entityManager.persist(sourceAccount);
        entityManager.persist(targetAccount);

        makeTransaction(source, target, amount);

        entityManager.flush();
    }

    public void deposit(TransactionParticipant source, Account account, BigDecimal amount) throws Exception {

        if (amount.compareTo(BigDecimal.valueOf(0)) <= 0) {
            throw new Exception("Only positive amounts are allowed.");
        }

        account.setAmount(account.getAmount().add(amount));
        entityManager.persist(account);

        makeTransaction(source, account.getTransactionParticipant(), amount);

        entityManager.flush();
    }

    public void pay(Account account, TransactionParticipant target, BigDecimal amount) throws Exception {

        if (account.getAmount().compareTo(amount) < 0) {
            throw new Exception("Insufficient funds.");
        } else if (amount.compareTo(BigDecimal.valueOf(0)) <= 0) {
            throw new Exception("Only positive amounts are allowed.");
        }

        account.setAmount(account.getAmount().subtract(amount));
        entityManager.persist(account);

        makeTransaction(account.getTransactionParticipant(), target, amount);

        entityManager.flush();
    }

    private void makeTransaction(TransactionParticipant source, TransactionParticipant target, BigDecimal amount) {

        Transaction transaction = new Transaction();
        transaction
                .setSource(source)
                .setTarget(target)
                .setAmount(amount);

        entityManager.persist(transaction);
    }
}
