import greenfoot.*;

public class agar  extends ScrollWorld{
    //Mass Counter
    private Counter theCounter;
    
    public agar(){
        //Creating a world size of 700x500 cells with 1x1 pixels
        super(900, 600, 1, 4900, 4600);
        
        addCameraFollower(new Cell(), 0, 0);
        theCounter = new Counter();
        addObject(theCounter, 25, 50);
        
        spawnProteins();
        spawnViruses();
        
    }
    
    public Counter getCounter()
    {
        return theCounter;
    }
    
    public void spawnPlayer(){
        addObject(new Cell(), 0, 0);
    }
    
    public void spawnProteins() {
        //World world = getWorld();
        for (int i = 0; i < 1000; i++) {
            int x = (int)(Math.random() * (getFullWidth() - getWidth()) + (getWidth() / 2));
            int y = (int)(Math.random() * (getFullHeight() - getHeight()) + (getHeight() / 2));
            addObject(new protein((int)(Math.random() * 3)), x, y);
        }
    }
    public void spawnViruses(){
        for(int i = 0; i < 50; i++){
            int x = (int)(Math.random() * (getFullWidth() - getWidth()) + (getWidth() / 2));
            int y = (int)(Math.random() * (getFullHeight() - getHeight()) + (getHeight() / 2));
            addObject(new virus(), x, y);
        }
    }

}
