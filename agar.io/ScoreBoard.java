import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;

/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class ScoreBoard extends Actor {
    public ScoreBoard() {
        setImage(new GreenfootImage("Scores: 20", 28, Color.BLACK, null));
    }
    
    /**
     * Increase the total amount displayed on the counter, by a given amount.
     */
    public void updateScore(String thisName, int thisMass, String otherName, int otherMass) {
        setImage(new GreenfootImage("Scores:\n" + thisName + "--" + thisMass + "\n" + otherName + "--" + otherMass, 28, Color.BLACK, null));
    }
    
    public void updateScore(String thisName, int thisMass) {
        setImage(new GreenfootImage("Scores:\n" + thisName + " -- " + thisMass, 28, Color.BLACK, null));
    }
}