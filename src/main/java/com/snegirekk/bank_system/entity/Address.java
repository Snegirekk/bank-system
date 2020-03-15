package com.snegirekk.bank_system.entity;

import org.springframework.data.annotation.Id;

import java.util.Objects;
import java.util.UUID;

public class Address {

    @Id
    private UUID id;
    private String country;
    private String locality;
    private String province;
    private String address1;
    private String address2;
    private String postCode;

    public Address() {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public Address setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Address setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getLocality() {
        return locality;
    }

    public Address setLocality(String locality) {
        this.locality = locality;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public Address setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getAddress1() {
        return address1;
    }

    public Address setAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public String getAddress2() {
        return address2;
    }

    public Address setAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public String getPostCode() {
        return postCode;
    }

    public Address setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return country.equals(address.country) &&
                locality.equals(address.locality) &&
                Objects.equals(province, address.province) &&
                address1.equals(address.address1) &&
                Objects.equals(address2, address.address2) &&
                postCode.equals(address.postCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, locality, province, address1, address2, postCode);
    }
}
