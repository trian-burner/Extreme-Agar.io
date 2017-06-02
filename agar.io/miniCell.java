import greenfoot.*;
import java.awt.Color;

/**
 * A cell is the circle of mass that the player controls around the world.
 * 
 * @author Wayde Gilliam, Brian Turner, Cecilia Martin, Ethan Hendricks
 */
public class miniCell extends ScrollActor {
    Cell body = (Cell)getOneIntersectingObject(Cell.class);
    int size = 30;
    int speed = 5;
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
        
        
        GreenfootImage cell = new GreenfootImage(size, size);
        cell.setColor(Color.BLUE);
        cell.fillOval(0, 0, size, size);
        setImage(cell);
        
        if(body != null){
           turnTowards(body.getGlobalX(), body.getGlobalY());
           move(1);
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
