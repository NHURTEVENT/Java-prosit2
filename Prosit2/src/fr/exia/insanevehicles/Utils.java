package fr.exia.insanevehicles;

public class Utils {

	
	/**
	 * 
	 * @param delay En millisecondes
	 */
	public static void sleep(long delay){
		
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.exit(0);
		}
		
	}

	public static void clearConsole() {

		for(int i=0;i<50;i++){
			System.out.println();
		}
		
	}
	
}
