import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class protein here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Protein extends ScrollActor
{
    /**
     * Act - do whatever the protein wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor cell;
        cell = getOneIntersectingObject(Cell.class);
    }
    
    public Protein(int color) {
        super();
        switch(color) {
            case 0:
                setImage("blueProtein.png");
                break;
            case 1: 
                setImage("redProtein.png");
                break;
            case 2:
                setImage("orangeProtein.png");
                break;
            case 3:
                setImage("pinkProtein.png");
                break;
            case 4:
                setImage("greenProtein.png");
                break;
            }
    }
}
