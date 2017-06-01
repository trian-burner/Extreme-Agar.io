import greenfoot.*;
import java.awt.Color;

/**
 * The screen you see when you die or exit the game.
 * 
 * @author Wayde Gilliam, Brian Turner, Cecilia Martin, Ethan Harris 
 */
public class GameOver extends World {
    String name;
    
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver(String name)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1);
        addObject(new FadeIn(), 450, 300);
        this.name = name;
    }
    
    public void act() {
        MouseInfo m = Greenfoot.getMouseInfo();
        
        boolean inRange = false;
        
        if (m != null) {
            inRange = ((m.getX() < 520) && (m.getX() > 380)) && ((m.getY() < 510) && (m.getY() > 470));
        }
        
        if (Greenfoot.mouseClicked(this) && inRange == true) {
            addObject(new FadeOut(new StartScreen(name), Color.white), 450, 300);
        }
    }
}
