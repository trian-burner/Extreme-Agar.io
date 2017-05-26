import greenfoot.*;
import java.awt.Color; // importing color for setting the color of the Cell

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
    int maxSpeed = speed;   //Max Speed for cell (used for setting variable speed)
    int keyCounter = 0; //Wait time for another mass ejection
    int vsd = 20; // [Variable Speed Distance] the distance from the Cell in which the speed changes
    boolean spawn = false;
    
    // constructor
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
            // calculates the distance between the mouse and the cell
            int mouseDistance = (int)Math.pow((Math.pow((m.getX() - ((Agar)getWorld()).getWidth()/2), 2) + Math.pow((m.getY() - ((Agar)getWorld()).getHeight()/2), 2)), .5);
           
            // changes the speed of the Cell based on how close the mouse is to it
            if (mouseDistance <= vsd) {
                speed = 0;
            }
            else if ((mouseDistance <= vsd + 15) && (mouseDistance > vsd)) {
                speed = 1;
            }
            else if ((mouseDistance <= vsd + 30) && (mouseDistance > vsd + 15)) {
                if (maxSpeed >= 2) {
                   speed = 2; 
                }
            }
            else if ((mouseDistance <= vsd + 45) && (mouseDistance > vsd + 30)) {
                if (maxSpeed >= 2) {
                   speed = 3; 
                }
            }
            else if ((mouseDistance <= vsd + 60) && (mouseDistance > vsd + 45)) {
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
        MassBlob massBlob = (MassBlob)getOneIntersectingObject(MassBlob.class);
        if(massBlob != null){
            if (massBlob.shot == true) {
                removeTouching(MassBlob.class);
                addMass(10); 
            }
        }
        
        //Virus Collision Detection
        if(isTouching(Virus.class) && (getMass() > 40)){
            removeTouching(Virus.class);
            divide();
        }
        
        //Ejecting Mass From Cell
        if(Greenfoot.isKeyDown("w")) {
            if (mass > 30) {
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
        
        //Debug Testing
        if(Greenfoot.isKeyDown("enter")) {
            addMass(1);
        }
        
        // death tester
        if (spawn == false) {
            getWorld().addObject(new DeathTester(), getGlobalX(), getGlobalY() + 200);
        }
        
        spawn = true;
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
        if (mass > 60) {
            removeMass(40);
        }
        else {
            for (int i = 0; i < 40; i++) {
                if (mass > 20) {
                    removeMass(1);
                }
            }
        }
    }
    
    //Adding Score to Mass Counter
    public void counter() {
        Counter counter = ((Agar)getWorld()).getCounter();  // get a reference to the counter within the world
        counter.bumpCount(mass, speed);
    }
    
    public void death() {
        GameOver die = new GameOver();
        Greenfoot.setWorld(die);
    }
}
