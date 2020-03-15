package com.snegirekk.bank_system.repository;

import com.snegirekk.bank_system.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, UUID> {

    @Override
    Iterable<Customer> findAll();
}
