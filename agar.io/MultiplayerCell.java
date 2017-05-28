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
    }
    
    public int getMass() {
        return mass;
    }
    
//     public void divide() {
//         if (mass/2 > 20) {
//             if (keyCounter > 10) {
//                 ((Agar)getWorld()).addObject(new Cell(cell.getColor(), getRotation(), size/2, mass/2), getGlobalX(), getGlobalY());
//                 removeMass(mass/2);
//                 keyCounter = 0;
//             }
//             else {
//                 keyCounter++;
//             }
//         }
//     }
//     public void counter() {
//         Counter counter = ((Agar)getWorld()).getCounter();  // get a reference to the counter within the world
//         counter.updateCount(mass, speed);
//     }
//     public void death() {
//         getWorld().addObject(new FadeOut(name), 450, 300);
//         getWorld().removeObject(this);
//     }
//     public void ejectMass() {
//         if (mass > 30) {
//             if (keyCounter > 5) {
//                 ((Agar)getWorld()).addObject(new MassBlob(cell.getColor(), getRotation(), getGlobalX(), getGlobalY()), getGlobalX(), getGlobalY());
//                 removeMass(10);
//                 keyCounter = 0;
//             }
//             else {
//                 keyCounter++;
//             }
//         }
//     }
}