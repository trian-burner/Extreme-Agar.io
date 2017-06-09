import greenfoot.*;
import java.awt.Color;
import java.util.*;
/**
 * A cell is the circle of mass that the player controls around the world.
 * 
 * @author Wayde Gilliam, Brian Turner, Cecilia Martin, Ethan Hendricks
 */
public class miniCell extends ScrollActor {
    int size = 30;
    int speed = 5;
    int proteinMass = 10;
    int mass = 20;
    int virus = -60;
    int t = 0;
    int maxSpeed = speed;
    int keyCounter = 0;
    boolean split = false;
    String name;
    boolean added;
    Color color = Color.WHITE;
    public miniCell(int nmass, int nsize, Color ncolor, String nname) {
        super();
        name = name;
        mass = nmass;
        color = ncolor;
        name = nname;
    }
    
    public void update(CellPackage p) {
        if(followCell() == true){
            name = p.name;
            size = p.size;
            mass = p.mass;
            color = p.color;
            setGlobalLocation((p.x) * -10, (p.y) * -10);
        }       
    }
    
    public void act() {
        GreenfootImage cell = new GreenfootImage(size, size);
        cell.setColor(color);
        cell.fillOval(0, 0, size, size);
        setImage(cell);
        followCell(); 
              
        
        
        if (isTouching(Protein.class)) {
            removeTouching(Protein.class);
            addMass(1);
        }
        
        miniCell mini = (miniCell)getOneIntersectingObject(miniCell.class);
        if(isTouching(miniCell.class)){
            if(getMass() > 5 + mini.getMass()){
                addMass(mini.getMass());
                removeTouching(miniCell.class);
            }
        }
                      
        if(Greenfoot.isKeyDown("space")){
            divide();
        }
        
        if(isTouching(Virus.class) && (getMass() > 80)){
            removeTouching(Virus.class);
            split = true;
            divide();
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
    
    /*
     public void addedToWorld(){
        MouseInfo m = Greenfoot.getMouseInfo();
        boolean shot;
        for (int i=1; i < 500; i+=10){
            List<Cell> player = getObjectsInRange(i, Cell.class);
            if (player.size()>0){
                turnTowards(player.get(0).getX(),player.get(0).getY());
                move(5);
                int distance = (int)Math.pow((Math.pow((player.get(0).getX() - getGlobalX()), 2) + Math.pow((player.get(0).getY() - getGlobalY()), 2)), .5);
                shot = false;
                if (m != null && shot == false) {           
                    if (distance <= 70) {
                        move(25);
                    }
                    else if ((distance <= 2*70) && (distance > 70)) {
                        move(20);
                    }
                    else if ((distance <= 4*70) && (distance > 2*70)) {
                        move(15);
                    }
                    else if ((distance <= 6*70) && (distance > 4*70)) {
                        move(10);
                    }
                    else if ((distance <= 6*70+40) && (distance > 6*70)) {
                        move(5);
                    }
                    else if ((distance <= 8*70+10) && (distance > 6*70+40)) {
                        move(3);
                    }
                    else {
                        move(0);
                        shot = true;
                    }
                }
            }
        }
       
    }*/
    
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
            split = false;
             if(mass/6 >= 20){
                for(int i = 0; i < 5; i++){
                    ((Agar)getWorld()).addObject(new miniCell(mass/6, mass/6 + 10, this.color, this.name), getGlobalX(), getGlobalY());
                }
                removeMass(5 *(getMass()/6));
            }else{
                mass = 20;
                size = 30;
                speed = 5;
            }
        }else{
            if(mass/2 >= 20){
                removeMass(getMass()/2);
                speed = 3;
                ((Agar)getWorld()).addObject(new miniCell(mass/2, size/2 + 10, this.color, this.name), getGlobalX(), getGlobalY());
            }
        }
    }
    
    public boolean followCell(){
        for (int i=1; i < 500; i+=10){
            List<Cell> player = getObjectsInRange(i, Cell.class);
            if (player.size()>0){
                turnTowards(player.get(0).getX(),player.get(0).getY());
                move(5);
                return true;
            }
        }
        
        return false;
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
