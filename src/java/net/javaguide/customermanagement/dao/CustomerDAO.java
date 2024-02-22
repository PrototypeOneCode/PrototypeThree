/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.javaguide.customermanagement.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.javaguide.customermanagement.model.Customer;

/**
 *
 * @author End User
 */
public class CustomerDAO {
    
    private String jdbcURL = "jdbc:mysql://localhost:3306/?user=root";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Computing123";

    private static final String INSERT_CUSTOMERS_SQL = "INSERT INTO `cutomersdb`.`customertable`(id, name, address, date, invoiceNo, description, invoiceTotal) VALUES (?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_CUSTOMERS_BY_ID = "select name,address,date,invoiceNo,description,invoiceTotal from `cutomersdb`.`customertable` where id =?";
	private static final String SELECT_ALL_CUSTOMERS = "select * from `cutomersdb`.`customertable`";
	private static final String DELETE_CUSTOMERS_SQL = "delete from `cutomersdb`.`customertable` where id = ?;";
	private static final String UPDATE_CUSTOMERS_SQL = "update `cutomersdb`.`customertable` set name =?, address =?, date =?, invoiceNo =?, description =?, invoiceTotal =? where id = ?;";
    
   protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
 
    public void insertCustomer(Customer customer) throws SQLException {
		System.out.println(INSERT_CUSTOMERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMERS_SQL)) {
                        preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getAddress());
			preparedStatement.setString(3, customer.getDate());
                        preparedStatement.setInt(4, customer.getInvoiceNo());
                        preparedStatement.setString(5, customer.getDescription());
                        preparedStatement.setDouble(6, customer.getInvoiceTotal());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
                
                
                
	}
    
    //update user
    public boolean updateCustomer(Customer customer) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMERS_SQL);) {
			statement.setString(1, customer.getName());
			statement.setString(2, customer.getAddress());
			statement.setString(3, customer.getDate());
                        statement.setInt(4, customer.getInvoiceNo());
                        statement.setString(5, customer.getDescription());
                        statement.setDouble(6, customer.getInvoiceTotal());
                        statement.setInt(7, customer.getId());
                        
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
    
    //select customer by id
    public Customer selectCustomer(int id) {
		Customer customer = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMERS_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String address = rs.getString("address");
				String date = rs.getString("date");
                                int invoiceNo = rs.getInt("invoiceNo");
                                String description = rs.getString("description");
                                double invoiceTotal = rs.getDouble("invoiceTotal");
				customer = new Customer(id, name, address, date, invoiceNo, description, invoiceTotal);                             
      
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

    //select all users
    public List<Customer> selectAllCustomers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Customer> customers = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String date = rs.getString("date");
                                int invoiceNo = rs.getInt("invoiceNo");
                                String description = rs.getString("description");
                                double invoiceTotal = rs.getDouble("invoiceTotal");
				customers.add(new Customer(id, name, address, date, invoiceNo, description, invoiceTotal));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}
 
    //delete user
    public boolean deleteCustomer(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
    
}
