package com.example.demo.account.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.account.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
