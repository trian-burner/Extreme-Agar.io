import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import java.util.*;
/**
 * The Virus class is the smallest cell's savior, and the largest cell's excecutioner.  
 * It can hide small cells underneath itself, providing a hiding place that can be used as a getaway, or as a trap. 
 * When a player consumes a cell, it will split them into 7 smaller copies, allowing all the smaller cells to quickly consume the player.
 * This then provides a sheild for small cells, since large cells are unlikely to pursue them, and a sword the player can grow, as the virus launch will split at a certain mass
 * and will lauch its copy in a random direction.
 */
public class Virus extends ScrollActor{//start Virus.class;
    //Instantiate/Initialize variables

    private int proteinMass = 10;
    private int mass = 80;
    private int size = 80;
    private GreenfootImage virus;
    boolean duplicate;
    boolean spread = true;
    /**
     * Creates an image with an area corresponding with the size and mass of the virus.
     * Creates event triggers for various methods utilized by the Virus class.
     */
    public void act(){//start act().method;
        this.virus = new GreenfootImage(size, size);
        virus.setColor(Color.GREEN);
        virus.fillOval(0, 0, size, size);
        setImage(virus);
        if(spread == true){//start if.statement;
            addedToWorld();
        }//end if.statement;
        
        if (isTouching(MassBlob.class)) {//start if.statement;
            MassBlob blob = (MassBlob)getOneIntersectingObject(MassBlob.class);
            turnTowards(blob.getGlobalX() * -1, blob.getGlobalY() * -1);
            removeTouching(MassBlob.class);
            addMass();
        }//end if.statement;
        
        if(mass >= 120){//start if.statement;
            split();
        }//end if.statement;
        
        if(duplicate == true){//start if.statement;
            duplicate = false;
            ((Agar)getWorld()).addObject(new Virus(), getGlobalX() + (int)(Math.random() * 201 - 100), getGlobalY() + (int)(Math.random() * 201 - 100));
        }//end if.statement;
    }//end act().method;
    
    /**
     * Increases the mass and size of the virus. 
    */
    public void addMass(){//start addMass().method;
        mass += proteinMass;
        size += proteinMass;
    }//end addMass().method;
    
    /**
     * @return the mass of the Virus;
     */
    public int getMass(){//start getMass().method;
        return this.mass;
    }//end getMass().method;
    
    /**
     * Resets the mass of the virus
     * Duplicate set to true, causing the virus to create a copy of itself
     * at a random coordinate within 100 pixels of the parent cell. 
     */
    public void split(){//start split().method;
        this.mass = 80;
        this.size = 80;
        this.duplicate = true;
        move(1);
    }//end split().method;
    
    /**
     * If the newly created virus is touching another immediately after spawning,
     * it will move 50 pixels in the direction it is facing.
     */
    public void addedToWorld(){//start addedToWorld().method;
        spread = false;
        if(isTouching(Virus.class) == true){//start if.statement;   
            Virus body = (Virus)getOneIntersectingObject(Virus.class);
            setRotation(body.getRotation());
            move(50);    
        }//end if.statement;
    }//end addedToWorld().method;
}//end Virus.class;
