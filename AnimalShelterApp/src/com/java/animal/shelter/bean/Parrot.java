package com.java.animal.shelter.bean;

public class Parrot extends Animal{
	
	private String type = "parrot";
	private String sound = "twit twit";

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
