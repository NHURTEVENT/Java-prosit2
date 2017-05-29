package fr.exia.insanevehicles.element.motionless;

import fr.exia.insanevehicles.element.Element;

/**
 * <h1>A factory for creating MotionlessElements objects.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public abstract class MotionlessElementsFactory {

    /** The Constant DITCH. */
    private static final Ditch    DITCH    = new Ditch();
    private static final Ditch    RIGHT_DITCH    = new Ditch('/');
    private static final Ditch    LEFT_DITCH    = new Ditch('\\');

    /** The Constant MACADAM. */
    private static final Macadam  MACADAM  = new Macadam();

    /** The Constant OBSTACLE. */
    private static final Obstacle OBSTACLE = new Obstacle();
    
    private static final Obstacle DECOR = new Obstacle('^');

    /**
     * Creates a new ditch object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDitch() {
        return DITCH;
    }

    /**
     * Creates a new macadam object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createMacadam() {
        return MACADAM;
    }

    /**
     * Creates a new obstacle object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createObstacle() {
        return OBSTACLE;
    }
   
    public static MotionlessElement createObstacle(char sprite) {
    	if (sprite!= '^'){
    		System.out.println("charactere inconnu ");
    	}
    	else;
        return DECOR;
    }
    
    public static MotionlessElement createDitch(char sprite) {
       
        if(sprite == '/'){
        	return RIGHT_DITCH;
        }
        else if (sprite =='\\'){
        	
        	return LEFT_DITCH;
        }
        
        	else{
        	System.out.println("t appelle ditch mais il est pas left ou right");
        return null;}
        
    }

	public static MotionlessElement create(char c) {
		
		switch(c){
		
		case '\\': //il prend pas les \ donc si je lui en met 2 il devrait accepter
			return createDitch('\\');
		
		case '/':
			return createDitch('/');
		
		case '^':
			return createObstacle('^');
		
		case ' ':
			return createMacadam();
		
		case '|':
			return createDitch();
		
		case 'X':
			return createObstacle();
		
		default:
			throw new IllegalArgumentException("charactère inconnu "+c);
			
		
		
		}

		//TODO switch case sur la char, done
		//TODO poly paramétrique sur le ditch, done
		
	}
}
