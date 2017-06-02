import greenfoot.*;
import java.awt.Color; // importing color for setting the color of the Cell

/**
 * A cell is the circle of mass that the player controls around the world.
 * 
 * @author Wayde Gilliam, Brian Turner, Cecilia Martin, Ethan Harris
 */
public class Cell extends ScrollActor {
    //Variables
    int size = 30;  //Value for image scaling
    int speed = 7;  //Cell travel speed
    int mass = 20;  //Representative value for cell size
    int virus = -60;    //Mass-loss value for viruses  
    int maxSpeed = speed;   //Max Speed for cell (used for setting variable speed)
    int keyCounter = 0; //Wait time for another mass ejection
    int vsd = 20; // [Variable Speed Distance] the distance from the Cell in which the speed changes
    boolean spawn = false;
    Color[] colorList = {Color.cyan, Color.darkGray, Color.green, Color.lightGray, Color.magenta, Color.orange, Color.pink, Color.red, Color.yellow};
    Color color;
    GreenfootImage cell = new GreenfootImage(size, size);
    String name;
    boolean split;
    
    /**
     * Creates a new Cell with a random color
     * @param name The name of the player
     */
    public Cell(String name) {
        super();
        color = colorList[(int)(Math.random() * 9)];
        
        this.name = name;
        
        //Setting Cell Image Before Initializing world
        setImage();
    }
    
    /**
     * Creates a new Cell that is a divided portion of a master Cell and shoots off of the master and is controlled the same way
     * 
     * @param color The color of the master
     * @param rotation The current rotation of the master
     * @param size The current size of the master
     * @param mass The current mass of the master
     */
    public Cell(Color color, int rotation, int size, int mass) {
        super();
        this.color = color;
        this.size = size;
        this.mass = mass;
        
        //Setting Cell Image Before Initializing world
        setImage();
        
        setRotation(rotation);
    }
    
    public void act() {
        MouseInfo m = Greenfoot.getMouseInfo(); //Variable for mouse position
        
        setImage(); //Setting Cell Image After Initializing
        
        setSpeed(m); //Slowing Cell Speed With Mouse
        
        //Getting Mouse location for direction
        if (m != null) { 
            setDirection(m);
        }
        
        //Protein Collision Detection
        if (isTouching(Protein.class)) { 
            hitProtein();
        }
        
        //MassBlob Collision Detection
        MassBlob massBlob = (MassBlob)getOneIntersectingObject(MassBlob.class);
        if(massBlob != null){ 
            hitMassBlob(massBlob);
        }
        
        //Virus Collision Detection
        if(isTouching(Virus.class) && (getMass() >= 60)) {
            hitVirus();
        }
        
        //Ejecting Mass From Cell
        if(Greenfoot.isKeyDown("w")) {
            ejectMass();
        }
        
        //Dividing via Space
        if (Greenfoot.isKeyDown("space")) {
            divide();
        }
        
        //Debug Testing
        if(Greenfoot.isKeyDown("enter")) {
            addMass(1);
        }
        
        if(isTouching(MultiplayerCell.class)){
            cellDevourer();
        }
        
    }
    
    /**
     * Sets the image of the cell based on size and mass when called
     */
    public void setImage() {
        cell = new GreenfootImage(size, size);
        cell.setColor(color);
        cell.fillOval(0, 0, size, size);
        setImage(cell);
    }
    
    /**
     *Consumes a cell with a mass smaller than its own. 
     */
    public void cellDevourer(){
        MultiplayerCell mcell = (MultiplayerCell)getOneIntersectingObject(MultiplayerCell.class);
        if(getMass() > mcell.getMass()){
            addMass(mcell.getMass());
        }else if(getMass() < mcell.getMass()){
            death();
        }
    }
    
    /**
     * Returns the mass of the Cell
     */
    public int getMass() {
        return mass;
    }
    
    /**
     * Increases the mass and size of the cell
     * @param num The amount the mass and size will be increased by
     */
    public void addMass(int num) {
        for (int i = 0; i < num; i++) {
            size += 1;
            mass += 1;
            //Decrementing speed as mass increments
            if(mass % 40 == 0 && speed > 1) {
                maxSpeed--;
            }
        }
        counter();
    }
    
    /**
     * Deceases the mass and size of the cell
     * @param num The amount the mass and size will be decreased by
     */
    public void removeMass(int num) {
        for (int i = 0; i < num; i++) {
            size -= 1;
            mass -= 1;
            //Decrementing speed as mass increments
            if(mass % 40 == 0 && speed < 7) {
                maxSpeed++;
            }
        }
        counter();
    }
    
