import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The protein blobs that appear randomly throughout the game.
 * Cells can eat proteins to gain mass.
 * 
 * @author Wayde Gilliam, Brian Turner, Cecilia Martin, Ethan Harris 
 */
public class Protein extends ScrollActor
{
    String[] colors = {"blueProtein.png", "redProtein.png", "orangeProtein.png", "pinkProtein.png", "greenProtein.png"};
    String color;
    
    /**
     * Act - do whatever the protein wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor cell;
        cell = getOneIntersectingObject(Cell.class);
    }
    
    /**
     * Constructor for the Protein class
     * 
     * @param num The color of the protein
     */
    public Protein(int num) {
        super();
        color = colors[num];
        setImage(color);
    }
}
