import greenfoot.*;
import java.awt.Color;

/**
 * FadeOut fades the current world out, then starts the new world with a fade in
 * 
 * @author Wayde Gilliam, Brian Turner, Cecilia Martin, Ethan Harris 
 */
public class FadeOut extends Actor
{
    int transparency = 0;
    World world;
    Color color = Color.black;
    
    /**
     * Creates a new FadeOut with a given world
     * 
     * @param world The world that will be created after the fadeout is done 
     */
    public FadeOut(World world) {
        this.world = world;
    }
    
    /**
     * Creates a new FadeOut with a given world and color of fade
     * 
     * @param world The world that will be created after the fadeout is done
     * @param color The color the fade should be
     */
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
