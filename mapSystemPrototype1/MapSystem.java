package main.mapSystemPrototype1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.Main;

class MSKeyListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_W) {
			if (MapSystem.playerY > 0 
					&& MapSystem.room[MapSystem.playerX][MapSystem.playerY - 1] != 1
					&& MapSystem.room[MapSystem.playerX][MapSystem.playerY - 1] != 3
					&& MapSystem.room[MapSystem.playerX][MapSystem.playerY - 1] != 5) {
				MapSystem.playerY--;
				MapSystem.dir = 0;
			}
		}
		if (key == KeyEvent.VK_A) {
			if (MapSystem.playerX > 0 
					&& MapSystem.room[MapSystem.playerX - 1][MapSystem.playerY] != 1
					&& MapSystem.room[MapSystem.playerX - 1][MapSystem.playerY] != 3
					&& MapSystem.room[MapSystem.playerX - 1][MapSystem.playerY] != 5) {
				MapSystem.playerX--;
				MapSystem.dir = 3;
			}
		}
		if (key == KeyEvent.VK_S) {
			if (MapSystem.playerY < MapSystem.room[0].length - 1
					&& MapSystem.room[MapSystem.playerX][MapSystem.playerY + 1] != 1
					&& MapSystem.room[MapSystem.playerX][MapSystem.playerY + 1] != 3
					&& MapSystem.room[MapSystem.playerX][MapSystem.playerY + 1] != 5) {
				MapSystem.playerY++;
				MapSystem.dir = 2;
			}
		}
		if (key == KeyEvent.VK_D) {
			if (MapSystem.playerX < MapSystem.room.length - 1
					&& MapSystem.room[MapSystem.playerX + 1][MapSystem.playerY] != 1
					&& MapSystem.room[MapSystem.playerX + 1][MapSystem.playerY] != 3
					&& MapSystem.room[MapSystem.playerX + 1][MapSystem.playerY] != 5) {
				MapSystem.playerX++;
				MapSystem.dir = 1;
			}
		}

		MapSystem.g.repaint();
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

public class MapSystem {
	public MapSystem(int area, int[][] room, int[] exitTo) {
		MapSystem.area = area;
		MapSystem.room = room;
		MapSystem.exitTo = exitTo;
	}

	static int area;
	static int[][] room;
	static int[] exitTo;

	static int playerX;
	static int playerY;

	public static MapGraphics g = new MapGraphics();
	
	/**
	 * 0 = back, 1 = right, 2 = front, 3 = left
	 */
	static int dir;

	public void run() {

		Main.frame.add(g);

		Main.frame.addKeyListener(new MSKeyListener());

		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				if (room[i][j] == -1) {
					playerX = i;
					playerY = j;
					
					if(i == 0) {
						dir = 1;
					}
					
					if(i == room.length - 1) {
						dir = 3;
					}
					
					if(j == 0) {
						dir = 0;
					}
					
					if(j == room[i].length - 1) {
						dir = 2;
					}
				}
			}
		}

		g.repaint();
	}
}
