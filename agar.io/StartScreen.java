import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{
    String[] screens = {"startScreen.png", "startScreenServer.png", "startScreenClient.png"};
    int screenNum = 0;
    
    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen() {
        super(900, 600, 1);
        addObject(new nameBox(), getWidth()/2, 350);
    }
    
    public StartScreen(String name) {
        super(900, 600, 1);
        addObject(new nameBox(name), getWidth()/2, 350);
    }
    
    public void act() {
        MouseInfo m = Greenfoot.getMouseInfo();
        
        boolean inRange = false;
        
        if (m != null) {
            inRange = ((m.getX() < 640) && (m.getX() > 440)) && ((m.getY() < 268) && (m.getY() > 232));
        }
        
        if (Greenfoot.mouseClicked(this) && inRange == true) {
            if (screenNum == 2) {
                screenNum = 0;
                setBackground(screens[screenNum]);
            }
            else {
                screenNum++;
                setBackground(screens[screenNum]);
            }
        }
    }
}
