import greenfoot.*;

/**
 * Write a description of class Cell here.
 * 
 * @author (Wayde Gilliam) 
 * @version (0.0.1)
 */
public class Cell extends ScrollActor
{
    int speed = 6;
    int size = 1;
    public void act(){
        MouseInfo m = Greenfoot.getMouseInfo();
        
        if (m != null) {
            turnTowards(m.getX(), m.getY());
            getWorld().setCameraDirection(getRotation());
            getWorld().moveCamera(speed);
        }
        GreenfootImage cellSkin = getImage();
        cellSkin.scale(cellSkin.getWidth() + size, cellSkin.getHeight() + size);
        setImage(cellSkin);

    }
    
    /*
    public void addMass(){
    }
    
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
