import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;
/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Actor
{
    /**
     * Act - do whatever the ScoreBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static final String prefix = "Scores: ";
    //String players = agar.players();
    

    public void act() 
    {
        //Add your action code here.
        
    }    
    public void updateImage(int massText){
        setImage(new GreenfootImage(prefix + " " + Integer.toString(massText), 18, Color.black, new Color(0, 0, 0, 0)));
    }
}
