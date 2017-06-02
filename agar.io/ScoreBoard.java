import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;

/**
 * Creates images for a score board
 * 
 * @author Wayde Gilliam, Brian Turner, Cecilia Martin, Ethan Harris
 */

public class ScoreBoard extends Actor {
    /**
     * Scoreboard Zero Argument Constructor
     */
    public ScoreBoard() {
        setImage(new GreenfootImage("Scores: 20", 28, Color.BLACK, null));
    }
    
    /**
     * Increase the total amount displayed on the counter, by a given amount.
     * 
     * @param thisName Cell Name
     * @param thisMass Cell Mass
     * @param otherName Name of other Cell
     * @param otherMass Mass of other Cell
     */
    public void updateScore(String thisName, int thisMass, String otherName, int otherMass) {
        setImage(new GreenfootImage("Scores:\n" + thisMass + "\n" + otherName + "--" + otherMass, 28, Color.BLACK, null));
    }
    
    //This updateScore method is used for when they're is only one cell
    public void updateScore(String thisName, int thisMass) {
        setImage(new GreenfootImage("Scores:\n" + thisName + " -- " + thisMass, 28, Color.BLACK, null));
    }
}