package com.example.demo.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.TxRepository;
import com.example.demo.tx.entity.Tx;






@Service



public class TxServiceImpl implements TxService  {
    @Autowired
    private TxRepository txRepository;



   
     
    @Override
	public Tx createTransaction(Tx ctx) {
            return txRepository.save(ctx);
        }
        
      
        @Override
		public Tx getTransaction(Long id) {
            return txRepository.findById(id).get();
        }
        
       
        @Override
		public List<Tx> getAllTx() {
            return txRepository.findAll();
        }
    }