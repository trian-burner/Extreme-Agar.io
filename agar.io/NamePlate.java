import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Displays cell name on the cell
 * 
 * @author Wayde Gilliam, Brian Turner, Cecilia Martin, Ethan Harris
 */
public class NamePlate extends Actor
{
    String name;
    
    /**
     * Constructor for NamePlate
     * 
     * @param name Cell name
     */
    public NamePlate(String name) {
        setImage(new GreenfootImage(name, 24, Color.black, null));
        this.name = name;
    }
    
    /**
     * Actor method for the NamePlate class
     */
    public void act() {
        setImage(new GreenfootImage(name, 24, Color.black, null));
    }
}