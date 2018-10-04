package main.battleSystemPrototype3;

import java.awt.Image;

public class Enemy {
	String name;
	private int healthPoints;
	private int maxHealth;
	private int pacifistPoints;
	private int reqPacifPoints;
	private int xpValue;
	private int baseDamage;
	public int cursor = (int) (Math.random() * 780 - 390);
	public int[] ATKx;
	private String[] actOptions;
	private Image sprite;
	
	public Enemy(String name, int healthPoints, int pacifistPoints, int xpValue, int baseDamage, int baseAccuracy, String[] actOptions, Image sprite) {
		this.name = name;
		this.setHealthPoints(healthPoints);
		this.maxHealth = healthPoints;
		this.setPacifistPoints(0);
		this.reqPacifPoints = pacifistPoints;
		this.xpValue = xpValue;
		this.setBaseDamage(baseDamage);
		this.actOptions = actOptions;
		this.sprite = sprite;
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public int getPacifistPoints() {
		return pacifistPoints;
	}

	public void setPacifistPoints(int pacifistPoints) {
		this.pacifistPoints = pacifistPoints;
	}

	public int getReqPacifPoints() {
		return reqPacifPoints;
	}

	public int getXpValue() {
		return xpValue;
	}

	public int getBaseDamage() {
		return baseDamage;
	}

	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}
	
	public Image getSprite() {
		return sprite;
	}

	// Use anonymous class to set these
	public void doTurn() {
		
	}
	
	public void actOn(int index) {
		
	}

	public String[] getActOptions() {
		return actOptions;
	}
}
