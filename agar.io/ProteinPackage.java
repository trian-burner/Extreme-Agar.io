public class ProteinPackage implements java.io.Serializable {
    private static final long serialVersionUID = 1113799434508676096L;
    int x;
    int y;
    String color;

    public ProteinPackage(Protein p) {
        this.x = p.getGlobalX();
        this.y = p.getGlobalY();
        this.color = p.color;
    }
}