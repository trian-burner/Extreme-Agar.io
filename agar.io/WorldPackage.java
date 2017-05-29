import java.util.ArrayList;

public class WorldPackage implements java.io.Serializable {
    private static final long serialVersionUID = 1113799434508676097L;
    ArrayList<ProteinPackage> p;
    ArrayList<VirusPackage> v;

    public WorldPackage(ArrayList<ProteinPackage> p, ArrayList<VirusPackage> v) {
        this.p = p;
        this.v = v;
    }
}