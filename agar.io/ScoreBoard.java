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
    /**
     * Act - do whatever the ScoreBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static final String prefix = "Scores: ";
<<<<<<< HEAD
    //String players = agar.players();
    agar agarWorld = (agar)getWorld();
    List<Cell> playersList = agarWorld.getObjects(Cell.class);
    public Cell players(){
        //agar agarWorld = (agar)getWorld();
        //List<Cell> playersList = agarWorld.getObjects(Cell.class);
        Cell player = null;
        for(int i = 0; i < playersList.size(); i++){
            //player = playersList.get(i);
        }
        
        for (Object obj : agarWorld.getObjects(Cell.class)){
            player = (Cell) obj; // sub-casting
            // change location of 'ps'
        }
        
        return player;
    }
=======
    //String players = agar.players();    
>>>>>>> 64e03f7135bc8d9bc2bd888aba5f07b75544d23d

    public void act() 
    {
        //updateImage(players().getMass());
        
    }    
<<<<<<< HEAD

=======
    
>>>>>>> 64e03f7135bc8d9bc2bd888aba5f07b75544d23d
    public void updateImage(int massText){
        setImage(new GreenfootImage(prefix + " " + Integer.toString(massText), 18, Color.black, new Color(0, 0, 0, 0)));
    }
}
