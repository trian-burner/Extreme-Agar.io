import greenfoot.*;

public class TestWorld  extends ScrollWorld{
    public TestWorld(){
        //Creating a world size of 700x500 cells with 1x1 pixels
        super(700, 500, 1);
    }
    
    public void spawnPlayer(){
        addObject(new Cell(), 0, 0);
    }
}
