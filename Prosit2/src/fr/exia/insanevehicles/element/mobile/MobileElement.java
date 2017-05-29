package fr.exia.insanevehicles.element.mobile;

import fr.exia.insanevehicles.element.Element;

public abstract class MobileElement extends Element{
	
	int x,y;
	

	public MobileElement(char sprite) {
		super(sprite);
	}

	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}
}
