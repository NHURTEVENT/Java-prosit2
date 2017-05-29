package fr.exia.insanevehicles;


import java.util.Random;

import fr.exia.insanevehicles.element.Element;
import fr.exia.insanevehicles.element.mobile.MobileElement;
import fr.exia.insanevehicles.element.motionless.MotionlessElementsFactory;


public class Road {

	private int width;

	private int height;

	private static int view;

	private int quota;

	private final Element[][] onTheRoad;

	public Road(final int width, final int height, final int view, final int quota) {
		this.setWidth(width);
		this.setHeight(height);
		this.setView(view);
		this.setQuota(quota);
		this.onTheRoad = new Element[this.getWidth()][this.getHeight()];
		// readFile();
	}

	public final void show(final int yStart) {
		int y = yStart;
		for (int view = 0; view < this.getView(); view++) {
			y = (y + 1) % this.getHeight();
			for (int x = 0; x < this.getWidth(); x++) {
				Element e = this.getOnTheRoadXY(x, y);
				char truc = e.getSprite();
				System.out.print(truc);
			}
			System.out.print("\n");
		}
	}

	@Deprecated
	private void fillOnTheRoad() {
		final Random random = new Random();

		for (int y = 0; y < this.getHeight(); y++) {
			for (int x = 0; x < this.getWidth(); x++) {

				if ((x == 0) || (x == (this.getWidth() - 1))) {
					this.setOnTheRoadXY(MotionlessElementsFactory.createDitch(), x, y);
				} else if ((random.nextInt() % this.getQuota()) == 0) {
					this.setOnTheRoadXY(MotionlessElementsFactory.createObstacle(), x, y);
				} else {
					this.setOnTheRoadXY(MotionlessElementsFactory.createMacadam(), x, y);
				}
			}

		}

	}

	public final int getWidth() {
		return this.width;
	}

	private void setWidth(final int width) {
		this.width = width;
	}

	public final int getHeight() {
		return this.height;
	}

	private void setHeight(final int height) {
		this.height = height;
	}

	public final int getView() {
		return Road.view;
	}

	private void setView(final int view) {
		this.view = view;
	}

	public final int getQuota() {
		return this.quota;
	}

	private void setQuota(final int quota) {
		this.quota = quota;
	}

	public final Element getOnTheRoadXY(final int x, final int y) {
		return this.onTheRoad[x][y];
	}

	public final void setOnTheRoadXY(final Element element, final int x, final int y) {
		this.onTheRoad[x][y] = element;
	}
	
	public Coordinate getCoord(MobileElement element){
		
		for (int x=0;x <width;x++){
			for (int y = 0; y < height; y++) {
				Element machin = getOnTheRoadXY(x, y) ;
				if(element == machin)
					return new Coordinate(x,y);
				
			}
		}
		
		return null;
		
	}
	

	

	public Element removeOnTheRoad(Coordinate coord, Element element) {
		Element ancient =getOnTheRoadXY(coord.getX(), coord.getY());
		setOnTheRoadXY(element,coord.getX(), coord.getY());
		return ancient;
		
	}

}
