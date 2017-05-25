import greenfoot.*;
import java.awt.Color;

/**
 * A cell is the circle of mass that the player controls around the world.
 * 
 * @author Wayde Gilliam, Brian Turner, Cecilia Martin, Ethan Hendricks
 */
public class Cell extends ScrollActor {
    //Variables
    int size = 30;  //Value for image scaling
    int speed = 7;  //Cell travel speed
    int mass = 20;  //Representative value for cell size
    int virus = -60;    //Mass-loss value for viruses  
    int maxSpeed = speed;   //Max Speed for cell
    int keyCounter = 0; //Time amount for mass ejection
    
    public Cell() {
        super();
        
        //Setting Cell Image Before Initializing world
        GreenfootImage cell = new GreenfootImage(size, size);   
        cell.setColor(Color.BLUE);
        cell.fillOval(0, 0, size, size);
        setImage(cell);
    }
    
    public void act() {
        //Variable for mouse position
        MouseInfo m = Greenfoot.getMouseInfo();
        
        //Setting Cell Image After Initializing
        GreenfootImage cell = new GreenfootImage(size, size);
        cell.setColor(Color.BLUE);
        cell.fillOval(0, 0, size, size);
        setImage(cell);
        
        //Slowing Cell Speed With Mouse
        if (m != null) {
            int mouseDistance = (int)Math.pow((Math.pow((m.getX() - ((Agar)getWorld()).getWidth()/2), 2) + Math.pow((m.getY() - ((Agar)getWorld()).getHeight()/2), 2)), .5);
           
            if (mouseDistance <= 20) {
                speed = 0;
            }
            else if ((mouseDistance <= 20 + 15) && (mouseDistance > 20)) {
                speed = 1;
            }
            else if ((mouseDistance <= 20 + 30) && (mouseDistance > 20 + 15)) {
                if (maxSpeed >= 2) {
                   speed = 2; 
                }
            }
            else if ((mouseDistance <= 20 + 45) && (mouseDistance > 20 + 30)) {
                if (maxSpeed >= 2) {
                   speed = 3; 
                }
            }
            else if ((mouseDistance <= 20 + 60) && (mouseDistance > 20 + 45)) {
                if (maxSpeed >= 2) {
                   speed = 4; 
                }
            }
            else {
                speed = maxSpeed;
            }
        }
        
        //Getting Mouse location for direction
        if (m != null) {
            turnTowards(m.getX(), m.getY());
            getWorld().setCameraDirection(getRotation());
            getWorld().moveCamera(speed);
        }
        
        //Protein Collision Detection
        if (isTouching(Protein.class)) {
            removeTouching(Protein.class);
            addMass(1);
        }
        
        
        
        //MassBlob Collision Detection
        if(isTouching(MassBlob.class)){
            
            
            removeTouching(MassBlob.class);
            addMass(10);
            
      
        }
        
        
        //Virus Collision Detection
        if(isTouching(Virus.class) && (getMass() > 40)){
            removeTouching(Virus.class);
            divide();
        }
        
        //Debug Testing
        if(Greenfoot.isKeyDown("enter")) {
            addMass(1);
        }
        
        //Ejecting Mass From Cell
        if(Greenfoot.isKeyDown("w")) {
            if (mass > 20) {
                if (keyCounter > 5) {
                    ((Agar)getWorld()).addObject(new MassBlob(cell.getColor(), getRotation(), getGlobalX(), getGlobalY()), getGlobalX(), getGlobalY());
                    removeMass(10);
                    keyCounter = 0;
                }
                else {
                    keyCounter++;
                }
            }
        }
        }
    
    //Gets Mass for Cell
    public int getMass() {
        return mass;
    }
    
    //Adding Mass to Cell
    public void addMass(int num) {
        for (int i = 0; i < num; i++) {
            size += 1;
            mass += 1;
            //Decrementing speed as mass increments
            if(mass % 40 == 0 && speed > 1){
                maxSpeed--;
            }
        }
        counter();
    }
    
    //Removing Mass and Scaling Speed
    public void removeMass(int num) {
        for (int i = 0; i < num; i++) {
            size -= 1;
            mass -= 1;
            //Decrementing speed as mass increments
            if(mass % 40 == 0 && speed < 7){
                maxSpeed++;
            }
        }
        counter();
    }
    
    //Cell Divison
    public void divide() {
        removeMass(60);
        
        if(mass <= 0){
            size = 20;
            mass = 20;
            speed = 5;
        }
    }
    
    //Adding Score to Mass Counter
    public void counter() {
        Counter counter = ((Agar)getWorld()).getCounter();  // get a reference to the counter within the world
        counter.bumpCount(mass, speed);
    }
    
    /*public String toString(){
        String output = "A cell has been created!";
        
        return output;
    }
    */
}
