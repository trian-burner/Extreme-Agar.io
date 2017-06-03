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
    
    /**
     * Creates a new empty CellPackage
     */
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