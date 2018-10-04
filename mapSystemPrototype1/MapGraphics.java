package main.mapSystemPrototype1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GameGraphics;
import main.Main;

public class MapGraphics extends GameGraphics {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5441616406615002194L;

	int tileSize = 60;

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
		
		BufferedImage deltaBack = null;
		try {
			deltaBack = ImageIO.read(getClass().getResource("res/DeltaBack.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		BufferedImage deltaRight = null;
		try {
			deltaRight = ImageIO.read(getClass().getResource("res/DeltaRight.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		BufferedImage deltaFrontNormal = null;
		try {
			deltaFrontNormal = ImageIO.read(getClass().getResource("res/DeltaFrontNormal.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		BufferedImage deltaLeft = null;
		try {
			deltaLeft = ImageIO.read(getClass().getResource("res/DeltaLeft.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		BufferedImage empty = null;
		try {
			empty = ImageIO.read(getClass().getResource("res/empty.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		BufferedImage wall = null;
		try {
			wall = ImageIO.read(getClass().getResource("res/wall.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		BufferedImage wall2 = null;
		try {
			wall2 = ImageIO.read(getClass().getResource("res/wall2.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		BufferedImage wall3 = null;
		try {
			wall3 = ImageIO.read(getClass().getResource("res/wall3.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		BufferedImage wallbot = null;
		try {
			wallbot = ImageIO.read(getClass().getResource("res/wallbot.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		BufferedImage slime = null;
		try {
			slime = ImageIO.read(getClass().getResource("res/slime.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, (int) (scaleX * 1080), (int) (scaleY * 720));

		if (scaleY == smallerSF) {
			g2d.translate((Main.frame.getWidth() - smallerSF * 1080)/2, 0);
		}

		g2d.setColor(Color.LIGHT_GRAY);
		g2d.fillRect(0, 0, (int) (smallerSF * 1080), (int) (smallerSF * 720));
		
		if (scaleY == smallerSF) {
			g2d.translate(-(Main.frame.getWidth() - smallerSF * 1080)/2, 0);
		}
		
		g2d.translate(-(tileSize * MapSystem.playerX - Main.frame.getWidth()/2 + tileSize / 2),
				-(tileSize * MapSystem.playerY - Main.frame.getHeight()/2 + tileSize / 2));

		for (int i = 0; i < MapSystem.room.length; i++) {
			for (int j = 0; j < MapSystem.room[i].length; j++) {
				switch (MapSystem.room[i][j]) {
				case 0:
					g2d.drawImage(scaleImage(empty, smallerSF), (int) (tileSize * i * smallerSF),
							(int) (tileSize * j * smallerSF), null);
					break;
				case -1:
					g2d.setColor(Color.CYAN);
					g2d.fillRect((int) (tileSize * i * smallerSF), (int) (tileSize * j * smallerSF),
							(int) (tileSize * smallerSF), (int) (tileSize * smallerSF));
					break;
				case -2:
					g2d.setColor(Color.RED);
					g2d.fillRect((int) (tileSize * i * smallerSF), (int) (tileSize * j * smallerSF),
							(int) (tileSize * smallerSF), (int) (tileSize * smallerSF));
					break;
				case -3:
					g2d.setColor(Color.RED);
					g2d.fillRect((int) (tileSize * i * smallerSF), (int) (tileSize * j * smallerSF),
							(int) (tileSize * smallerSF), (int) (tileSize * smallerSF));
					break;
				case -4:
					g2d.setColor(Color.RED);
					g2d.fillRect((int) (tileSize * i * smallerSF), (int) (tileSize * j * smallerSF),
							(int) (tileSize * smallerSF), (int) (tileSize * smallerSF));
					break;
				case 1:
					g2d.drawImage(scaleImage(wall, smallerSF), (int) (tileSize * i * smallerSF),
							(int) (tileSize * j * smallerSF), null);
					break;
				case 2:
					g2d.drawImage(scaleImage(slime, smallerSF), (int) (tileSize * i * smallerSF),
							(int) (tileSize * j * smallerSF), null);
					break;
				case 3:
					g2d.drawImage(scaleImage(wall2, smallerSF), (int) (tileSize * i * smallerSF),
							(int) (tileSize * j * smallerSF), null);
					break;
				case 4:
					g2d.drawImage(scaleImage(wallbot, smallerSF), (int) (tileSize * i * smallerSF),
							(int) (tileSize * j * smallerSF), null);
					break;
				case 5:
					g2d.drawImage(scaleImage(wall3, smallerSF), (int) (tileSize * i * smallerSF),
							(int) (tileSize * j * smallerSF), null);
					break;
				default:
					g2d.setColor(Color.MAGENTA);
					g2d.fillRect((int) (tileSize * i * smallerSF), (int) (tileSize * j * smallerSF),
							(int) (tileSize * smallerSF), (int) (tileSize * smallerSF));
					break;
				}
			}
		}

		switch(MapSystem.dir) {
		case 0:
			g2d.drawImage(scaleImage(deltaBack, smallerSF),
					(int) (tileSize * smallerSF * MapSystem.playerX), (int) (tileSize * smallerSF * MapSystem.playerY),
					null);
			break;
		case 1:
			g2d.drawImage(scaleImage(deltaRight, smallerSF),
					(int) (tileSize * smallerSF * MapSystem.playerX), (int) (tileSize * smallerSF * MapSystem.playerY),
					null);
			break;
		case 2:
			g2d.drawImage(scaleImage(deltaFrontNormal, smallerSF),
					(int) (tileSize * smallerSF * MapSystem.playerX), (int) (tileSize * smallerSF * MapSystem.playerY),
					null);
			break;
		case 3:
			g2d.drawImage(scaleImage(deltaLeft, smallerSF),
					(int) (tileSize * smallerSF * MapSystem.playerX), (int) (tileSize * smallerSF * MapSystem.playerY),
					null);
			break;
		}
		
	}
}
