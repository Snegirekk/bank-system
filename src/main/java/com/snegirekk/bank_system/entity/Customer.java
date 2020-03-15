package com.snegirekk.bank_system.entity;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Customer {

    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private Account account;
    private Address address;
    private LocalDate birthday;

    public Customer() {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public Customer setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Customer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Customer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Account getAccount() {
        return account;
    }

    public Customer setAccount(Account account) {
        this.account = account;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Customer setAddress(Address address) {
        this.address = address;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Customer setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
