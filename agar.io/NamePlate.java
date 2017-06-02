import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
<<<<<<< HEAD
 * A NamePlate is the name tag that appears over the Cells and MultiplayerCells.
=======
 * Displays cell name on the cell
>>>>>>> 2fb4a8964599b4263ab0c4a65aaf64bd7b825fb9
 * 
 * @author Wayde Gilliam, Brian Turner, Cecilia Martin, Ethan Harris
 */
public class NamePlate extends Actor
{
    String name; // the name of the Cell this NamePlate pertains to
    
<<<<<<< HEAD
    
    /**
     * Creates a new NamePlate with the given name.
     * 
     * @param name The name of the cell.
=======
    /**
     * Constructor for NamePlate
     * 
     * @param name Cell name
>>>>>>> 2fb4a8964599b4263ab0c4a65aaf64bd7b825fb9
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