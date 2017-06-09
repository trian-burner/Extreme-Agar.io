import greenfoot.*;
import java.awt.Color; // importing color for setting the color of the Cell

public class MultiplayerCell extends ScrollActor {
    //Variables
    String name;
    int size = 1;
    int mass;
    int speed;
    
    Color color;
    GreenfootImage cell = new GreenfootImage(size, size);
 
    public MultiplayerCell() {
        super();
        
        name = null;
        size = 1;
        mass = 1;
        color = Color.white;
    }
    
    public void update(CellPackage p) {
        name = p.name;
        size = p.size;
        mass = p.mass;
        color = p.color;
        setGlobalLocation(p.x, p.y);
    }
    
    public void act() {        
        cell = new GreenfootImage(size, size);
        cell.setColor(color);
        cell.fillOval(0, 0, size, size);
        setImage(cell);
        
        if (isTouching(Protein.class)) { 
            hitProtein();
        }
        
        if(isTouching(Virus.class) && (getMass() >= 60)) {
            hitVirus();
        }
        
        MassBlob massBlob = (MassBlob)getOneIntersectingObject(MassBlob.class);
        if(massBlob != null){ 
            hitMassBlob(massBlob);
        }
    }
    
    public int getMass() {
        return mass;
    }
    
    public void hitProtein() {
        removeTouching(Protein.class);
        //((Agar)getWorld()).spawnProteins(1);
    }
    
    /**
     *Consumes a cell with a mass smaller than its own. 
     */
    public void cellDevourer(){
        Cell pcell = (Cell)getOneIntersectingObject(Cell.class);
       if(getMass() < pcell.getMass()){
            death();
        }
    }
    
    public void hitVirus() {
        removeTouching(Virus.class);
    }
    
    public void hitMassBlob(MassBlob massBlob) {
        if (massBlob.shot == true) {
            removeTouching(MassBlob.class);
        }
    }
    
    public void death() {
        getWorld().addObject(new FadeOut((Agar)getWorld()), 450, 300);
        getWorld().removeObject(this);
    }
}