package com.jeeva.onlinebankingsystem.dao;

import com.jeeva.onlinebankingsystem.entity.Accountant;
import com.jeeva.onlinebankingsystem.entity.Customer;
import com.jeeva.onlinebankingsystem.exception.AccountantException;
import com.jeeva.onlinebankingsystem.exception.CustomerException;

public interface AccountantDao {
	public Accountant LogicAccountant(String accountantUsername,String accountantPassword) throws AccountantException;
	public int addCustomer(String customerName,String customerMail,String customerPassword,
			String customerMobile, String customerAddress) throws CustomerException;
	public String addAccount(int customerBalance,int cid ) throws CustomerException;
	public String updateCustomer(int customerAccountNumber,String customerAddress) throws CustomerException;
	public String deleteAccount(int customerAccountNumber) throws CustomerException;
	public Customer viewCustomer(String customerAccountNumber) throws CustomerException;
	public Customer viewallCustomer() throws CustomerException;
}
