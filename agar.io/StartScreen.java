import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * The start up scren for the game. Contains input for name, and how you are playing the game (solo, server, client)
 * 
 * @author Wayde Gilliam, Brian Turner, Cecilia Martin, Ethan Harris
 */
public class StartScreen extends World
{
    String[] screens = {"startScreen.png", "startScreenServer.png", "startScreenClient.png"};   //Array for the different screens
    int screenNum = 0;  //Index for the screens array

    /**
     * Constructor for objects of class StartScreen.
     */
    public StartScreen() {
        super(900, 600, 1);
        addObject(new nameBox(), getWidth()/2, 350);
    }

    /**
     * Constructor for objects of class StartScreen with name input
     * 
     * @param name Cell name
     */
    public StartScreen(String name) {
        super(900, 600, 1);
        addObject(new FadeIn(Color.white), 450, 300);
        addObject(new nameBox(name), getWidth()/2, 350);
    }

    /**
     * Actor class for StartScreen
     */
    public void act() {
        //Variables
        MouseInfo m = Greenfoot.getMouseInfo(); //Gets mouse info
        boolean inRange = false;    //Mouse range on screen 

        //Sets mouse position
        if (m != null) {
            inRange = ((m.getX() < 640) && (m.getX() > 440)) && ((m.getY() < 268) && (m.getY() > 232));
        }

        //Changes screens based on mouse clicks and position
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
