package fr.exia.insanevehicles.element.mobile;

public abstract class MobileElementFactory {

	 private static final MyVehicle VEHICLE = new MyVehicle();
	
	 
	 public static MyVehicle createVehicle(){
		 return VEHICLE;
	 }
}
