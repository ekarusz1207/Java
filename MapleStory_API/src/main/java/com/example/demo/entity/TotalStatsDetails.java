package com.example.demo.entity;

//import lombok.Data;

//@Data
public class TotalStatsDetails {
//	private String minStatAtk;
//	private String maxStatAtk;
//	private String dmg;
//	private String bossDmg;
//	private String finalDmg;
//	private String ignArmor;
//	private String criChance;
//	private String criDmg;
//	private String starForce;
//	private String arcaneForce;
//	private String authenticForce;
//	private String STR;
//	private String DEX;
//	private String INT;
//	private String LUK;
//	private String HP;
//	private String MP;
//	
//	private String statName;
//	private String statValue;
	
	private String statName;
    private String statValue;
    
    // 기본 생성자
    public TotalStatsDetails() {}

    // Getter와 Setter
    public String getStatName() {
        return statName;
    }

    public void setStatName(String statName) {
        this.statName = statName;
    }

    public String getStatValue() {
        return statValue;
    }

    public void setStatValue(String statValue) {
        this.statValue = statValue;
    }
    
//    @Override
//    public String toString() {
//    	return "Stat Name: " + statName + ", Stat Value: " + statValue;
//    }


    
    
	private String characterName;
//	private String characterClass;
//	private int level;
	
	
//	public TotalStatsDetails(String characterName, String characterClass, int level) {
//		this.characterName = characterName;
//		this.characterClass = characterClass;
//		this.level = level;
//	}
	
	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

//	public String getCharacterClass() {
//		return characterClass;
//	}
//
//	public void setCharacterClass(String characterClass) {
//		this.characterClass = characterClass;
//	}
//
//	public int getLevel() {
//		return level;
//	}
//
//	public void setLevel(int level) {
//		this.level = level;
//	}	

    @Override
    public String toString() {
//        return "Character Nickname:" + characterName + ", Character Class:" + characterClass + ", Character Leve" + level + ", Stat Name: " + statName + ", Stat Value: " + statValue;
    	return "Character Nickname:" + characterName + ", Stat Name: " + statName + ", Stat Value: " + statValue;
    }

}

