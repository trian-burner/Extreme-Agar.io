public class ProteinPackage implements java.io.Serializable {
    private static final long serialVersionUID = 1113799434508676096L;
    int x;
    int y;
    int color;

    public ProteinPackage(int x, int y, int c) {
        this.x = x;
        this.y = y;
        color = c;
    }
}