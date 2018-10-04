package main.roomSerializer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

import main.Main;

class REKeyListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (e.isControlDown() && key == KeyEvent.VK_S) {
			for (int i = 0; i < RoomEditor.room.length; i++) {
				for (int j = 0; j < RoomEditor.room[i].length; j++) {
					System.out.print(RoomEditor.room[i][j] + ", ");
				}
				System.out.println();
			}
			RoomEditor.saveFile();
		}

		if (e.isControlDown() && !e.isShiftDown() && key == KeyEvent.VK_R) {
			RoomEditor.area = Integer
					.valueOf(JOptionPane.showInputDialog(Main.frame, "What area should this room be a part of?"));
		}

		if (e.isControlDown() && key == KeyEvent.VK_O) {
			for (int i = 0; i < RoomEditor.room.length; i++) {
				for (int j = 0; j < RoomEditor.room[i].length; j++) {
					System.out.print(RoomEditor.room[i][j] + ", ");
				}
				System.out.println();
			}
			new RoomEditor().loadFile();
			for (int i = 0; i < RoomEditor.room.length; i++) {
				for (int j = 0; j < RoomEditor.room[i].length; j++) {
					System.out.print(RoomEditor.room[i][j] + ", ");
				}
				System.out.println();
			}

			RoomEditor.g.repaint();
		}

		if (e.isControlDown() && e.isShiftDown() && key == KeyEvent.VK_R) {
			for (int i = 0; i < RoomEditor.room.length; i++) {
				for (int j = 0; j < RoomEditor.room[i].length; j++) {
					System.out.print(RoomEditor.room[i][j] + ", ");
				}
				System.out.println();
			}

			System.out.println(RoomEditor.room.length);
			System.out.println(RoomEditor.room[0].length);

			System.out.println(RoomEditor.room[0][0]);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}

class REMouseListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getX() - 7 < EditorGraphics.tileSize * RoomEditor.room.length && e.getY() - 30 < EditorGraphics.tileSize * RoomEditor.room[0].length) {
			int blockI = (e.getX() - 7) / EditorGraphics.tileSize;
			int blockJ = (e.getY() - 30) / EditorGraphics.tileSize;

			if (RoomEditor.selectedTile < 0) {
				for (int i = 0; i < RoomEditor.room.length; i++) {
					for (int j = 0; j < RoomEditor.room[i].length; j++) {
						if (RoomEditor.room[i][j] == RoomEditor.selectedTile) {
							RoomEditor.room[i][j] = 0;
						}
					}
				}
			}

			switch (RoomEditor.selectedTile) {
			case -4:
				RoomEditor.exitTo[1] = Integer.valueOf(
						JOptionPane.showInputDialog("Type the ID of the room this exit should lead to"));
				break;
			case -3:
				RoomEditor.exitTo[2] = Integer.valueOf(
						JOptionPane.showInputDialog("Type the ID of the room this exit should lead to"));
				break;
			case -2:
				RoomEditor.exitTo[3] = Integer.valueOf(
						JOptionPane.showInputDialog("Type the ID of the room this exit should lead to"));
				break;
			}

			RoomEditor.room[blockI][blockJ] = RoomEditor.selectedTile;

			RoomEditor.g.repaint();
		} else {
			RoomEditor.selectedTile = Integer
					.valueOf(JOptionPane.showInputDialog(Main.frame, "Type the ID of the desired tile"));
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

public class RoomEditor {
	static int[][] room;

	// 0 = town
	static int area = 0;

	// -4 = exit 1
	// -3 = exit 2
	// -2 = exit 3
	// -1 = entrance
	// 0 = empty
	// 1 = wall
	// 2 = slime
	static int selectedTile = 1;

	static int[] exitTo = new int[3];

	public static EditorGraphics g = new EditorGraphics();

	public void run() {

		int roomWidth = Integer.valueOf(JOptionPane.showInputDialog(Main.frame, "How wide do you want the room to be"));
		int roomHeight = Integer
				.valueOf(JOptionPane.showInputDialog(Main.frame, "How tall do you want the room to be"));

		room = new int[roomWidth][roomHeight];

		Main.frame.add(g);
		
		Main.frame.addMouseListener(new REMouseListener());
		Main.frame.addKeyListener(new REKeyListener());

		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				if (i == 0 || i == room.length - 1 || j == 0 || j == room[i].length - 1) {
					room[i][j] = 1;
				} else {
					room[i][j] = 0;
				}
			}
		}

		g.repaint();
	}

	public static void saveFile() {
		String filename = JOptionPane.showInputDialog(Main.frame, "Enter the name of your room");

		File saveFolder = new File("rooms");

		if (!saveFolder.isDirectory()) {
			saveFolder.mkdir();
		}

		try (FileOutputStream fs = new FileOutputStream(saveFolder + "/" + filename + ".room")) {

			ObjectOutputStream os = new ObjectOutputStream(fs);

			os.writeObject(area);
			os.writeObject(room);
			os.writeObject(exitTo);

			os.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}

	public void loadFile() {
		do {
			String roomName = JOptionPane.showInputDialog("What is the name of the room you want to load?");

			try (InputStream is = getClass().getResourceAsStream("rooms/" + roomName + ".room"); ObjectInputStream os = new ObjectInputStream(is)) {

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
	}
}
