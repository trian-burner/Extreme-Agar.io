import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Mass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mass extends ScrollActor
{
    Color color;
    int rotation;
    int cellX;
    int cellY;
    boolean release = false;
    
    public Mass(Color color, int rotation, int cellX, int cellY) {
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
        
        boolean shot = false;
        if (m != null && shot == false) {           
            if (distance <= 25) {
                move(25);
            }
            else if ((distance <= 50) && (distance > 25)) {
                move(20);
            }
            else if ((distance <= 100) && (distance > 50)) {
                move(15);
            }
            else if ((distance <= 150) && (distance > 100)) {
                move(10);
            }
            else if ((distance <= 190) && (distance > 150)) {
                move(5);
            }
            else if ((distance <= 210) && (distance > 190)) {
                move(3);
            }
            else {
                move(0);
                shot = true;
            }
        }
        
    }    
}
