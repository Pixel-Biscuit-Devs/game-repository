package main.battleSystemPrototype3;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EnemyTemplates {
	BufferedImage slimeSprite = null;
	String[] slimeActOptions = { "Pet", "Play Fetch", "Threaten", "Ignore" };

	public EnemyTemplates() {
		try {
			slimeSprite = ImageIO.read(getClass().getResource(("res/InnocentSlimeLarge.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Enemy newSlime() {
		return new Enemy("Slime", 20, 10, 5, 2, 20, slimeActOptions, slimeSprite) {
			public void doTurn() {
				BSGraphics.bbView = 5;		
				
				BattleSystem.g.repaint();
				
			}

			public void actOn(int i) {

			}
		};
	}
}
