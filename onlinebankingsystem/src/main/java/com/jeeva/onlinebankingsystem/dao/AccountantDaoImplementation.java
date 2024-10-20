package com.jeeva.onlinebankingsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jeeva.onlinebankingsystem.databaseconnection.DatabaseConnection;
import com.jeeva.onlinebankingsystem.entity.Accountant;
import com.jeeva.onlinebankingsystem.entity.Customer;
import com.jeeva.onlinebankingsystem.exception.AccountantException;
import com.jeeva.onlinebankingsystem.exception.CustomerException;

public class AccountantDaoImplementation implements AccountantDao{

	@Override
	public Accountant LogicAccountant(String accountantUsername, String accountantPassword) throws AccountantException {
		Accountant ac = null;
		try(Connection conn = DatabaseConnection.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from accountant where accountantUsername = ? and accountantPassword = ?");
			ps.setString(1, accountantUsername);
			ps.setString(2, accountantPassword);
			ResultSet res = ps.executeQuery();
			if(res.next())
			{
				String n = res.getString("accountantUsername");
				String e = res.getString("accountantEmail");
				String p = res.getString("accountantPassword");
				
				ac = new Accountant(n,e,p);
				
			}
		} 
		catch (SQLException e) {
			throw new AccountantException("Invalid username and password");
		}
		return ac;
	}

	@Override
	public int addCustomer(String customerName, String customerMail, String customerPassword, String customerMobile,String customerAddress) throws CustomerException {
		int cid = -1;
		try(Connection conn = DatabaseConnection.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into customerinformation (customerName,customerMail,customerPassword,customerMobile,customerAddress) values(?,?,?,?,?)");
			ps.setString(1, customerName);
			ps.setString(2, customerMail);
			ps.setString(3, customerPassword);
			ps.setString(4, customerMobile);
			ps.setString(5, customerAddress);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				PreparedStatement ps2 = conn.prepareStatement("select cid from customerinformation where customerMail= ? and customerMobile=? ");
				ps2.setString(1, customerMail);
				ps2.setString(2, customerMobile);
				
				ResultSet rs = ps2.executeQuery();
				if(rs.next())
				{
					cid = rs.getInt("cid");
					
				}
				else
				{
					System.out.println("Incorrect data please try again");
				}
			}
			else
				System.out.println("Error occured while adding customere information");
			
		} catch (SQLException e) {
			System.out.println("SQL QUERY ERROR !");
		}
		return cid;
	}

	@Override
	public String addAccount(int customerBalance, int cid) throws CustomerException {
		String msg = null;
		try(Connection con = DatabaseConnection.provideConnection()) {
			PreparedStatement ps = con.prepareStatement("insert into account(customerBalance,cid) values (?,?)");
			ps.setInt(1, customerBalance);
			ps.setInt(2, cid);
			
			int x = ps.executeUpdate();
			if(x>0) {
				System.out.println("Account added successfully !");
			}
			else
			{
				System.out.println("Cant insert the data !");
			}
		} catch (SQLException e) {
			System.out.println("SQL QUERY ERROR");
			
		}
		return msg;
	}

	@Override
	public String updateCustomer(int customerAccountNumber, String customerAddress) throws CustomerException {
		String msg = null;
		try(Connection conn = DatabaseConnection.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("update customerinformation i inner join account a on i.cid = a.cid and a.customerAccountNumber=? set i.customerAddress=? ");
			ps.setInt(1, customerAccountNumber);
			ps.setString(2, customerAddress);
			int x = ps.executeUpdate();
			
			if(x>0)
			{
				System.out.println("Address updated successfully !");
				
			}
			else {
				System.out.println("Updation not successfull");
				System.out.println("...........................");
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
			msg = e.getMessage();
		}
		return msg;
	}

	@Override
	public String deleteAccount(int customerAccountNumber) throws CustomerException {
		String msg = null;
		try(Connection conn = DatabaseConnection.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("delete i from customerinformation i inner join account a on i.cid = a.cid where a.customerAccountNumber=?");
			ps.setInt(1, customerAccountNumber);
			
			int x = ps.executeUpdate();
			if(x>0)
			{
				System.out.println("Account deleted successfully !");
			}
			else
			{
				System.out.println("Account deletion failed");
				System.out.println("........................");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			msg = e.getMessage();
		}
		return msg;
	}

	@Override
	public Customer viewCustomer(String customerAccountNumber) throws CustomerException {
		Customer cu = null;
		try (Connection conn = DatabaseConnection.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from customerinformation i inner join account a on a.cid = i.cid where customerAccountNumber=?");
			ps.setString(1, customerAccountNumber);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				int a = rs.getInt("customerAccountNumber");
				String n = rs.getString("customerName");
				int b = rs.getInt("customerBalance");
				String e = rs.getString("customerPassword");
				String p = rs.getString("customerMail");
				String m = rs.getString("customerMobile");
				String ad = rs.getString("customerAddress");
				
				cu = new Customer(a,b,n,e,p,m,ad);
			}
			else
				throw new CustomerException("Invalid Account Number");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		return cu;
	}

	@Override
	public Customer viewallCustomer() throws CustomerException {
		Customer cu = null;
		try(Connection conn = DatabaseConnection.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("select * from customerinformation i inner join account a on a.cid = i.cid");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				int a = rs.getInt("customerAccountNumber");
				String n = rs.getString("customerName");
				int b = rs.getInt("customerBalance");
				String e = rs.getString("customerPassword");
				String p = rs.getString("customerMail");
				String m = rs.getString("customerMobile");
				String ad = rs.getString("customerAddress");
				
				System.out.println("............................");
				System.out.println("Customer Account Number : "+a);
				System.out.println("Customer Name : "+n);
				System.out.println("Customer Balance : "+b);
				System.out.println("Customer Password : "+e);
				System.out.println("Customer Mail : "+p);
				System.out.println("Customer Mobile : "+m);
				System.out.println("Customer Address : "+ad);
				
				System.out.println("...........................");
				cu = new Customer(a,b,n,e,p,m,ad);
				
			}
			
		}
		catch(SQLException e)
		{
			throw new CustomerException("Invalid Account Number !");
		}
		return cu;
	}

}
