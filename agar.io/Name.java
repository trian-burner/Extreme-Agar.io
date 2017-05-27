import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Name here.
 * 
 * @author (Brian Turner) 
 * @version (0.0.1)
 */
public class Name extends Actor
{
    String name;
    
    public Name(String name) {
        setImage(new GreenfootImage(name, 24, Color.black, null));
        this.name = name;
    }
    
    public void act() {
        setImage(new GreenfootImage(name, 24, Color.black, null));
    }
}