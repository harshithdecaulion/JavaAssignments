package com.example.demo.service;

import java.util.List;

import com.example.demo.tx.entity.Tx;

public interface TxService {

	Tx createTransaction(Tx ctx);

	Tx getTransaction(Long id);

	List<Tx> getAllTx();

}