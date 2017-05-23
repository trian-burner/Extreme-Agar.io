import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class protein here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class protein extends ScrollActor
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
    
    public protein(int color) {
        super();
        switch(color) {
            case 1:
                setImage("blueProtein.bmp");
                break;
            case 2: 
                setImage("redProtein.bmp");
                break;
                
            }
    }
}
