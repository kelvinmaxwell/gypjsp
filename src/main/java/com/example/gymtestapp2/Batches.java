package com.example.gymtestapp2;

public class Batches {
	protected int id;
	protected String name;
	
	public Batches(int id,String name) {
		super();
		
		this.name = name;
		this.id=id;
	}
	public Batches(String name) {
		super();
		
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
 	
}
