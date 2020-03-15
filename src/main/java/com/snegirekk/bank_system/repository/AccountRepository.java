package com.snegirekk.bank_system.repository;

import com.snegirekk.bank_system.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends CrudRepository<Account, UUID> {

    Iterable<Account> findAllByCustomerId(UUID customerId);
}
