import greenfoot.*;
import java.awt.Color;

/**
 * A cell is the circle of mass that the player controls around the world.
 * 
 * @author Wayde Gilliam, Brian Turner, Cecilia Martin, Ethan Hendricks
 */
public class miniCell extends ScrollActor {
    int size = 30;
    int speed = 7;
    int proteinMass = 10;
    int mass = 20;
    int virus = -60;
    int t = 0;
    int maxSpeed = speed;
    int keyCounter = 0;
    boolean split = false;
    public miniCell() {
        super();
        
        GreenfootImage cell = new GreenfootImage(size, size);
        cell.setColor(Color.BLUE);
        cell.fillOval(0, 0, size, size);
        setImage(cell);
    }
    
    public void act() {
        MouseInfo m = Greenfoot.getMouseInfo();
        
        GreenfootImage cell = new GreenfootImage(size, size);
        cell.setColor(Color.BLUE);
        cell.fillOval(0, 0, size, size);
        setImage(cell);
        
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
        
        if (m != null) {
            turnTowards(m.getX(), m.getY());
            getWorld().setCameraDirection(getRotation());
            getWorld().moveCamera(speed);
        }
        
        if (isTouching(Protein.class)) {
            removeTouching(Protein.class);
            addMass(1);
        }
        
        if(Greenfoot.isKeyDown("space")){
            divide();
        }
        
        if(isTouching(Virus.class) && (getMass() > 80)){
            removeTouching(Virus.class);
            split = true;
            divide();
        }
        
        if(Greenfoot.isKeyDown("enter")) {
            addMass(1);
        }
        
        
        if(Greenfoot.isKeyDown("w")) {
            if (mass >= 30) {
                if (keyCounter > 5) {
                    ((Agar)getWorld()).addObject(new Mass(cell.getColor(), getRotation(), getGlobalX(), getGlobalY()), getGlobalX(), getGlobalY());
                    removeMass(10);
                    keyCounter = 0;
                }
                else {
                    keyCounter++;
                }
            }
        }
        }
    
    public int getMass() {
        return mass;
    }
    
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
    
    public void removeMass(int num) {
        if(mass - num >= 20){
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
        
    }
    
    public void divide() {
        if(split == true){
            if(mass - 60 >= 20){
                removeMass(60);
            }else{
                mass = 20;
                size = 20;
                speed = 5;
            }
            for(int i = 0; i < 6; i++){    
                ((Agar)getWorld()).addObject(new miniCell(), getGlobalX(), getGlobalY());
            }
            split = false;
        }else{
            if(mass - 20 >= 20){
                removeMass(20);
                ((Agar)getWorld()).addObject(new miniCell(), getGlobalX(), getGlobalY());
            }
        }
        
    }
    
    public void counter() {
        Counter counter = ((Agar)getWorld()).theCounter;  // get a reference to the counter within the world
        counter.updateCount(mass, speed);
    }
    
    /*public String toString(){
        String output = "A cell has been created!";
        
        return output;
    }
    */
}
