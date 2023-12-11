package com.example.gymtestapp2.dao;

import com.example.gymtestapp2.model.BatchUsers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BatchesUserDao {
	
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	int id;
	String userName;
	String batchName;
	
	
	
	 BatchesUserDao(int id,String userName, String batchName) {
		super();
		this.userName = userName;
		this.batchName = batchName;
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	
	
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

 public void insert(BatchUsers batchusers) throws SQLException {
    	connect_func();  
    	if (!isRecordExists(batchusers.getUserId(), batchusers.getBatchId())) {
		String sql = "insert into batchusers(userId,batchId) values (?,?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setInt(1, batchusers.getUserId());
			preparedStatement.setInt(2, batchusers.getBatchId());
				

		preparedStatement.executeUpdate();
        preparedStatement.close();
    	}
    }
 
 
 private boolean isRecordExists(int userId, int batchId) throws SQLException {
	    String sql = "SELECT COUNT(*) FROM batchusers WHERE userId = ? AND batchId = ?";
	    try (PreparedStatement preparedStatement = connect.prepareStatement(sql)) {
	        preparedStatement.setInt(1, userId);
	        preparedStatement.setInt(2, batchId);

	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            if (resultSet.next()) {
	                int count = resultSet.getInt(1);
	                return count > 0; 
	            }
	        }
	    }

	    return false; 
	}
 
 public List<BatchesUserDao> listAllUserBatches() throws SQLException {
	  System.out.print("start get");
        List<BatchesUserDao> listbatchusers = new ArrayList<BatchesUserDao>();        
        String sql = "SELECT batchusers.id, User.email as userName,batches.name as batchName FROM  batchusers inner join User on User.customerid=batchusers.userId inner join batches on batches.id=batchusers.batchId";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
       
        while (resultSet.next()) {
        	int id = resultSet.getInt("id");
            String  email = resultSet.getString("userName");
            String  name = resultSet.getString("batchName");
            
            System.out.print(name);

             
            BatchesUserDao batchesusersdao = new BatchesUserDao(id,email,name);
            listbatchusers.add(batchesusersdao);
        }        
        resultSet.close();
        disconnect();        
        return listbatchusers;
    }
 
 
 public boolean deleteBatchUser(int id) throws SQLException {
        String sql = "DELETE FROM batchusers WHERE id = ?";        
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, id);
         
        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowDeleted;     
    }
 
  
 
 
 
  protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
	
	

}
