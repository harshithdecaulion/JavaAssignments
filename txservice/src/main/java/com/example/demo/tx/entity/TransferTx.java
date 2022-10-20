package com.example.demo.tx.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("txt")
public class TransferTx extends Tx {

	
	
	private int fromAccount;
    private int toAccount;
    public int getFromAccount() {
        return fromAccount;
    }
    public void setFromAccount(int fromAccount) {
        this.fromAccount = fromAccount;
    }
    public int getToAccount() {
        return toAccount;
    }
    public void setToAccount(int toAccount) {
        this.toAccount = toAccount;
    }
    public TransferTx(int fromAccount, int toAccount) {
        super();
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
    }
    public TransferTx() {
        super();
    }



}
