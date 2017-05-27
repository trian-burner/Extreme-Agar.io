import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{
    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen() {
        super(900, 600, 1);
        addObject(new nameBox(), getWidth()/2, 350);
    }
    
    public StartScreen(String name) {
        super(900, 600, 1);
        addObject(new nameBox(name), getWidth()/2, 350);
    }
}
