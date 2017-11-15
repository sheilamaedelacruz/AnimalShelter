package com.java.animal.shelter.bean;

public class Cat extends Animal{
	
	private String type = "cat";
	private String sound = "meow meow";

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
