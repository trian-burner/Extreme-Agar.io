import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Mass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MassBlob extends ScrollActor
{
    Color color;
    int rotation;
    int cellX;
    int cellY;
    boolean release = false;
    boolean shot;
    int vsd = 30; // [Variable Shot Distance]
    
    public MassBlob(Color color, int rotation, int cellX, int cellY) {
        this.color = color;
        this.cellX = cellX;
        this.cellY = cellY;
        
        GreenfootImage mass = new GreenfootImage(25, 25);
        mass.setColor(color);
        mass.fillOval(0, 0, 25, 25);
        setImage(mass);
        
        setRotation(rotation);
    }
    
    /**
     * Act - do whatever the Mas wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        GreenfootImage mass = new GreenfootImage(25, 25);
        mass.setColor(color);
        mass.fillOval(0, 0, 25, 25);
        setImage(mass);
        
        if (release == false) {
            move(1);
            release = true;
        }
        
        MouseInfo m = Greenfoot.getMouseInfo();
        int distance = (int)Math.pow((Math.pow((cellX - getGlobalX()), 2) + Math.pow((cellY - getGlobalY()), 2)), .5);
        
        //Actor cell = getTouching(Cell.class);
        
        shot = false;
        
        if(shot == true && isTouching(Cell.class) == true){
            System.out.print("YAY");
            getWorld().removeObject(this);
        }
        

        if (m != null && shot == false) {           
            if (distance <= vsd) {
                move(25);
            }
            else if ((distance <= 2*vsd) && (distance > vsd)) {
                move(20);
            }
            else if ((distance <= 4*vsd) && (distance > 2*vsd)) {
                move(15);
            }
            else if ((distance <= 6*vsd) && (distance > 4*vsd)) {
                move(10);
            }
            else if ((distance <= 6*vsd+40) && (distance > 6*vsd)) {
                move(5);
            }
            else if ((distance <= 8*vsd+10) && (distance > 6*vsd+40)) {
                move(3);
            }
            else {
                move(0);
                shot = true;
            }
        }
    }    
    
    public boolean shotStatus(){
        return shot;
    }
}
