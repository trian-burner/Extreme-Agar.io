import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * The counter class creates images on the cell recording its mass value
 * 
 * @author Wayde Gilliam, Brian Turner, Cecilia Martin, Ethan Harris
 */
public class Counter extends Actor
{
    /**
     * Default Constructor
     */
    public Counter() {
        setImage(new GreenfootImage("20", 22, Color.black, null));
    }
    
    /**
     * Increase the total amount displayed on the counter, by a given amount
     * 
     * @param mass The Cell mass
     * @param speed The Cell speed, used for debugging
     */
    public void updateCount(int mass, int speed) {
        setImage(new GreenfootImage("" + mass, 22, Color.black, null));
    }
}