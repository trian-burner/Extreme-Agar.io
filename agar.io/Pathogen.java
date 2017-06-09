import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import java.util.*;
public class Pathogen extends ScrollActor
{
    int mass = 20;
    int size = 30;
    int speed = 7;
    GreenfootImage path;
    public Pathogen(){
        super();
    }
    
    public void act() 
    {
        this.path = new GreenfootImage(size, size);
        path.setColor(Color.MAGENTA);
        path.fillOval(0, 0, size, size);
        setImage(path);
        consume();
        move(5);
        //Protein Collision Detection
        if(isTouching(Protein.class)) { 
            hitProtein();
        }
        
        //miniCell Collision Detection
        miniCell mini = (miniCell)getOneIntersectingObject(miniCell.class);
        if(isTouching(miniCell.class)){
            if(getMass() > (mini.getMass())){
                addMass(mini.getMass());
                removeTouching(miniCell.class);
            }
        }
        
        //MassBlob Collision Detection
        if(isTouching(MassBlob.class)) {
            removeTouching(MassBlob.class);
            addMass(10); 
        }
        
        //Cell Collision Detection
        Cell cell = (Cell)getOneIntersectingObject(Cell.class);
        if(isTouching(Cell.class)){
            if(getMass() > cell.getMass()){
                addMass(cell.getMass());
                cell.death();
            }
        }
        
        //Virus Collision Detection
        if(isTouching(Virus.class) && (getMass() >= 40)) {
            hitVirus();
        }
    }    
    
    
    /**
     * Returns the mass of the Cell
     */
    public int getMass() {
        return mass;
    }
    
    public void addMass(int num) {
        for (int i = 0; i < num; i++) {
            size += 1;
            mass += 1;
            //Decrementing speed as mass increments
        }
    }
    
     public void removeMass(int num) {
        for (int i = 0; i < num; i++) {
            size -= 1;
            mass -= 1;
            //Decrementing speed as mass increments
        }
    }
    
    public void infect(){
        if(mass >= 40){
            ((Agar)getWorld()).addObject(new Pathogen(), getGlobalX(), getGlobalY());
            mass = 20;
            size = 30;
        }
    }
    
    public void consume(){
        for(int i = 0; i < 300; i++){
            java.util.List<Cell>first = getObjectsInRange(i, Cell.class);
            java.util.List<miniCell>second = getObjectsInRange(i, miniCell.class);
            java.util.List<MassBlob>third = getObjectsInRange(i, MassBlob.class);
            java.util.List<Protein>fourth = getObjectsInRange(i, Protein.class);
            if(first.size() > 0 && getMass() > first.get(0).getMass()){
                turnTowards(first.get(0).getX(),first.get(0).getY());
            }else if(second.size() > 0){
                turnTowards(second.get(0).getX(), second.get(0).getY());
            }else if(third.size() > 0){
                turnTowards(third.get(0).getX(), third.get(0).getY());
            }else if(fourth.size() > 0){
                turnTowards(fourth.get(0).getX(), fourth.get(0).getY());
            }
        }
        
    }
    
    public void divide(){             
        for(int i = 0; i < 5; i++){
            ((Agar)getWorld()).addObject(new Pathogen(), getGlobalX(), getGlobalY());
        }
        mass = 20;
        size = 30;    
    }
    
    /**
     * Removes any Protein that the Cell is touching, add mass to the Cell, and spawn a new protein in a random location in the World
     */
    public void hitProtein() {
        removeTouching(Protein.class);
        addMass(1);
        ((Agar)getWorld()).spawnProteins(1);
    }
    
    /**
     * Removes any Virus that the Cell is touching, and remove mass
     */
    public void hitVirus() {
        removeTouching(Virus.class);
        divide();
    }
           
}
