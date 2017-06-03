/**
 * A package that will contain a single protein's location and color. Later used for the WorldPackage.
 */
public class ProteinPackage implements java.io.Serializable {
    private static final long serialVersionUID = 2L; // a special serial ID used to make sure the correct Class is being used
    int x;
    int y;
    int color;

    /**
     * Creates a new ProteinPackage with the given x, y, and color
     * 
     * @param x The x location of a protein in the Server world
     * @param y The y location of a protein in the Server world
     * @param c The color of the protein at this location
     */
    public ProteinPackage(int x, int y, int c) {
        this.x = x;
        this.y = y;
        color = c;
    }
}