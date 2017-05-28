import greenfoot.*;

public class Agar  extends ScrollWorld{
    Counter theCounter; //mass counter
    ScoreBoard scoreBoard;
    Cell thisCell;
    MultiplayerCell otherCell;
    String nameString;
    Name name;
    CellPackage thisCellP;
    CellPackage otherCellP;
    ServerClient serverClient;
    Server server;
    
    public Agar(String nameString) {
        //Creating a world size of 700x500 cells with 1x1 pixels
        super(900, 600, 1, 4900, 4600);
        
        this.nameString = nameString;
        
        int startX = (int)(Math.random() * (getFullWidth() - getWidth()) + (getWidth() / 2));
        int startY = (int)(Math.random() * (getFullHeight() - getHeight()) + (getHeight() / 2));
        
        thisCell = new Cell(nameString);
        addCameraFollower(thisCell, 0, 0);
        setCameraLocation(startX, startY);
        
        name = new Name(nameString);
        addObject(name, getWidth()/2, getHeight()/2-8);
        
        theCounter = new Counter();
        addObject(theCounter, getWidth()/2, getHeight()/2+8);
        
        spawnProteins(500);
        spawnViruses();
        
        //thisCellP = new CellPackage(thisCell);
        //otherCellP = new CellPackage();
        //server = new Server();
        //serverClient = new ServerClient();
        
        //otherCell = new MultiplayerCell();
        //addObject(otherCell, 20, 20);
        
        //System.out.println(new ScoreBoard().players());
        //scoreBoard = new ScoreBoard();
        //addObject(scoreBoard, 70, 25);
    }
    
    public void act() {
        //thisCellP.update(thisCell);
        
        //otherCellP = server.update(thisCellP);
        //otherCellP = serverClient.update(thisCellP);
        
        //otherCell.update(otherCellP);
    }
    
    public Counter getCounter() {
        return theCounter;
    }
    
    public void newName(String name) {
        addObject(new Name(name), getWidth()/2, getHeight()/2-8);
    }
    
    public ScoreBoard getScoreBoard(){
        return scoreBoard;
    }
    
    public void spawnPlayer() {
        addObject(new Cell(nameString),(int)(Math.random() * (getFullWidth() - getWidth()) + (getWidth() / 2)), (int)(Math.random() * (getFullHeight() - getHeight()) + (getHeight() / 2)));
    }
    
    public Cell getPlayerCell() {
        return thisCell;
    }
    
    public void spawnProteins(int amount) {
        //World world = getWorld();
        for (int i = 0; i < amount; i++) {
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