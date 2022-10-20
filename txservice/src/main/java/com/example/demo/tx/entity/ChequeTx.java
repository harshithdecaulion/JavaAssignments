package com.example.demo.tx.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("txc")
public class ChequeTx extends Tx{
    
    private int chequeNo;
    private float collectionCharges;
    private boolean outstation;
    public int getChequeNo() {
        return chequeNo;
    }
    public void setChequeNo(int chequeNo) {
        this.chequeNo = chequeNo;
    }
    public float getCollectionCharges() {
        return collectionCharges;
    }
    public void setCollectionCharges(float collectionCharges) {
        this.collectionCharges = collectionCharges;
    }
    public boolean isOutstation() {
        return outstation;
    }
    public void setOutstation(boolean outstation) {
        this.outstation = outstation;
    }
    public ChequeTx(int chequeNo, float collectionCharges, boolean outstation) {
        super();
        this.chequeNo = chequeNo;
        this.collectionCharges = collectionCharges;
        this.outstation = outstation;
    }
    public ChequeTx() {
        super();
    }



}