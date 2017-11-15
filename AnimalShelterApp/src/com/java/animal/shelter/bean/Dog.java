package com.java.animal.shelter.bean;

public class Dog extends Animal{
	
	private String type = "dog";
	private String sound = "arf arf";

	@Override
	public String sound() {
		return sound;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
