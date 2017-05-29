public class VirusPackage implements java.io.Serializable {
    private static final long serialVersionUID = 1113799434508676097L;
    int x;
    int y;

    public VirusPackage(Virus v) {
        this.x = v.getGlobalX();
        this.y = v.getGlobalY();
    }
}