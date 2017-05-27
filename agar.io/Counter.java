import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Counter here.
 * 
 * @author (Wayde Gilliam) 
 * @version (0.0.1)
 */
public class Counter extends Actor
{
    public Counter() {
        setImage(new GreenfootImage("20", 22, Color.black, null));
    }
    
    /**
     * Increase the total amount displayed on the counter, by a given amount.
     */
    public void updateCount(int mass, int speed) {
        setImage(new GreenfootImage("" + mass, 22, Color.black, null));
    }
}