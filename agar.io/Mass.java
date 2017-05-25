import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Mas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mass extends ScrollActor
{
    /**
     * Act - do whatever the Mas wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        GreenfootImage mass = new GreenfootImage(25, 25);
        mass.setColor(Color.BLUE);
        mass.fillOval(0, 0, 25, 25);
        setImage(mass);
    }    
}