    /**
     * Divides the cell into two Cells of half mass and size
     */
     //Cell Divison
     public void divide() {
        if(split == true){
            split = false;
             if(mass/6 >= 20){
                removeMass(getMass()/6);
                /*for(int i = 0; i < 6; i++){
                    ((Agar)getWorld()).addObject(new miniCell(), getGlobalX(), getGlobalY());
                }*/
            }else{
                mass = 20;
                size = 30;
                speed = 5;
                /*for(int i = 0; i < 5; i++){
                    ((Agar)getWorld()).addObject(new miniCell(), getGlobalX(), getGlobalY());
                }*/
            }
        }else{
            if(mass/2 >= 20){
                removeMass(getMass()/2);
                //((Agar)getWorld()).addObject(new miniCell(), getGlobalX(), getGlobalY());
            }
        }
    }
    
    /**
     * Updates the counter with the current mass
     */
    public void counter() {
        Counter counter = ((Agar)getWorld()).theCounter;  // get a reference to the counter within the world
        counter.updateCount(mass, speed);
        //ScoreBoard scoreboard = ((Agar)getWorld()).getScoreBoard();
        //scoreboard.updateScore(mass);
    }
    
    /**
     * "Kills" the cell, ends the game, and shows the endGame screen
     */
    public void death() {
        getWorld().addObject(new FadeOut(new GameOver(name)), 450, 300);
        getWorld().removeObject(this);
    }
    
    /**
     * Sets the speed of the cell based on the distance between the mouse and the cell
     * @param m The current MouseInfo (position)
     */
    public void setSpeed(MouseInfo m) {
        if (m != null) {
            // calculates the distance between the mouse and the cell
            int mouseDistance = (int)Math.pow((Math.pow((m.getX() - ((Agar)getWorld()).getWidth()/2), 2) + Math.pow((m.getY() - ((Agar)getWorld()).getHeight()/2), 2)), .5);
           
            // changes the speed of the Cell based on how close the mouse is to it
            if (mouseDistance <= vsd) {
                speed = 0;
            }
            else if ((mouseDistance <= vsd + 15) && (mouseDistance > vsd)) {
                speed = 1;
            }
            else if ((mouseDistance <= vsd + 30) && (mouseDistance > vsd + 15)) {
                if (maxSpeed >= 2) {
                   speed = 2; 
                }
            }
            else if ((mouseDistance <= vsd + 45) && (mouseDistance > vsd + 30)) {
                if (maxSpeed >= 2) {
                   speed = 3; 
                }
            }
            else if ((mouseDistance <= vsd + 60) && (mouseDistance > vsd + 45)) {
                if (maxSpeed >= 2) {
                   speed = 4; 
                }
            }
            else {
                speed = maxSpeed;
            }
        }
    }
    
    /**
     * Sets the direction of the World based on the mouses position, and moves in that direction a certain speed
     * @param m The current MouseInfo (position)
     */
    public void setDirection(MouseInfo m) {
        turnTowards(m.getX(), m.getY());
        getWorld().setCameraDirection(getRotation());
        getWorld().moveCamera(speed);
    }
    
    /**
     * Removes any Protein that the Cell is touching, add mass to the Cell, and spawn a new protein in a random location in the World
     */
    public void hitProtein() {
        removeTouching(Protein.class);
        addMass(1);
        ((Agar)getWorld()).spawnProteins(1);
    }
    
    /**
     * Removes any MassBlob that the Cell is touching, and add mass to the Cell
     * @param massBlob The MassBlob that the Cell is touching, used to access the MassBlob to tell whether it's stopped it's initial movement
     */
    public void hitMassBlob(MassBlob massBlob) {
        if (massBlob.shot == true) {
            removeTouching(MassBlob.class);
            addMass(10); 
        }
    }
    
    /**
     * Removes any Virus that the Cell is touching, and remove mass
     */
    public void hitVirus() {
        removeTouching(Virus.class);
        split = true;
        divide();
        }
           
    /**
     * Ejects a MassBlob from the Cell at it's current rotation, and remove mass
     */
    public void ejectMass() {
        if (mass > 30) {
            if (keyCounter > 5) {
                if(mass <= 250){
                    ((Agar)getWorld()).addObject(new MassBlob(cell.getColor(), getRotation(), getGlobalX(), getGlobalY(), 30), getGlobalX(), getGlobalY());
                } else if(mass <= 500){
                    ((Agar)getWorld()).addObject(new MassBlob(cell.getColor(), getRotation(), getGlobalX(), getGlobalY(), 50), getGlobalX(), getGlobalY());
                } else {
                    ((Agar)getWorld()).addObject(new MassBlob(cell.getColor(), getRotation(), getGlobalX(), getGlobalY(), 70), getGlobalX(), getGlobalY());
                }
                removeMass(10);
                keyCounter = 0;
            }
            else {
                keyCounter++;
            }
        }
    }
}