import greenfoot.*;

public class agar  extends ScrollWorld{
    public agar(){
        //Creating a world size of 700x500 cells with 1x1 pixels
        super(700, 500, 1, 4000, 4000);
        
        addCameraFollower(new Cell(), 0, 0);
        
        spawnProteins();
    }
    
    public void spawnPlayer(){
        addObject(new Cell(), 0, 0);
    }
    
    public void spawnProteins() {
        //World world = getWorld();
        for (int i = 0; i < 500; i++) {
            int x = (int)(Math.random() * getFullWidth());
            int y = (int)(Math.random() * getFullHeight());
            addObject(new protein(), x, y);
        }
    }
}
