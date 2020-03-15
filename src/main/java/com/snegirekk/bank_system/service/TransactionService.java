package com.snegirekk.bank_system.service;

import com.snegirekk.bank_system.entity.Account;
import com.snegirekk.bank_system.entity.Transaction;
import com.snegirekk.bank_system.entity.TransactionParticipant;
import com.snegirekk.bank_system.repository.AccountRepository;
import com.snegirekk.bank_system.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;
    private AccountRepository accountRepository;
    private DataSource dataSource;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository, DataSource dataSource) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.dataSource = dataSource;
    }

    public void transfer(Account sourceAccount, Account targetAccount, BigDecimal amount) throws Exception {

        if (sourceAccount.getAmount().compareTo(amount) < 0) {
            throw new Exception("Insufficient funds.");
        } else if (amount.compareTo(BigDecimal.valueOf(0)) <= 0) {
            throw new Exception("Only positive amounts are allowed.");
        }

        TransactionParticipant source = sourceAccount.getTransactionParticipant();
        TransactionParticipant target = targetAccount.getTransactionParticipant();

        Connection connection = dataSource.getConnection();

        try {
            connection.setAutoCommit(false);

            sourceAccount.setAmount(sourceAccount.getAmount().subtract(amount));
            targetAccount.setAmount(targetAccount.getAmount().add(amount));

            accountRepository.save(sourceAccount);
            accountRepository.save(targetAccount);

            makeTransaction(source, target, amount);

            connection.commit();
        } catch (Throwable error) {
            connection.rollback();
            throw error;
        }
    }

    public void deposit(TransactionParticipant source, Account account, BigDecimal amount) throws Exception {

        if (amount.compareTo(BigDecimal.valueOf(0)) <= 0) {
            throw new Exception("Only positive amounts are allowed.");
        }

        Connection connection = dataSource.getConnection();

        try {
            connection.setAutoCommit(false);

            account.setAmount(account.getAmount().add(amount));

            accountRepository.save(account);

            makeTransaction(source, account.getTransactionParticipant(), amount);

            connection.commit();
        } catch (Throwable error) {
            connection.rollback();
            throw error;
        }
    }

    public void pay(Account account, TransactionParticipant target, BigDecimal amount) throws Exception {

        if (account.getAmount().compareTo(amount) < 0) {
            throw new Exception("Insufficient funds.");
        } else if (amount.compareTo(BigDecimal.valueOf(0)) <= 0) {
            throw new Exception("Only positive amounts are allowed.");
        }

        Connection connection = dataSource.getConnection();

        try {
            connection.setAutoCommit(false);

            account.setAmount(account.getAmount().subtract(amount));

            accountRepository.save(account);

            makeTransaction(account.getTransactionParticipant(), target, amount);

            connection.commit();
        } catch (Throwable error) {
            connection.rollback();
            throw error;
        }
    }

    private void makeTransaction(TransactionParticipant source, TransactionParticipant target, BigDecimal amount) {

        Transaction transaction = new Transaction();
        transaction
                .setSource(source)
                .setTarget(target)
                .setAmount(amount);

        transactionRepository.save(transaction);
    }
}
