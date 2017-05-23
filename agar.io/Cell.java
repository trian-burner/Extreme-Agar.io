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
    int speed = 5;
    int proteinMass = 10;
    int mass = 20;
    int size = 20;
    int virus = -60;
    int t = 0;
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
        
        if(isTouching(virus.class)){
           if(getMass() > 40){
               removeTouching(virus.class);
               divide();
           }
        }
    }
    
    public void addMass(){
        size += 1;
        mass += 1;
        
        agar gameWorld = (agar) getWorld();  // get a reference to the world
       Counter counter = gameWorld.getCounter();  // get a reference to the counter
       counter.bumpCount(5);
        //Decrementing speed as mass increments
        if(mass+1 % 25 == 0){
            speed--;
        }
    }
    public int getMass(){
        return this.mass;
    }
    
    
    
    //public void removeMass(){}
 
    
    public void divide(){
        this.mass -= 60;
        this.size -= 60;
        if(mass+1 % 25 == 0){
            speed ++;
        }
        if(this.mass <= 0){
            this.size = 20;
            this.mass = 20;
            this.speed = 5;
        }
    }
    /*
    public void counter(){
    }
    
    public String toString(){
        String output = "A cell has been created!";
        
        return output;
    }
    */
   
   
}
