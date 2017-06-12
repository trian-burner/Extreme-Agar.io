import java.awt.Color;

/**
 * A package of variables that will be filled with the Player's cell's variable values, position , and rotation. This package will be sent over a secure TCP connection to the respective Server or Client player.
 */
public class CellPackage implements java.io.Serializable {
    private static final long serialVersionUID = 1L; // a special serial ID used to make sure the correct Class is being used
    String name;
    int size;
    int mass;
    int x;
    int y;
    int rotation;
    int speed;
    Color color = Color.white;
<<<<<<< HEAD
        
    /**
     * Creates a new empty CellPackage
    */
=======

    /**
     * Creates a new empty CellPackage
     */
>>>>>>> e09ad90986e85a6ee9e87e0946baf1f503c37895
    public CellPackage() {}
    
    /**
     * Creates a new CellPackage and fills all of the variables with the given Cell's values
     * 
     * @param cell The cell that the package is being created to "hold"
    */
    public CellPackage(Cell cell) {
        this.name = cell.name;
        this.size = cell.size;
        this.mass = cell.mass;
        this.x = cell.getGlobalX();
        this.y = cell.getGlobalY();
        this.rotation = cell.getRotation();
        this.speed = cell.speed;
        this.color = cell.color;
    }
        
        /**
         * Updates the package with the current act's values
         * 
         * @param cell The cell that the package will be updated with
         */
    public void update(Cell cell) {
<<<<<<< HEAD
        if(cell != null){
            this.name = name;
            this.size = cell.size;
            this.mass = cell.mass;
            this.x = cell.getGlobalX();
            this.y = cell.getGlobalY();
            this.rotation = cell.getRotation();
            this.speed = cell.speed;
            this.color = cell.color;
        }
    }

    public String toString() {
        return "Name: " + name + "; Size: " + size + "; Mass: " + mass + "; X: " + x + "; Y: " + y + "; R: " + rotation + "; Speed: " + speed;
=======
        this.name = cell.name;
        this.size = cell.size;
        this.mass = cell.mass;
        this.x = cell.getGlobalX();
        this.y = cell.getGlobalY();
        this.rotation = cell.getRotation();
        this.speed = cell.speed;
        this.color = cell.color;
>>>>>>> e09ad90986e85a6ee9e87e0946baf1f503c37895
    }
}