import greenfoot.*;

/**
 * Write a description of class Fade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FadeOut extends Actor
{
    int transparency = 0;
    String name;
    
    public FadeOut(String name) {
        super();
        this.name = name;
    }
    
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
        transparency+=24;
        if (transparency > 255) {
            World gameOver = new GameOver(name);
            Greenfoot.setWorld(gameOver);
        }
    }
}
