import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * A NamePlate is the name tag that appears over the Cells and MultiplayerCells.
 * 
 * @author Wayde Gilliam, Brian Turner, Cecilia Martin, Ethan Harris
 */
public class NamePlate extends Actor
{
    String name; // the name of the Cell this NamePlate pertains to
    
    /**
     * Creates a new NamePlate with the given name.
     * 
     * @param name The name of the cell.
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