package main.battleSystemPrototype3;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.Main;

class BSKeyListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_M) {
			if (BSGraphics.bbView == 1) {
				BSGraphics.bbView = 0;
				try {
					Thread.sleep(20);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				BattleSystem.g.repaint();
			} else {
				BSGraphics.bbView = 1;
				try {
					Thread.sleep(20);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				BattleSystem.g.repaint();
			}
		}

		if (key == KeyEvent.VK_H) {
			for (int i = 0; i < BattleSystem.enemies.size(); i++) {
				Enemy enemy = BattleSystem.enemies.get(i);
				BattleSystem.enemies.get(i).setHealthPoints(enemy.getHealthPoints() - 1);
				BattleSystem.g.repaint();
			}
		}

		if (key == KeyEvent.VK_ESCAPE) {
			if (BSGraphics.bbView == 2 || BSGraphics.bbView == 3 || BSGraphics.bbView == 4) {
				BSGraphics.bbView = 0;
				System.out.println("esc");
			}
		}

		System.out.println();

		if (BSGraphics.bbView == 0) {
			if (key == KeyEvent.VK_1 || key == KeyEvent.VK_F) {
				BSGraphics.bbView = 2;
				BattleSystem.g.repaint();

				System.out.println("FIGHT VIEW");
			}

			if (key == KeyEvent.VK_2 || key == KeyEvent.VK_A) {
				BSGraphics.bbView = 3;
				BattleSystem.g.repaint();

				System.out.println("ACT VIEW");
			}

			if (key == KeyEvent.VK_3 || key == KeyEvent.VK_I) {
				BSGraphics.bbView = 4;
			}
		}

		if (BSGraphics.bbView == 2) {
			if (key == KeyEvent.VK_1 && BattleSystem.enemies.size() >= 1) {
				BattleSystem.enemies.get(0).setHealthPoints(BattleSystem.enemies.get(0).getHealthPoints() - 1);
				BattleSystem.g.repaint();

				for (int i = 0; i < BattleSystem.enemies.size(); i++) {
					BattleSystem.enemies.get(i).doTurn();
				}
			}

			if (key == KeyEvent.VK_2 && BattleSystem.enemies.size() >= 2) {
				BattleSystem.enemies.get(1).setHealthPoints(BattleSystem.enemies.get(1).getHealthPoints() - 1);
				BattleSystem.g.repaint();

				for (int i = 0; i < BattleSystem.enemies.size(); i++) {
					BattleSystem.enemies.get(i).doTurn();
				}
			}

			if (key == KeyEvent.VK_3 && BattleSystem.enemies.size() >= 3) {
				BattleSystem.enemies.get(2).setHealthPoints(BattleSystem.enemies.get(2).getHealthPoints() - 1);
				BattleSystem.g.repaint();

				for (int i = 0; i < BattleSystem.enemies.size(); i++) {
					BattleSystem.enemies.get(i).doTurn();
				}
			}

			if (key == KeyEvent.VK_4 && BattleSystem.enemies.size() >= 4) {
				BattleSystem.enemies.get(3).setHealthPoints(BattleSystem.enemies.get(3).getHealthPoints() - 1);
				BattleSystem.g.repaint();

				for (int i = 0; i < BattleSystem.enemies.size(); i++) {
					BattleSystem.enemies.get(i).doTurn();
				}
			}

			if (key == KeyEvent.VK_5 && BattleSystem.enemies.size() >= 5) {
				BattleSystem.enemies.get(4).setHealthPoints(BattleSystem.enemies.get(4).getHealthPoints() - 1);
				BattleSystem.g.repaint();

				for (int i = 0; i < BattleSystem.enemies.size(); i++) {
					BattleSystem.enemies.get(i).doTurn();
				}
			}
		}

		System.out.println(BSGraphics.bbView);

		if (BSGraphics.bbView == 3) {
			if (key == KeyEvent.VK_1 && BattleSystem.enemies.size() >= 1) {
				BSGraphics.selectedEnemy = 0;
				BattleSystem.g.repaint();

				System.out.println("SelEn" + BSGraphics.selectedEnemy);

				for (int i = 0; i < BattleSystem.enemies.size(); i++) {
					BattleSystem.enemies.get(i).doTurn();
				}
			}

			if (key == KeyEvent.VK_2 && BattleSystem.enemies.size() >= 2) {
				BSGraphics.selectedEnemy = 1;
				BattleSystem.g.repaint();

				System.out.println("SelEn" + BSGraphics.selectedEnemy);

				for (int i = 0; i < BattleSystem.enemies.size(); i++) {
					BSGraphics.bbView = 5;
				}
			}

			if (key == KeyEvent.VK_3 && BattleSystem.enemies.size() >= 3) {
				BSGraphics.selectedEnemy = 2;
				BattleSystem.g.repaint();

				System.out.println("SelEn" + BSGraphics.selectedEnemy);

				for (int i = 0; i < BattleSystem.enemies.size(); i++) {
					BattleSystem.enemies.get(i).doTurn();
				}
			}

			if (key == KeyEvent.VK_4 && BattleSystem.enemies.size() >= 4) {
				BSGraphics.selectedEnemy = 3;
				BattleSystem.g.repaint();

				System.out.println("SelEn" + BSGraphics.selectedEnemy);

				for (int i = 0; i < BattleSystem.enemies.size(); i++) {
					BattleSystem.enemies.get(i).doTurn();
				}
			}

			if (key == KeyEvent.VK_5 && BattleSystem.enemies.size() >= 5) {
				BSGraphics.selectedEnemy = 4;
				BattleSystem.g.repaint();

				for (int i = 0; i < BattleSystem.enemies.size(); i++) {
					BattleSystem.enemies.get(i).doTurn();
				}
			}
		}

		if (BSGraphics.bbView == 5) {
			if (key == KeyEvent.VK_1 && BattleSystem.enemies.size() >= 1) {
				BSGraphics.selectedEnemy = 0;
				BattleSystem.g.repaint();

				System.out.println("SelEn" + BSGraphics.selectedEnemy);

				for (int i = 0; i < BattleSystem.enemies.size(); i++) {
					BattleSystem.enemies.get(i).doTurn();
				}
			}

			if (key == KeyEvent.VK_2 && BattleSystem.enemies.size() >= 2) {
				BSGraphics.selectedEnemy = 1;
				BattleSystem.g.repaint();

				System.out.println("SelEn" + BSGraphics.selectedEnemy);

				for (int i = 0; i < BattleSystem.enemies.size(); i++) {
					BSGraphics.bbView = 5;
				}
			}

			if (key == KeyEvent.VK_3 && BattleSystem.enemies.size() >= 3) {
				BSGraphics.selectedEnemy = 2;
				BattleSystem.g.repaint();

				System.out.println("SelEn" + BSGraphics.selectedEnemy);

				for (int i = 0; i < BattleSystem.enemies.size(); i++) {
					BattleSystem.enemies.get(i).doTurn();
				}
			}

			if (key == KeyEvent.VK_4 && BattleSystem.enemies.size() >= 4) {
				BSGraphics.selectedEnemy = 3;
				BattleSystem.g.repaint();

				System.out.println("SelEn" + BSGraphics.selectedEnemy);

				for (int i = 0; i < BattleSystem.enemies.size(); i++) {
					BattleSystem.enemies.get(i).doTurn();
				}
			}

			if (key == KeyEvent.VK_5 && BattleSystem.enemies.size() >= 5) {
				BSGraphics.selectedEnemy = 4;
				BattleSystem.g.repaint();

				for (int i = 0; i < BattleSystem.enemies.size(); i++) {
					BattleSystem.enemies.get(i).doTurn();
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

class BSMouseListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(Main.frame.getWidth() / 2 - 385);
		System.out.println(e.getX());
		System.out.println(Main.frame.getWidth() / 2 + 385);
		System.out.println();
		System.out.println(Main.frame.getHeight() - 175);
		System.out.println(e.getY());
		System.out.println(Main.frame.getHeight() - 145);
		System.out.println();
		System.out.println();

		if (e.getX() > Main.frame.getWidth() / 2 - 250 && e.getX() < Main.frame.getWidth() / 2 - 150
				&& e.getY() > Main.frame.getHeight() - 139 && e.getY() < Main.frame.getHeight() - 89) {
			BSGraphics.bbView = 2;
			System.out.println("FIGHT VIEW");

			if (BSGraphics.bbView == 5) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			BattleSystem.g.repaint();
		}

		if (BSGraphics.bbView == 2 && BSGraphics.selectedEnemy == -1) {
			// Main.frame.getWidth() / 2 - 385, Main.frame.getHeight() - 145 + 30 * i
			for (int i = 0; i < BattleSystem.enemies.size(); i++) {
				if (e.getX() > Main.frame.getWidth() / 2 - 385 && e.getY() < Main.frame.getWidth() / 2 + 385
						&& e.getY() > Main.frame.getHeight() - 175 + 30 * i
						&& e.getY() < Main.frame.getHeight() - 145 + 30 * i) {
					BattleSystem.enemies.get(i).setHealthPoints(BattleSystem.enemies.get(i).getHealthPoints() - 1);
					BattleSystem.enemies.get(i).doTurn();
					BattleSystem.doAllChecks();
				}
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

public class BattleSystem {
	public static BSGraphics g = new BSGraphics();

	static ArrayList<Enemy> enemies = new ArrayList<Enemy>();

	public BattleSystem() {

	}

	@SuppressWarnings("static-access")
	public BattleSystem(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}

	public static void doAllChecks() {
		System.out.println(System.currentTimeMillis());
		
		for (int i = 0; i < enemies.size(); i++) {
			if (enemies.get(i).getHealthPoints() <= 0) {
				enemies.remove(i);
			}
		}

		if (BSGraphics.bbView == 5) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			BSGraphics.bbView = 0;

			System.out.println(System.currentTimeMillis());
			
			BattleSystem.g.repaint();
			
		}
	}

	public void run() {
		Main.frame.setVisible(true);
		Main.frame.setSize(1080, 720);
		Main.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Main.frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(Main.frame, "Are you sure to close this window?", "Really Closing?",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		Main.frame.add(g);

		Main.frame.addKeyListener(new BSKeyListener());
		Main.frame.addMouseListener(new BSMouseListener());

		g.repaint();
	}
}
