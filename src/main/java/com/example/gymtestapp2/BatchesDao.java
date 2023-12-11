package com.example.gymtestapp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BatchesDao {

	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	
	 protected void connect_func() throws SQLException {
	    	//uses default connection to the database
	        if (connect == null || connect.isClosed()) {
	            try {
	                Class.forName("com.mysql.cj.jdbc.Driver");
	            } catch (ClassNotFoundException e) {
	                throw new SQLException(e);
	            }
	            connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gym_clark?allowPublicKeyRetrieval=true&useSSL=false&user=root&password=Karimax@2023");
	            System.out.println(connect);
	        }
	    }
	
	 public void insert(Batches batches) throws SQLException {
	    	connect_func();         
			String sql = "insert into batches(name) values (?)";
			preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
				preparedStatement.setString(1, batches.getName());
					

			preparedStatement.executeUpdate();
	        preparedStatement.close();
	    }
	 
	 
	 public List<Batches> listAllBatches() throws SQLException {
		  System.out.print("start get");
	        List<Batches> listbatch = new ArrayList<Batches>();        
	        String sql = "SELECT * FROM batches";      
	        connect_func();      
	        statement = (Statement) connect.createStatement();
	        ResultSet resultSet = statement.executeQuery(sql);
	         
	        while (resultSet.next()) {
	        	int id = resultSet.getInt("id");
	            String  name = resultSet.getString("name");
	            
	            
	            System.out.print(name);

	             
	            Batches batches = new Batches(id,name);
	            listbatch.add(batches);
	        }        
	        resultSet.close();
	        disconnect();        
	        return listbatch;
	    }
	 
	 
	 public boolean deleteBatch(int id) throws SQLException {
	        String sql = "DELETE FROM batches WHERE id = ?";        
	        connect_func();
	         
	        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
	        preparedStatement.setInt(1, id);
	         
	        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
	        preparedStatement.close();
	        return rowDeleted;     
	    }
	 
	   public boolean updateBatch(String name, int id) throws SQLException {
	        String sql = "update batches set name=? where id=?";
	        connect_func();
	        
	        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
	        
	        
	        preparedStatement.setInt(2, id);
	        preparedStatement.setString(1, name);
	      
	        
		
	        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
	        preparedStatement.close();
	        return rowUpdated;     
	    }
	 
	 
	 
	 
	  protected void disconnect() throws SQLException {
	        if (connect != null && !connect.isClosed()) {
	        	connect.close();
	        }
	    }
	 
}
