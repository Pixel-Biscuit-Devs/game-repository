package main.roomSerializer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GameGraphics;
import main.Main;

public class EditorGraphics extends GameGraphics {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5733217851487412240L;
	static int tileSize = 30;

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

		g2d.setColor(Color.LIGHT_GRAY);
		g2d.drawRect((int) (smallerSF * 0), (int) (smallerSF * 0), (int) (smallerSF * 1080), (int) (smallerSF * 720));

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

		for (int i = 0; i < RoomEditor.room.length; i++) {
			for (int j = 0; j < RoomEditor.room[i].length; j++) {
				switch (RoomEditor.room[i][j]) {
				case 0:
					g2d.drawImage(scaleImage(empty, smallerSF * (double) tileSize / 60),
							(int) (tileSize * i * smallerSF), (int) (tileSize * j * smallerSF), null);
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
					g2d.setColor(Color.BLACK);
					g2d.drawString("3", (int) (tileSize * i * smallerSF) + 5, (int) (tileSize * j * smallerSF) + 12);
					break;
				case -3:
					g2d.setColor(Color.RED);
					g2d.fillRect((int) (tileSize * i * smallerSF), (int) (tileSize * j * smallerSF),
							(int) (tileSize * smallerSF), (int) (tileSize * smallerSF));
					g2d.setColor(Color.BLACK);
					g2d.drawString("2", (int) (tileSize * i * smallerSF) + 5, (int) (tileSize * j * smallerSF) + 12);
					break;
				case -4:
					g2d.setColor(Color.RED);
					g2d.fillRect((int) (tileSize * i * smallerSF), (int) (tileSize * j * smallerSF),
							(int) (tileSize * smallerSF), (int) (tileSize * smallerSF));
					g2d.setColor(Color.BLACK);
					g2d.drawString("1", (int) (tileSize * i * smallerSF) + 5, (int) (tileSize * j * smallerSF) + 12);
					break;
				case 1:
					g2d.drawImage(scaleImage(wall, smallerSF * (double) tileSize / 60),
							(int) (tileSize * i * smallerSF), (int) (tileSize * j * smallerSF), null);
					break;
				case 2:
					g2d.drawImage(scaleImage(slime, smallerSF * (double) tileSize / 60),
							(int) (tileSize * i * smallerSF), (int) (tileSize * j * smallerSF), null);
					break;
				case 3:
					g2d.drawImage(scaleImage(wall2, smallerSF * (double) tileSize / 60),
							(int) (tileSize * i * smallerSF), (int) (tileSize * j * smallerSF), null);
					break;
				case 4:
					g2d.drawImage(scaleImage(wallbot, smallerSF * (double) tileSize / 60),
							(int) (tileSize * i * smallerSF), (int) (tileSize * j * smallerSF), null);
					break;
				case 5:
					g2d.drawImage(scaleImage(wall3, smallerSF * (double) tileSize / 60),
							(int) (tileSize * i * smallerSF), (int) (tileSize * j * smallerSF), null);
					break;
				default:
					g2d.setColor(Color.MAGENTA);

					g2d.fillRect((int) (tileSize * i * smallerSF * (double) tileSize / 60),
							(int) (tileSize * j * smallerSF * (double) tileSize / 60),
							(int) (tileSize * smallerSF * (double) tileSize / 60),
							(int) (tileSize * smallerSF * (double) tileSize / 60));
					break;
				}

				g2d.setColor(Color.BLACK);
				for (int k = 0; k <= RoomEditor.room.length; k++) {
					g2d.drawLine(tileSize * k, 0, tileSize * k, tileSize * RoomEditor.room[0].length);
				}
				for (int k = 0; k <= RoomEditor.room[0].length; k++) {
					g2d.drawLine(0, tileSize * k, tileSize * RoomEditor.room.length, tileSize * k);
				}

				g2d.drawString("Areas: 0 = town", 100, 500);
				g2d.drawString(
						"Tiles: -4 = exit 1, -3 = exit 2, -2 = exit 3, -1 = entrance, 0 = empty, 1 = wall, 2 = slime, 3 = wall2, 4 = wallbot, 5 = wall3",
						100, 600);
				g2d.drawString("CTRL + O = Open .room file, CTRL + R = Change area, CTRL + S = Save room", 100, 400);
			}
		}
	}
}
