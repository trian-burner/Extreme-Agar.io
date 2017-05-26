import greenfoot.*;

public class Agar  extends ScrollWorld{
    private Counter theCounter; //mass counter
    private ScoreBoard scoreBoard;
    public Agar() {
        //Creating a world size of 700x500 cells with 1x1 pixels
        super(900, 600, 1, 4900, 4600);
        
        int startX = (int)(Math.random() * (getFullWidth() - getWidth()) + (getWidth() / 2));
        int startY = (int)(Math.random() * (getFullHeight() - getHeight()) + (getHeight() / 2));
        
        addCameraFollower(new Cell(), 0, 0);
        setCameraLocation(startX, startY);
        
        theCounter = new Counter();
        addObject(theCounter, getWidth()/2, getHeight()/2);
        
        spawnProteins();
        spawnViruses();
        
        //System.out.println(new ScoreBoard().players());
        scoreBoard = new ScoreBoard();
        addObject(scoreBoard, 70, 25);
    }
    
    public Counter getCounter() {
        return theCounter;
    }
    
    public ScoreBoard getScoreBoard(){
        return scoreBoard;
    }
    
    public void spawnPlayer() {
        addObject(new Cell(),(int)(Math.random() * (getFullWidth() - getWidth()) + (getWidth() / 2)), (int)(Math.random() * (getFullHeight() - getHeight()) + (getHeight() / 2)));
    }
    
    public void spawnProteins() {
        //World world = getWorld();
        for (int i = 0; i < 1000; i++) {
            int x = (int)(Math.random() * (getFullWidth() - getWidth()) + (getWidth() / 2));
            int y = (int)(Math.random() * (getFullHeight() - getHeight()) + (getHeight() / 2));
            addObject(new Protein((int)(Math.random() * 5)), x, y);
        }
    }
    
    public void spawnViruses(){
        for(int i = 0; i < 50; i++){
            int x = (int)(Math.random() * (getFullWidth() - getWidth()) + (getWidth() / 2));
            int y = (int)(Math.random() * (getFullHeight() - getHeight()) + (getHeight() / 2));
            addObject(new Virus(), x, y);
        }
    }
}