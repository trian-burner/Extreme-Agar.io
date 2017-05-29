import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class protein here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Protein extends ScrollActor
{
    String[] colors = {"blueProtein.png", "redProtein.png", "orangeProtein.png", "pinkProtein.png", "greenProtein.png"};
    String color;
    
    /**
     * Act - do whatever the protein wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor cell;
        cell = getOneIntersectingObject(Cell.class);
    }
    
    public Protein(int num) {
        super();
        color = colors[num];
        setImage(color);
    }
    
    public Protein(String color) {
        super();
        this.color = color;
    }
}
