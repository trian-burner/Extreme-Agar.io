import greenfoot.*;

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World {
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1);
    }
    
    
    public void act() {
        MouseInfo m = Greenfoot.getMouseInfo();
        
        boolean inRange = false;
        
        if (m != null) {
            inRange = ((m.getX() < 520) && (m.getX() > 380)) && ((m.getY() < 510) && (m.getY() > 470));
        }
        
        
        if (Greenfoot.mouseClicked(this) && inRange == true) {
            World newWorld = new Agar();
            Greenfoot.setWorld(newWorld);
        }
    }
}
