import greenfoot.*;
//import java.util.*;
/**
 * Write a description of class Cell here.
 * 
 * @author (Wayde Gilliam) 
 * @version (0.0.1)
 */
public class Cell extends ScrollActor
{
    int speed = 6;
    int proteinMass = 10;
    int mass = 50;
    public void act(){
        MouseInfo m = Greenfoot.getMouseInfo();
        
        if (m != null) {
            turnTowards(m.getX(), m.getY());
            getWorld().setCameraDirection(getRotation());
            getWorld().moveCamera(speed);
        }
        
        if (isTouching(protein.class)) {
            removeTouching(protein.class);
            addMass();
        }
    }
    
    public void addMass(){
        GreenfootImage cellSkin = getImage();
        cellSkin.scale(cellSkin.getWidth() + proteinMass, cellSkin.getHeight() + proteinMass);
        setImage(cellSkin);
        mass += 10;
    }
    
    
    
    /*
    public void removeMass(){
    }
    
    public void divide(){
    }
    
    public void counter(){
    }
    
    public String toString(){
        String output = "A cell has been created!";
        
        return output;
    }
    */
   
   
}
