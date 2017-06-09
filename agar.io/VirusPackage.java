/**
 * A package that will contain a single virus's location. Later used for the WorldPackage.
 */
public class VirusPackage implements java.io.Serializable {
    private static final long serialVersionUID = 3L; // a special serial ID used to make sure the correct Class is being used
    int x;
    int y;

    /**
     * Creates a new VirusPackage with the given x and y
     * 
     * @param x The x location of a virus in the Server world
     * @param y The y location of a virus in the Server world
     */
    public VirusPackage(int x, int y) {
        this.x = x;
        this.y = y;
    }
}