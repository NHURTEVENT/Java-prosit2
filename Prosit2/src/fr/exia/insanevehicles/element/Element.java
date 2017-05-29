package fr.exia.insanevehicles.element;


public abstract class Element {

   
    private char sprite;

    
    public Element(final char sprite) {
        this.setSprite(sprite);
    }

   
    public final char getSprite() {
        return this.sprite;
    }

  
    protected void setSprite(final char sprite) {
        this.sprite = sprite;
    }

}
