import greenfoot.*;
import java.util.ArrayList;

public class Agar  extends ScrollWorld {
    //Agar Class Variables
    String nameString;
    NamePlate np;
    int multiplayer = 0;
    boolean dying = false;
    
    //Agar World Objects
    Counter theCounter; //mass counter
    ScoreBoard scoreBoard;
    
    Cell thisCell;
    MultiplayerCell otherCell;
    
    //Server and Package Variables
    CellPackage thisCellP;
    CellPackage otherCellP;
    
    ArrayList<ProteinPackage> p = new ArrayList<ProteinPackage>();
    ArrayList<VirusPackage> v = new ArrayList<VirusPackage>();
    WorldPackage wp;
    
    ServerClient serverClient;
    Server server;
    
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
        
        np = new NamePlate(nameString);
        addObject(np, getWidth()/2, getHeight()/2-8);
        
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
        
        scoreBoard = new ScoreBoard();
        addObject(scoreBoard, 80, 40);
    }

    public void act() {
        if (multiplayer == 1) {
            if(Greenfoot.isKeyDown("escape") && dying == false) {
                server.stopIt();
                thisCell.death();
                thisCell = null;
                dying = true;
            }
            
            if (thisCell != null) {
                thisCellP.update(thisCell);
                
                otherCellP = server.update(thisCellP);
                otherCell.update(otherCellP);
            }
            
            //scoreBoard.updateScore(thisCell.name, thisCell.mass, otherCell.name, otherCell.mass);
        }
        else if (multiplayer == 2) {
            if (thisCell != null) {
                thisCellP.update(thisCell);
            }
            
            if (otherCell != null) {
                otherCellP = serverClient.update(thisCellP);
                otherCell.update(otherCellP);
            }
            
            if (otherCellP == null) {
                removeObject(otherCell);
                otherCell = null;
                serverClient.stopIt();
            }
            
            if(Greenfoot.isKeyDown("escape")) {
                serverClient.stopIt();
                thisCell.death();
            }
        }
        else {
            if(Greenfoot.isKeyDown("escape") && dying == false) {
                thisCell.death();
                dying = true;
            }
        }
        
        if(multiplayer == 0){
             scoreBoard.updateScore(thisCell.name, thisCell.getMass());
         } else {
             scoreBoard.updateScore(thisCell.name, thisCell.getMass(), otherCell.name, otherCell.getMass());
         }
    }
    
    public void spawnProteins(int amount) {
        for (int i = 0; i < amount; i++) {
            int x = (int)(Math.random() * (getFullWidth() - getWidth()) + (getWidth() / 2));
            int y = (int)(Math.random() * (getFullHeight() - getHeight()) + (getHeight() / 2));
            int c = (int)(Math.random() * 5);
            addObject(new Protein(c), x, y);
            
            ProteinPackage pPackage = new ProteinPackage(x, y, c);
            p.add(pPackage);
        }
    }
    
    public void spawnViruses(int amount){
        for(int i = 0; i < amount; i++){
            int x = (int)(Math.random() * (getFullWidth() - getWidth()) + (getWidth() / 2));
            int y = (int)(Math.random() * (getFullHeight() - getHeight()) + (getHeight() / 2));
            addObject(new Virus(), x, y);
            
            VirusPackage vPackage = new VirusPackage(x, y);
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