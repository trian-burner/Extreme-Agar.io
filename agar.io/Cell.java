import greenfoot.*;
import java.awt.Color;
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
    int size = 35;
    public void act(){
        MouseInfo m = Greenfoot.getMouseInfo();
        
        GreenfootImage cell = new GreenfootImage(size, size);
        cell.setColor(Color.RED);
        cell.fillOval(0, 0, size, size);
        setImage(cell);

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
        size += 5;
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
