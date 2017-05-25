import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

public class virus extends ScrollActor {
    private int proteinMass = 10;
    private int mass = 40;
    private int size = 40;
    
    public void act() {
        GreenfootImage virus = new GreenfootImage(size, size);
        virus.setColor(Color.GREEN);
        virus.fillOval(0, 0, size, size);
        setImage(virus);
        
        if (isTouching(protein.class)) {
            removeTouching(protein.class);
            addMass();
        }
        
        if(mass >= 80){
            split();
        }
    }
    
    public void addMass(){
        GreenfootImage virusA = getImage();
        virusA.scale(virusA.getWidth() + proteinMass/4, virusA.getHeight() + proteinMass/4);
        mass += proteinMass;
    }
    
    public int getMass(){
        return this.mass;
    }
    
    public void split(){
        this.mass = 40;
        this.size = 40;
        getWorld().addObject(new virus(), getX() + 5, getY() + 5);
    }
}
