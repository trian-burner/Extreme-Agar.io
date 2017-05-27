import greenfoot.*;

/**
 * Write a description of class Fade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FadeIn extends Actor
{
    int transparency = 255;
    
    /**
     * Act - do whatever the Fade wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        getWorld().setActOrder(Protein.class, DeathTester.class, Virus.class);
        GreenfootImage fade = new GreenfootImage(900, 600);
        fade.fill();
        fade.setTransparency(transparency);
        setImage(fade);
        transparency-=24;
        if (transparency < 0) {
            getWorld().removeObject(this);
        }
    }
}
