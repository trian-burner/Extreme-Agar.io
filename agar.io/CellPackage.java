import java.awt.Color;

public class CellPackage implements java.io.Serializable {
    private static final long serialVersionUID = 1113799434508676095L;
    String name;
    int size;
    int mass;
    int x;
    int y;
    int rotation;
    int speed;
    Color color = Color.white;
    
    public CellPackage() {}
    
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
    
    public String toString() {
        return "Name: " + name + "; Size: " + size + "; Mass: " + mass + "; X: " + x + "; Y: " + y + "; R: " + rotation + "; Speed: " + speed;
    }
}