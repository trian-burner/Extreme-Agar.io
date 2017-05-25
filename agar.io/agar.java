import greenfoot.*;

public class Agar  extends ScrollWorld{
    private Counter theCounter; //mass counter
    
    public Agar() {
        //Creating a world size of 700x500 cells with 1x1 pixels
        super(900, 600, 1, 4900, 4600); // creates the new world and scroll world
        
        // returns a random int within the playable region of the world for the cell to spawn at
        int startX = (int)(Math.random() * (getFullWidth() - getWidth()) + (getWidth() / 2));
        int startY = (int)(Math.random() * (getFullHeight() - getHeight()) + (getHeight() / 2));
        
        // creates a new cell and sets the camera's position to be centered over the cell
        addCameraFollower(new Cell(), 0, 0);
        setCameraLocation(startX, startY);
        
        // a reference for the counter that the cell can use
        theCounter = new Counter();
        addObject(theCounter, getWidth()/2, getHeight()/2);
        
        // initially spawns the proteins and viruses into the world
        spawnProteins();
        spawnViruses();
    }
    
    public Counter getCounter() {
        return theCounter; // returns the counter for the cell
    }
    
    public void spawnPlayer() {
        // this will add a new player at this location
        addObject(new Cell(),(int)(Math.random() * (getFullWidth() - getWidth()) + (getWidth() / 2)), (int)(Math.random() * (getFullHeight() - getHeight()) + (getHeight() / 2)));
    }
    
    public void spawnProteins() {
        // spawns a given number of proteins into the world at random locations within the playable region of the field
        for (int i = 0; i < 1000; i++) {
            int x = (int)(Math.random() * (getFullWidth() - getWidth()) + (getWidth() / 2));
            int y = (int)(Math.random() * (getFullHeight() - getHeight()) + (getHeight() / 2));
            addObject(new Protein((int)(Math.random() * 5)), x, y);
        }
    }
    
    public void spawnViruses(){
        // spawns a given number of viruses into the world at random locations within the playable region of the field
        for(int i = 0; i < 50; i++){
            int x = (int)(Math.random() * (getFullWidth() - getWidth()) + (getWidth() / 2));
            int y = (int)(Math.random() * (getFullHeight() - getHeight()) + (getHeight() / 2));
            addObject(new Virus(), x, y);
        }
    }
}