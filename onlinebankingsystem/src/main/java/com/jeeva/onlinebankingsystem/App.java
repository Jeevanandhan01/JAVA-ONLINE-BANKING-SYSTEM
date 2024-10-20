package com.jeeva.onlinebankingsystem;

import java.util.Scanner;

import com.jeeva.onlinebankingsystem.dao.AccountantDao;
import com.jeeva.onlinebankingsystem.dao.AccountantDaoImplementation;
import com.jeeva.onlinebankingsystem.dao.CustomerDao;
import com.jeeva.onlinebankingsystem.dao.CustomerDaoImplements;
import com.jeeva.onlinebankingsystem.entity.Accountant;
import com.jeeva.onlinebankingsystem.entity.Customer;
import com.jeeva.onlinebankingsystem.exception.AccountantException;
import com.jeeva.onlinebankingsystem.exception.CustomerException;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean f = true;
        while(f)
        {
        	System.out.println("................WELCOME TO ONLINE BANKING SYSTEM................");
        	System.out.println("1.ADMIN LOGIN PORTAL");
        	System.out.println("2.CUSTOMER");
        	System.out.println("................................................................");
        	System.out.print("ENTER YOUR CHOICE : ");
        	int choice = sc.nextInt();
        	
        	switch (choice) {
			case 1:
				System.out.println("...........Admin login credentials................");
				System.out.print("Enter username : ");
				String username = sc.next();
				System.out.print("Enter password : ");
				String password = sc.next();
				
				AccountantDao ad = new AccountantDaoImplementation();
				try {
					Accountant a = ad.LogicAccountant(username, password);
					if(a==null) {
						System.out.println("Wrong credentials!");
						break;
					}
					System.out.println("Login successful !");
					System.out.println("Welome admin : "+a.getAccountantUsername());
					
					boolean y = true;
					while(y)
					{
						System.out.println(".........................");
						System.out.println("1.Add Customer Account");
						System.out.println("2.Update customer address");
						System.out.println("3.Delete account by account number");
						System.out.println("4.View account details by account number");
						System.out.println("5.View all customer details");
						System.out.println("6.Account logout");
						System.out.print("Enter your choice : ");
						int x = sc.nextInt();
						if(x==1) {
							System.out.println("..........Adding new account.........");
							System.out.print("Enter Customer Name : ");
							String a1 = sc.next();
							System.out.print("Enter account opening balance : ");
							int a2 = sc.nextInt();
							System.out.print("Enter Customer Mail : ");
							String a3 = sc.next();
							System.out.print("Enter Customer password: ");
							String a4 = sc.next();
							System.out.print("Enter Customer Mobile : ");
							String a5 = sc.next();
							System.out.print("Enter Customer Address : ");
							String a6 = sc.next();
							
							int s1 = -1;
							try {
								s1 = ad.addCustomer(a1, a3, a4, a5, a6);
								try {
									ad.addAccount(a2, s1);
								} catch (CustomerException e) {
									e.printStackTrace();
								}
							} catch (CustomerException e) {
								System.out.println(e.getMessage());
								
							}
							System.out.println("Customer added successful");
							System.out.println(".................................");
						}
						if(x==2) {
							System.out.println("...........Update Customer Address..........");
							System.out.print("Enter customer account number : ");
							int u = sc.nextInt();
							System.out.print("Enter new address : ");
							String u2 = sc.next();
							
							try {
								String mes = ad.updateCustomer(	u, u2);
							} catch (CustomerException e) {
								e.printStackTrace();
							}
						}
						if(x==3)
						{
							System.out.println("............Delete Account by account number............");
							System.out.print("Enter account number : ");
							int ac = sc.nextInt();
							String s = null;
							try {
								s = ad.deleteAccount(ac);
							} catch (CustomerException e) {
								e.printStackTrace();
							}
							if(s!=null)
							{
								System.out.println(s);
							}
						}
						if(x==4)
						{
							System.out.println("...........Cusomter Details ...............");
							System.out.print("Enter customer number : ");
							String ac = sc.next();
							
							try {
								Customer cus = ad.viewCustomer(ac);
								
								if(cus != null)
								{
									System.out.println(".........................");
									System.out.println("Account Number : "+cus.getCustomerAccountNumber());
									System.out.println("Name : "+cus.getCustomerName());
									System.out.println("Balance : "+cus.getCustomerBalance());
									System.out.println("Email : "+cus.getCustomerMail());
									System.out.println("Password : "+cus.getCustomerPassword());
									System.out.println("Mobile Number :"+cus.getCustomerMobile());
									System.out.println("Address : "+cus.getCustomerAddress());
									System.out.println("..........................");
								}
								else
								{
									System.out.println("Account doesnt exist");
									System.out.println("...............................");
								}
							} catch (CustomerException e) {
								e.printStackTrace();
							}
						}
						if(x==5)
						{
							try {
								System.out.println("............All customer details...............");
								Customer cus = ad.viewallCustomer();
								
							} catch (CustomerException e) {
								e.printStackTrace();
							}
						}
						if(x==6)
						{
							System.out.println("Account logout successfull");
							y = false;
						}
						
					}
					break;
				} catch (AccountantException e) {
					System.out.println(e.getMessage());
				}
				break;
			
			case 2:
				System.out.println("...............CUSTOMER LOGIN................ ");
				System.out.println("...........................................");
				System.out.print("Enter username : ");
				String customerUserName = sc.next();
				System.out.print("Enter password : ");
				String customerPassword = sc.next();
				System.out.print("Enter account number : ");
				int accountNumber = sc.nextInt();
				
				CustomerDao cd = new CustomerDaoImplements();
				try {
					Customer cus = cd.LoginCustomer(customerUserName, customerPassword, accountNumber);
					System.out.println("Welcome : "+cus.getCustomerName());
					boolean m = true;
					
					while(m)
					{
						System.out.println("............................");
						System.out.println("1.View Balance");
						System.out.println("2.Deposit Money");
						System.out.println("3.Withdraw Money");
						System.out.println("4.Transfer Money");
						System.out.println("5.Logout");
						System.out.print("Enter your choice : ");
						int x = sc.nextInt();
						
						if(x==1)
						{
							 System.out.println("..............Balance................");
							 System.out.println("Current balance : "+cd.viewBalance(accountNumber));
							 System.out.println(".....................................");
						}
						if(x==2)
						{
							System.out.println("...............Deposit.................");
							System.out.print("Enter the amount to deposit : ");
							int am = sc.nextInt();
							cd.Deposit(accountNumber, am);
							System.out.println("Balance afte deposit : "+cd.viewBalance(accountNumber));
						}
						if(x==3)
						{
							System.out.println("...............Withdraw.................");
							System.out.print("Enter the amount : ");
							int am = sc.nextInt();
							try
							{
								cd.withdraw(accountNumber, am);
								System.out.println("Balance after withdraw : "+cd.viewBalance(accountNumber));
								System.out.println("...................................");
							}
							catch(Exception e)
							{
								System.out.println(e.getMessage());
							}
						}
						if(x==4)
						{
							System.out.println("....................Money Transfer....................");
							System.out.print("Enter amount to transfer : ");
							int amt = sc.nextInt();
							System.out.print("Enter account number to transfer : ");
							int ac = sc.nextInt();
							
							try {
								cd.Transfer(accountNumber, amt, ac);
								System.out.println("Amount transfered successfully");
								System.out.println("..............................");
							} catch (Exception e) {
								System.out.println(e.getMessage());
								
							}
						}
						if(x==5)
						{
							System.out.println("Customer Logout successfull !");
							System.out.println("Thank you for choosing online banking services");
							m = false;
						}
					}
					break;
					
				} catch (CustomerException e) {
					System.out.println(e.getMessage());
				}
			}
        }
    }
}
