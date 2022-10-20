package com.example.demo.controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TxService;
import com.example.demo.tx.entity.Tx;







@RestController
public class TxController {
    
    @Autowired
    private TxService txService;



   @PostMapping("/api/tx/")
    public Tx createTransaction(Tx ctx) {
        return txService.createTransaction(ctx);
    }
@GetMapping("/api/tx/{id}")
    public Tx getTransaction(Long id) {
        return txService.getTransaction(id);
    }
@GetMapping("api/tx/")
    public List<Tx> getAllTx() {
        return txService.getAllTx();
    }
    
    

}