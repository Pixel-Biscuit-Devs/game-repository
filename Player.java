package main;

import java.util.ArrayList;

public class Player {
	private int healthPoints = 20;
	private int maxHealth = 20;
	private int expPoints = 0;
	private ArrayList<Item> inventory = new ArrayList<>();
	private int spares = 0;
	private int kills = 0;
	private boolean everKilled = false;
	private boolean everSpared = false;
	
	public Player() {
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

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getExpPoints() {
		return expPoints;
	}

	public void setExpPoints(int expPoints) {
		this.expPoints = expPoints;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void addToInventory(Item item) {
		this.inventory.add(item);
	}
	
	public void removeFromInventory(int index) {
		this.inventory.remove(index);
	}

	public int getSpares() {
		return spares;
	}

	public void addSpare() {
		this.spares++;
	}

	public int getKills() {
		return kills;
	}

	public void addKill() {
		this.kills++;
	}

	public void onKill() {
		everKilled = true;
	}
	
	public boolean everKilled() {
		return everKilled;
	}

	public void onSpare() {
		everSpared = true;
	}
	
	public boolean everSpared() {
		return everSpared;
	}
}
