package fr.exia.insanevehicles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import fr.exia.insanevehicles.element.Element;
import fr.exia.insanevehicles.element.mobile.MobileElement;
import fr.exia.insanevehicles.element.mobile.MobileElementFactory;
import fr.exia.insanevehicles.element.mobile.MyVehicle;
import fr.exia.insanevehicles.element.motionless.MotionlessElementsFactory;

public class InsaneVehiclesGames {
	
	
	public static final int ROAD_VIEW = 10;

	public static final int ROAD_QUOTA = 20;

	private static Road road;
	
	private static MyVehicle car;

	private static MobileElement voiture;

	public InsaneVehiclesGames() throws FileNotFoundException {
		this.setRoad(createRoad("../res/road.txt"));
		//addVehicleOnTheRoad();
	}

	private Road createRoad(String file) throws FileNotFoundException {
		String realPath = this.getClass().getClassLoader().getResource(".").getPath();
		realPath += file;
		File target = new File(realPath);
		// on ouvre le fichier
		
		Scanner input = new Scanner(target);
		
		int width = Integer.parseInt(input.nextLine());
		int height = Integer.parseInt(input.nextLine());
		
		Road road = new Road(width, height, ROAD_VIEW,ROAD_QUOTA );
		
		int y=0;
		 while (input.hasNextLine()) {
	            String line = input.nextLine();
	            
	            for(int i=0; i<width;i++){
	            	// on récup le char en posiion i,x
	            	char c = line.charAt(i);
	            	// la factory crée l'élement correspondant
	            	Element e = MotionlessElementsFactory.create(c);
	            	// on place l'élement sur la route
	            	road.setOnTheRoadXY(e, i, y);
	            	
	            	
	            }
	            y++;
	        }
		//fermeture
		input.close();
		return road;
	}

public void moveY(MobileElement element, int nbPas){
		Coordinate coord = getRoad().getCoord(element);
		getRoad().removeOnTheRoad(coord, MotionlessElementsFactory.createMacadam());
		coord.addY(nbPas);
		Element e = getRoad().removeOnTheRoad(coord, element);
	}
	
	
	private void MoveVehicleForward(MobileElement car) {
		
		// this.getRoad().setOnTheRoadXY(car, car.ge , y);
	}

	public static void addVehicleOnTheRoad() {
		
	voiture = MobileElementFactory.createVehicle();
	getRoad().setOnTheRoadXY(voiture, getRoad().getWidth()/2, 0);
	

	}
	
	
	public static MobileElement getVehicle(){
		return voiture;
	}
	
	public final void play() {
		addVehicleOnTheRoad();
		int i=0;
		for(;i<getRoad().getView();i++){
			
			moveY(getvehicle(),1);
			Utils.clearConsole();
			
			this.getRoad().show(i);
			Utils.sleep(1000);
		}
		
	
		
		/*
		//placer le vehicule
		
		//créer le vhicle
		MobileElement car = MobileElementFactory.createVehicle();
		//le placer au départ
		MyVehicle.addVehicleOnTheRoad(car);
		getRoad().show(0);
		gameLoop(car);
		//this.getRoad().afficherMap(map, mapWidth, mapHeight, yStart);;
	//	gameLoop();

		// key-listener ici*/
	}

	private MobileElement getvehicle() {
		// TODO Auto-generated method stub
		return voiture;
	}

	public final static Road getRoad() {
		return InsaneVehiclesGames.road;
	}

	private void setRoad(final Road road) {
		this.road = road;
	}

	public static MyVehicle getCar() {
		return car;
	}

	public static void setCar(MyVehicle car) {
		InsaneVehiclesGames.car = car;
	}
	
	static void gameLoop(MobileElement car) {
		
		
		
		int i = 1;
		for (;i<getRoad().getHeight()-getRoad().getView();i++) {
			
			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			
			//bouger le véhicle sur la map
			Scanner keyboard = new Scanner(System.in);
			String parLa = keyboard.next();
			char dirrection = parLa.charAt(0);
			
			//System.out.println(myint);
			
			if(dirrection == 'd'){
			MyVehicle.moveVehicleRight(car);
			}

			else if(dirrection == 'q'){
			MyVehicle.moveVehicleLeft(car);
			}
			
			else if(parLa ==null || dirrection != 'q' || dirrection != 'd'){
				MyVehicle.moveVehicleForward(car);
			}
			MyVehicle.moveVehicleForward(car);
			getRoad().show(i);
			
			
			
		}

	}
	
	@Deprecated
	public static void readFile() {
		FileReader inputStream = null;
		int i = 0;
		int j = 0;

		try {
			try {
				inputStream = new FileReader("road.txt");
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}

			int c;
			try {
				while ((c = inputStream.read()) != -1) {
					if (c != 13) {
						// System.out.print((char) c);
						InsaneVehicles.addMap(i, j, (char) c);
						i++;

					} else {
						// System.out.print((char) 13);
						j++;
						i = 0;
					}

					// System.out.println( c);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	@Deprecated
public static void afficherMap(char[][] map, int mapWidth, int mapHeight, int yStart) {
		
		int i = 0;
		int j = yStart;
		

		for (;j < yStart + getRoad().getView() + 2  && j < mapHeight ; j++) {
			for (; i <= mapWidth; i++) {
				System.out.print(map[i][j]);
			}
			i = 0;
			System.out.print((char) 13);
		}
	}
	
}
