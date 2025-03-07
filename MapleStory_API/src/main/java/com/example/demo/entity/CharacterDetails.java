package com.example.demo.entity;


public class CharacterDetails {
	private String characterName;
	private String characterClass;
//	private int level;
//	private double expRate;
	private String level;
	private String expRate;

	public CharacterDetails(String characterName, String characterClass, String level, String expRate) {
		this.characterName = characterName;
		this.characterClass = characterClass;
		this.level = level;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public String getCharacterClass() {
		return characterClass;
	}

	public void setCharacterClass(String characterClass) {
		this.characterClass = characterClass;
	}

//	public int getLevel() {
//		return level;
//	}

//	public void setLevel(int level) {
//		this.level = level;
//	}
	
	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}
	
//	public double getExpRate() {
//		return expRate;
//	}
//	
//	public void setExpRate(double expRate) {
//		this.expRate = expRate;
//	}
	
	public String getExpRate() {
		return expRate;
	}
	
	public void setExpRate(String expRate) {
		this.expRate = expRate;
	}

	@Override
	public String toString() {
		return "CharacterDetails{" + "characterName='" + characterName + '\'' + ", characterClass='" + characterClass
				+ '\'' + ", level='" + level + '\'' + expRate + '}';
	}
}
