import greenfoot.*;
import java.awt.Color;

/**
 * A cell is the circle of mass that the player controls around the world.
 * 
 * @author Wayde Gilliam, Brian Turner, Cecilia Martin, Ethan Hendricks
 */
public class Cell extends ScrollActor {
    int speed = 7;
    int proteinMass = 10;
    int mass = 0;
    int size = 30;
    int virus = -60;
    int t = 0;
    int maxSpeed = speed;
    int keyCounter = 0;
    
    public void act() {
        MouseInfo m = Greenfoot.getMouseInfo();
        
        GreenfootImage cell = new GreenfootImage(size, size);
        cell.setColor(Color.RED);
        cell.fillOval(0, 0, size, size);
        setImage(cell);

        if (m != null) {
            int mouseDistance = (int)Math.pow((Math.pow((m.getX() - 450), 2) + Math.pow((m.getY() - 300), 2)), .5);
           
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
        
        if (isTouching(protein.class)) {
            removeTouching(protein.class);
            addMass(1);
        }
        
        if(isTouching(virus.class) && (getMass() > 40)){
            removeTouching(virus.class);
            divide();
        }
        
        if(Greenfoot.isKeyDown("enter")) {
            addMass(1);
        }
        
        if(Greenfoot.isKeyDown("w")) {
            if (keyCounter > 5) {
                ((agar)getWorld()).spawnMass(getGlobalX(), getGlobalY());
                keyCounter = 0;
            }
            else {
                keyCounter++;
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
    
    public void divide() {
        removeMass(60);
        
        if(this.mass <= 0){
            this.size = 20;
            this.mass = 20;
            this.speed = 5;
        }
    }
    
    public void counter() {
        Counter counter = ((agar)getWorld()).getCounter();  // get a reference to the counter within the world
        counter.bumpCount(mass, speed);
    }
    
    /*public String toString(){
        String output = "A cell has been created!";
        
        return output;
    }
    */
   
   
}
