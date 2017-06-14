import greenfoot.*;
import java.awt.Color;

/**
 * The screen you see when you die or exit the game.
 * 
 * @author Wayde Gilliam, Brian Turner, Cecilia Martin, Ethan Harris 
 */
public class GameOver extends World {
    String name;
    GreenfootSound music = new GreenfootSound("die.wav");
    
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver(String name)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        
        music.play();
        
        addObject(new FadeIn(), 600, 400);
        this.name = name;
    }
    
    public void act() {
        MouseInfo m = Greenfoot.getMouseInfo();
        
        boolean inRange = false;
        
        if (m != null) {
            inRange = ((m.getX() < 660) && (m.getX() > 520)) && ((m.getY() < 560) && (m.getY() > 530));
        }
        
        if (Greenfoot.mouseClicked(this) && inRange == true) {
            music.stop();
            addObject(new FadeOut(new StartScreen(name), Color.white), 600, 400);
        }
    }
}
