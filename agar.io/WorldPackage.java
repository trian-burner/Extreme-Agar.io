import java.util.ArrayList;

/**
 * A package that will contain an arraylist of all of the proteins and viruses in the world the Server created. Will be sent to the Client when first connected.
 */
public class WorldPackage implements java.io.Serializable {
    private static final long serialVersionUID = 4L;
    ArrayList<ProteinPackage> p;
    ArrayList<VirusPackage> v;

    /**
     * Creates a new WorldPackage with the given protein and virus package lists
     * 
     * @param p The ArrayList of every package of every Protein in the world
     * @param v The ArrayList of every package of every Virus in the world
     */
    public WorldPackage(ArrayList<ProteinPackage> p, ArrayList<VirusPackage> v) {
        this.p = p;
        this.v = v;
    }
}