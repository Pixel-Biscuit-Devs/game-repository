package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.battleSystemPrototype3.*;
import main.mapSystemPrototype1.MapSystem;
import main.roomSerializer.RoomEditor;

class MMMouseListener implements MouseListener {

	@SuppressWarnings("static-access")
	@Override
	public void mouseClicked(MouseEvent e) {
		if (Main.scene == 0 && e.getX() > Main.frame.getWidth() / 2 - 100
				&& e.getX() < Main.frame.getWidth() / 2 + 100) {

			Main.frame.remove(Main.g);

			System.out.println(e.getY());

			if (e.getY() > 280 && e.getY() < 380) {
				System.out.println("Started Battle System");

				Main.scene = 1;

				ArrayList<Enemy> enemies = new ArrayList<>();
				enemies.add(new EnemyTemplates().newSlime());
				enemies.add(new EnemyTemplates().newSlime());
				
				BattleSystem bs = new BattleSystem(enemies);
				bs.run();
				bs.g.repaint();
			}

			if (e.getY() > 430 && e.getY() < 530) {
				int area = 0;
				int[][] room = null;
				int[] exitTo = null;

				do {
					String roomName = JOptionPane.showInputDialog("What is the name of the room you want to load?");
					
					try (InputStream is = getClass().getResourceAsStream("mapSystemPrototype1/rooms/" + roomName + ".room"); ObjectInputStream os = new ObjectInputStream(is)) {

						area = (int) os.readObject();
						room = (int[][]) os.readObject();
						exitTo = (int[]) os.readObject();

						System.out.println("LOADED");

					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}


				} while (false);

				MapSystem ms = new MapSystem(area, room, exitTo);
				ms.run();
				ms.g.repaint();

				Main.scene = 2;
			}

			if (e.getY() > 580 && e.getY() < 680) {
				RoomEditor re = new RoomEditor();
				re.run();
				re.g.repaint();

				Main.scene = 3;

				System.out.println("worked");
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}

class MainMenuGraphics extends GameGraphics {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8440003644448491858L;

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
		g2d.fillRect((int) (smallerSF * 0), (int) (smallerSF * 0), (int) (smallerSF * 1080), (int) (smallerSF * 720));

		try {
			g2d.drawImage(scaleImage(ImageIO.read(getClass().getResource("res/deltasislogo.png")), 1.5), Main.frame.getWidth() / 2 - 360, 50, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		g2d.setColor(Color.BLUE);
		g2d.drawRect(Main.frame.getWidth() / 2 - 100, 250, 200, 100);
		g2d.drawRect(Main.frame.getWidth() / 2 - 100, 400, 200, 100);
		g2d.drawRect(Main.frame.getWidth() / 2 - 100, 550, 200, 100);
		
		g2d.setColor(Color.BLACK);
		g2d.drawString("Battle System Prototype", Main.frame.getWidth() / 2 - 50, 300);
		g2d.drawString("Map System Prototype", Main.frame.getWidth() / 2 - 50, 450);
		g2d.drawString("Room Editor Prototype", Main.frame.getWidth() / 2 - 50, 600);
	}
}

public class Main {

	public static JFrame frame = new JFrame("Deltasis");

	public static int playerHP = 20;
	public static int playerX = 60;
	public static int playerY = 120;

	// 0 = menu
	// 1 = battle system
	// 2 = map system
	// 3 = room editor
	public static int scene = 0;

	public static MainMenuGraphics g = new MainMenuGraphics();

	public static ArrayList<Enemy> testSet = new ArrayList<>();
	
	public static Player player = new Player();

	public static void main(String[] args) {
		frame.setVisible(true);
		frame.setSize(1080, 720);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(frame, "Are you sure?", "Really Closing?",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		frame.addMouseListener(new MMMouseListener());

		// testSet.add(Enemy.SLIME);
		// testSet.add(Enemy.OUT);

		// BattleSystem bs = new BattleSystem(testSet);
		// bs.run();

		// MapSystem ms = new MapSystem();
		// ms.run();

		frame.add(g);

		if (scene == 0) {
			g.repaint();
		}
	}
}
