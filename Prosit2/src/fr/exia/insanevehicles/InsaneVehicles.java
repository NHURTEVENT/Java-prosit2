package fr.exia.insanevehicles;

import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

public abstract class InsaneVehicles {

	private static char[][] map = new char[11][33];

	public static void main(final String[] args) throws FileNotFoundException {

		final InsaneVehiclesGames insaneVehiclesGame = new InsaneVehiclesGames();
		insaneVehiclesGame.play();
		


		
	}



	

	public void keyPressed(KeyEvent e) {
		// if(e.getKeyCode() == KeyEvent.VK_LEFT){
		System.out.println("yolo");

		// }
	}

	public static char[][] getMap() {
		return map;
	}

	public void setMap(char[][] map) {
		InsaneVehicles.map = map;
	}

	public static void addMap(int i, int j, char c) {
		InsaneVehicles.map[i][j] = c;

	}

	public static int getMapHeight(char[][] map) {

		String buffer = Character.toString(map[1][1]);
		buffer += Character.toString(map[2][1]);
		int height = Integer.parseInt(buffer);
		return height;
	}

	public static int getMapWidth(char[][] map) {

		String buffer = Character.toString(map[0][0]);
		buffer += Character.toString(map[1][0]);
		int width = Integer.parseInt(buffer);
		return width;
	}

}
