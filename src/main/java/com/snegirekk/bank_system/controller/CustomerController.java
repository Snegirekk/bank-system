package com.snegirekk.bank_system.controller;

import com.snegirekk.bank_system.entity.Account;
import com.snegirekk.bank_system.entity.Customer;
import com.snegirekk.bank_system.repository.AccountRepository;
import com.snegirekk.bank_system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
public class CustomerController {

    private CustomerRepository customerRepository;
    private AccountRepository accountRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    @GetMapping(path = "/")
    public String index(ModelMap model) {
        List<Customer> customers = customerRepository.findAll();
        model.addAttribute("customers", customers);
        return "index";
    }

    @GetMapping(path = "/customer/{customerId}/get-accounts")
    @ResponseBody
    public List<Account> getCustomerAccounts(@PathVariable UUID customerId) {

        return accountRepository.findAllByCustomerId(customerId);
    }
}
