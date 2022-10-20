package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.tx.entity.Tx;

public interface TxRepository  extends JpaRepository<Tx, Long> {

}
