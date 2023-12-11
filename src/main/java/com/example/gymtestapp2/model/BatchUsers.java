package com.example.gymtestapp2.model;

public class BatchUsers {
	
	int id;
	int userId;
	int batchId;
	
	
	
	public BatchUsers(int id, int userId, int batchId) {
		super();
		this.id = id;
		this.userId = userId;
		this.batchId = batchId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	
	

}
