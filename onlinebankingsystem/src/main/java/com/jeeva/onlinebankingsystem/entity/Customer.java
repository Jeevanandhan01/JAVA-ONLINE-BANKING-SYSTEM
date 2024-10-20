package com.jeeva.onlinebankingsystem.entity;

public class Customer {
	private int customerAccountNumber;
	private int customerBalance;
	private String customerName;
	private String customerPassword;
	private String customerMail;
	private String customerMobile;
	private String customerAddress;
		
	public Customer() {
		super();
	}

	public Customer(int customerAccountNumber, int customerBalance, String customerName, String customerPassword,
			String customerMail, String customerMobile, String customerAddress) {
		super();
		this.customerAccountNumber = customerAccountNumber;
		this.customerBalance = customerBalance;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.customerMail = customerMail;
		this.customerMobile = customerMobile;
		this.customerAddress = customerAddress;
	}

	public int getCustomerAccountNumber() {
		return customerAccountNumber;
	}

	public void setCustomerAccountNumber(int customerAccountNumber) {
		this.customerAccountNumber = customerAccountNumber;
	}

	public int getCustomerBalance() {
		return customerBalance;
	}

	public void setCustomerBalance(int customerBalance) {
		this.customerBalance = customerBalance;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerMail() {
		return customerMail;
	}

	public void setCustomerMail(String customerMail) {
		this.customerMail = customerMail;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Override
	public String toString() {
		return "Customer [customerAccountNumber=" + customerAccountNumber + ", customerBalance=" + customerBalance
				+ ", customerName=" + customerName + ", customerPassword=" + customerPassword + ", customerMail="
				+ customerMail + ", customerMobile=" + customerMobile + ", customerAddress=" + customerAddress + "]";
	}
	
	
	
	
}
