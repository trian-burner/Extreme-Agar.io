import greenfoot.*;
import java.awt.Color;

/**
 * FadeIn fades into the newly created world
 * 
 * @author Wayde Gilliam, Brian Turner, Cecilia Martin, Ethan Harris 
 */
public class FadeIn extends Actor
{
    int transparency = 255;
    Color color = Color.black;
    
    /**
     * Creates a new FadeIn
     */
    public FadeIn() {
        super();
        GreenfootImage fade = new GreenfootImage(900, 600);
        fade.fill();
        setImage(fade);
    }
    
    /**
     * Sets the color of the fade in
     * 
     * @param color Cell Color
     */
    public FadeIn(Color color) {
        super();
        
        this.color = color;
        
        GreenfootImage fade = new GreenfootImage(900, 600);
        fade.setColor(color);
        fade.fill();
        setImage(fade);
    }
    
    /**
     * Act - do whatever the Fade wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        getWorld().setActOrder(Protein.class, Virus.class);
        GreenfootImage fade = new GreenfootImage(900, 600);
        fade.setColor(color);
        fade.fill();
        fade.setTransparency(transparency);
        setImage(fade);
        transparency-=24;
        if (transparency < 0) {
            getWorld().removeObject(this);
        }
    }
}
