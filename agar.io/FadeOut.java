import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Fade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FadeOut extends Actor
{
    int transparency = 0;
    World world;
    Color color = Color.black;
    
    public FadeOut(World world) {
        this.world = world;
    }
    
    public FadeOut(World world, Color color) {
        this.world = world;
        this.color = color;
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
        transparency+=24;
        if (transparency > 255) {
            Greenfoot.setWorld(world);
        }
    }
}
