import greenfoot.*;

public class agar  extends ScrollWorld{
    private Counter theCounter; //mass counter
    
    
    public agar() {
        //Creating a world size of 700x500 cells with 1x1 pixels
        super(900, 600, 1, 4900, 4600);
        
        int startX = (int)(Math.random() * (getFullWidth() - getWidth()) + (getWidth() / 2));
        int startY = (int)(Math.random() * (getFullHeight() - getHeight()) + (getHeight() / 2));
        
        addCameraFollower(new Cell(), 0, 0);
        setCameraLocation(startX, startY);
        
        theCounter = new Counter();
        addObject(theCounter, 450, 300);
        
        spawnProteins();
        spawnViruses();
    }
    
    public Counter getCounter() {
        return theCounter;
    }
    
    public void spawnPlayer() {
        addObject(new Cell(),(int)(Math.random() * (getFullWidth() - getWidth()) + (getWidth() / 2)), (int)(Math.random() * (getFullHeight() - getHeight()) + (getHeight() / 2)));
    }
    
    public void spawnProteins() {
        //World world = getWorld();
        for (int i = 0; i < 1000; i++) {
            int x = (int)(Math.random() * (getFullWidth() - getWidth()) + (getWidth() / 2));
            int y = (int)(Math.random() * (getFullHeight() - getHeight()) + (getHeight() / 2));
            addObject(new protein((int)(Math.random() * 5)), x, y);
        }
    }
    
    public void spawnViruses(){
        for(int i = 0; i < 50; i++){
            int x = (int)(Math.random() * (getFullWidth() - getWidth()) + (getWidth() / 2));
            int y = (int)(Math.random() * (getFullHeight() - getHeight()) + (getHeight() / 2));
            addObject(new virus(), x, y);
        }
    }
    
    public void spawnMass(int x, int y) {
        addObject(new Mass(), x, y);
    }
}
