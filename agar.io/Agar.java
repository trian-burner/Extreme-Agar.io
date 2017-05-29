import greenfoot.*;
import java.util.ArrayList;

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
    int multiplayer = 0;
    ArrayList<ProteinPackage> p;
    ArrayList<VirusPackage> v;
    WorldPackage wp;
    
    public Agar(String nameString, int multiplayer) {
        //Creating a world size of 700x500 cells with 1x1 pixels
        super(900, 600, 1, 4900, 4600);
        
        this.multiplayer = multiplayer;
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
        
        if (multiplayer == 0) {
            spawnProteins(500);
            spawnViruses(50);
        } else if (multiplayer == 1) {
            spawnProteins(500);
            spawnViruses(50);
            wp = new WorldPackage(p, v);
            thisCellP = new CellPackage(thisCell);
            otherCellP = new CellPackage();
            server = new Server(wp);
            otherCell = new MultiplayerCell();
            addObject(otherCell, 20, 20);
        } else if (multiplayer == 2) {
            thisCellP = new CellPackage(thisCell);
            otherCellP = new CellPackage();
            serverClient = new ServerClient();
            wp = serverClient.getWorld();
            unpackWorldPackage();
            otherCell = new MultiplayerCell();
            addObject(otherCell, 20, 20);
        }
        
        //System.out.println(new ScoreBoard().players());
        //scoreBoard = new ScoreBoard();
        //addObject(scoreBoard, 70, 25);
    }
    
    public void act() {
        if (multiplayer == 1) {
            thisCellP.update(thisCell);
            otherCellP = server.update(thisCellP);
            otherCell.update(otherCellP);
        }
        else if (multiplayer == 2) {
            thisCellP.update(thisCell);
            otherCellP = serverClient.update(thisCellP);
            otherCell.update(otherCellP);
        }
        else {}
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
        for (int i = 0; i < amount; i++) {
            int x = (int)(Math.random() * (getFullWidth() - getWidth()) + (getWidth() / 2));
            int y = (int)(Math.random() * (getFullHeight() - getHeight()) + (getHeight() / 2));
            Protein protein = new Protein((int)(Math.random() * 5));
            addObject(protein, x, y);
            ProteinPackage pPackage = new ProteinPackage(protein);
            p.add(pPackage);
        }
    }
    
    public void spawnViruses(int amount){
        for(int i = 0; i < amount; i++){
            int x = (int)(Math.random() * (getFullWidth() - getWidth()) + (getWidth() / 2));
            int y = (int)(Math.random() * (getFullHeight() - getHeight()) + (getHeight() / 2));
            Virus virus = new Virus();
            addObject(virus, x, y);
            VirusPackage vPackage = new VirusPackage(virus);
            v.add(vPackage);
        }
    }
    
    public void unpackWorldPackage() {
        for (int i = 0; i < wp.p.size(); i++) {
            addObject(new Protein(wp.p.get(i).color), wp.p.get(i).x, wp.p.get(i).y);
        }
        for (int i = 0; i < wp.v.size(); i++) {
            addObject(new Virus(), wp.v.get(i).x, wp.v.get(i).y);
        }
    }
}