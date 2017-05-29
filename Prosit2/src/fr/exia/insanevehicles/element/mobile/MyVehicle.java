package fr.exia.insanevehicles.element.mobile;

import fr.exia.insanevehicles.InsaneVehiclesGames;
import fr.exia.insanevehicles.element.motionless.MotionlessElementsFactory;

public class MyVehicle extends MobileElement {
	
	private static final char SPRITE= 'H';

	public MyVehicle() {
		super(SPRITE);
		
	}
	
	public static void addVehicleOnTheRoad(MobileElement car) {
	
	car.setX(InsaneVehiclesGames.getRoad().getWidth() / 2);
	car.setY(1);
	InsaneVehiclesGames.getRoad().setOnTheRoadXY(car, car.getX(), car.getY());

}
	public static void delVehicleOnTheRoad(MobileElement car) {
	
		
	InsaneVehiclesGames.getRoad().setOnTheRoadXY(MotionlessElementsFactory.createMacadam(),car.getX(),car.getY());
	InsaneVehiclesGames.getRoad().setOnTheRoadXY(car, car.getX(), car.getY());

}

	public static void moveVehicleLeft(MobileElement car) {
		
		car.setX(car.getX()-1);	
		car.setY(car.getY()+1);
		if (InsaneVehiclesGames.getRoad().getOnTheRoadXY(car.getX(),car.getY()).getSprite() == ' '){
			
		InsaneVehiclesGames.getRoad().setOnTheRoadXY(car,car.getX(),car.getY());
		}
		else{
			System.out.println("CRAAAAASSSHHHHH left");
			System.exit(0);
		}
		
	}
	
public static void moveVehicleRight(MobileElement car) {
		
		car.setX(car.getX()+1);	
		car.setY(car.getY()+1);
		if (InsaneVehiclesGames.getRoad().getOnTheRoadXY(car.getX(),car.getY()).getSprite() == ' '){
			
		InsaneVehiclesGames.getRoad().setOnTheRoadXY(car,car.getX(),car.getY());
		}
		else{
			System.out.println("CRAAAAASSSHHHHH right");
			System.exit(0);
		}
		
	}


public static void moveVehicleForward(MobileElement car) {
	
	car.setY(car.getY()+1);
	if (InsaneVehiclesGames.getRoad().getOnTheRoadXY(car.getX(),car.getY()).getSprite() == ' '){
		
	InsaneVehiclesGames.getRoad().setOnTheRoadXY(car,car.getX(),car.getY());
	}
	else{
		System.out.println("CRAAAAASSSHHHHH front");
		System.exit(0);
	}
	
}
	
	

}
