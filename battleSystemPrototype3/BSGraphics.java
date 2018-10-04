package main.battleSystemPrototype3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GameGraphics;
import main.Main;

public class BSGraphics extends GameGraphics {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7922062936379464886L;

	/**
	 * 0 = Button Selection, 1 = Message View, 2 = Fight view, 3 = Act view, 4 =
	 * Item view, 5 = Slime attack View
	 */
	static int bbView = 0;
	static int selectedEnemy = -1;
	static String message = "This message is a test";

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		double scaleX = (double) Main.frame.getWidth() / 1080;
		double scaleY = (double) Main.frame.getHeight() / 720;

		double smallerSF = 1;
		if (scaleX <= scaleY) {
			smallerSF = scaleX;
		}

		if (scaleX > scaleY) {
			smallerSF = scaleY;
		}

		BufferedImage bg = null;
		try {
			bg = ImageIO.read(getClass().getResource("res/SlimeBattleBG.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		BufferedImage bottombar = null;
		try {
			bottombar = ImageIO.read(getClass().getResource("res/bottombar.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		BufferedImage fight = null;
		try {
			fight = ImageIO.read(getClass().getResource("res/fightbutton.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		BufferedImage act = null;
		try {
			act = ImageIO.read(getClass().getResource("res/actbutton.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		BufferedImage items = null;
		try {
			items = ImageIO.read(getClass().getResource("res/itemsbutton.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, Main.frame.getWidth(), Main.frame.getHeight());

		g2d.drawImage(scaleImage(bg, smallerSF), (int) ((Main.frame.getWidth() / 2 - smallerSF * 540)), 0, null);

		g2d.drawImage(bottombar, Main.frame.getWidth() / 2 - 400, Main.frame.getHeight() - 189, null);

		// Health bar graphic
		g2d.setColor(Color.RED);
		g2d.fillRect(Main.frame.getWidth() / 2 - 390, Main.frame.getHeight() - 219, 380, 15);

		g2d.setColor(Color.GREEN);
		g2d.fillRect(Main.frame.getWidth() / 2 - 390, Main.frame.getHeight() - 219,
				380 * Main.player.getHealthPoints() / Main.player.getMaxHealth(), 15);

		g2d.setColor(Color.BLACK);
		g2d.drawRect(Main.frame.getWidth() / 2 - 390, Main.frame.getHeight() - 219, 380, 15);

		g2d.drawString(Main.player.getHealthPoints() + "/" + Main.player.getMaxHealth(),
				Main.frame.getWidth() / 2 - 390, Main.frame.getHeight() - 224);

		g2d.drawString(String.valueOf(bbView), 500, 500);
		g2d.drawString(String.valueOf(selectedEnemy), 600, 500);

		if (bbView == 0) {
			g2d.drawImage(fight, Main.frame.getWidth() / 2 - 250, Main.frame.getHeight() - 139, null);
			g2d.drawImage(act, Main.frame.getWidth() / 2 - 50, Main.frame.getHeight() - 139, null);
			g2d.drawImage(items, Main.frame.getWidth() / 2 + 150, Main.frame.getHeight() - 139, null);
		}

		if (bbView == 1) {
			g2d.setColor(Color.WHITE);
			g2d.setFont(new Font("monospace", Font.PLAIN, 50));
			g2d.drawString(message, Main.frame.getWidth() / 2 - 385, Main.frame.getHeight() - 135);
		}

		if (bbView == 2) {
			for (int i = 0; i < BattleSystem.enemies.size(); i++) {
				g2d.setColor(Color.WHITE);
				g2d.setFont(new Font("monospace", Font.PLAIN, 30));
				g2d.drawString(BattleSystem.enemies.get(i).name, Main.frame.getWidth() / 2 - 385,
						Main.frame.getHeight() - 145 + 30 * i);
			}
		}

		if (bbView == 3) {

			if (selectedEnemy != -1) {
				for (int i = 0; i < BattleSystem.enemies.get(selectedEnemy).getActOptions().length; i++) {
					g2d.setColor(Color.WHITE);
					g2d.setFont(new Font("monospace", Font.PLAIN, 30));
					g2d.drawString(BattleSystem.enemies.get(selectedEnemy).getActOptions()[i],
							Main.frame.getWidth() / 2 - 385, Main.frame.getHeight() - 145 + 30 * i);
				}
			} else {
				for (int i = 0; i < BattleSystem.enemies.size(); i++) {
					g2d.setColor(Color.WHITE);
					g2d.setFont(new Font("monospace", Font.PLAIN, 30));
					g2d.drawString(BattleSystem.enemies.get(i).name, Main.frame.getWidth() / 2 - 385,
							Main.frame.getHeight() - 145 + 30 * i);
				}
			}
		}

		if (bbView == 4) {
			for (int i = 0; i < BattleSystem.enemies.size(); i++) {
				g2d.setColor(Color.WHITE);
				g2d.setFont(new Font("monospace", Font.PLAIN, 50));
			}
		}

		if (bbView == 5) {
			g2d.setColor(Color.DARK_GRAY);
			g2d.fillRect(Main.frame.getWidth() / 2 - 390, Main.frame.getHeight() - 702, 780, 702);

			for (int i = 0; i < 9; i++) {
				g2d.setColor(Color.WHITE);
				g2d.drawLine(Main.frame.getWidth() / 2 - 390, Main.frame.getHeight() - 702 + (78 * i),
						Main.frame.getWidth() / 2 + 390, Main.frame.getHeight() - 702 + (78 * i));
			}

			for (int j = 0; j < 10; j++) {
				g2d.setColor(Color.WHITE);
				g2d.drawLine(Main.frame.getWidth() / 2 - 390 + (78 * j), Main.frame.getHeight() - 702,
						Main.frame.getWidth() / 2 + 390 + (78 * j), Main.frame.getHeight() - 702);
			}
			
			System.out.println(bbView);
		}
				
		System.out.println(System.currentTimeMillis());

		for (int i = 0; i < BattleSystem.enemies.size(); i++) {
			Enemy enemy = BattleSystem.enemies.get(i);

			g2d.drawImage(enemy.getSprite(), Main.frame.getWidth() / 2 - (125 * BattleSystem.enemies.size()) + 250 * i,
					Main.frame.getHeight() / 2 - 90, null);

			// Health bar
			g2d.setColor(Color.RED);
			g2d.fillRect(Main.frame.getWidth() / 2 - (125 * BattleSystem.enemies.size()) + 250 * i,
					Main.frame.getHeight() / 2 - 110, 200, 20);

			g2d.setColor(Color.GREEN);
			g2d.fillRect(Main.frame.getWidth() / 2 - (125 * BattleSystem.enemies.size()) + 250 * i,
					Main.frame.getHeight() / 2 - 110, 200 * enemy.getHealthPoints() / enemy.getMaxHealth(), 20);

			g2d.setColor(Color.BLACK);
			g2d.drawRect(Main.frame.getWidth() / 2 - (125 * BattleSystem.enemies.size()) + 250 * i,
					Main.frame.getHeight() / 2 - 110, 200, 20);

			// Peace Bar
			g2d.setColor(Color.BLUE);
			g2d.fillRect(Main.frame.getWidth() / 2 - (125 * BattleSystem.enemies.size()) + 250 * i,
					Main.frame.getHeight() / 2 - 85, 200, 10);

			g2d.setColor(Color.CYAN);
			g2d.fillRect(Main.frame.getWidth() / 2 - (125 * BattleSystem.enemies.size()) + 250 * i,
					Main.frame.getHeight() / 2 - 85, 200 * enemy.getPacifistPoints() / enemy.getReqPacifPoints(), 10);

			g2d.setColor(Color.BLACK);
			g2d.drawRect(Main.frame.getWidth() / 2 - (125 * BattleSystem.enemies.size()) + 250 * i,
					Main.frame.getHeight() / 2 - 85, 200, 10);

			BattleSystem.doAllChecks();
		}
	}
}
