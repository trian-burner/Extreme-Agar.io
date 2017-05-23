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
    int score = 0;
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("Mass: " + score, 24, Color.black, Color.lightGray));
    }    
     
    public void addScore()
    {
        score++;
    }
}