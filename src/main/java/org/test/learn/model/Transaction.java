package org.test.learn.model;

import java.time.LocalDateTime;

public class Transaction {
	
	private Float transactionAmout;
	private LocalDateTime transactionDate;
	private String customerId;
	
	public Float getTransactionAmout() {
		return transactionAmout;
	}
	public void setTransactionAmout(Float transactionAmout) {
		this.transactionAmout = transactionAmout;
	}
	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

}
