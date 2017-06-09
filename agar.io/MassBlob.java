import greenfoot.*;
import java.awt.Color;

/**
 * The class responsible for the mass ejected from the cell. Other cells can pick up mass blobs to gain
 * additional mass.
 * 
 * @author Wayde Gilliam, Brian Turner, Cecilia Martin, Ethan Harris
 */
public class MassBlob extends ScrollActor
{   
    // variables
    Color color;    // the cell's color
    int rotation;   // orientation of the cell
    int cellX;  // cell X position
    int cellY;  // cell Y position
    boolean release = false;    // not been released/been released
    boolean shot;   // has it shot/not been shot
    int vsd; // [Variable Shot Distance]
    
    /**
     * Creates a massblob at the cell's position
     * 
     * @param color The Color of the cell
     * @param rotation Orientation of the cell
     * @param cellX Cell X position
     * @param cellY Cell Y position
     * @param vsd Variable Shot Distance
     */
    public MassBlob(Color color, int rotation, int cellX, int cellY, int vsd) {
        this.color = color;
        this.cellX = cellX;
        this.cellY = cellY;
        this.vsd = vsd;
        
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
        //Setting the image for the mass blob
        GreenfootImage mass = new GreenfootImage(25, 25);
        mass.setColor(color);
        mass.fillOval(0, 0, 25, 25);
        setImage(mass);
        
        //Checking mass blob release status
        if (release == false) {
            move(1);
            release = true;
        }
        
        //Getting mouse position
        MouseInfo m = Greenfoot.getMouseInfo();
        int distance = (int)Math.pow((Math.pow((cellX - getGlobalX()), 2) + Math.pow((cellY - getGlobalY()), 2)), .5);
        shot = false;
        
        //Removes mass blob if a cell touches it
        if(shot == true && isTouching(Cell.class) == true){
            System.out.print("YAY");
            getWorld().removeObject(this);
        }
        
        //Slowing down the mass blob as its distance increases
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
}
