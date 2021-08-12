package Data;

public class PartitionItem {

    int i,j;
    String pathA,pathB;
    int confidenceValue;
    boolean isActive;

    public PartitionItem() {
        i=-1;
        j=-1;
        pathA="";
        pathB="";
        confidenceValue=-1;
        isActive=true;

    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public String getPathA() {
        return pathA;
    }

    public void setPathA(String pathA) {
        this.pathA = pathA;
    }

    public String getPathB() {
        return pathB;
    }

    public void setPathB(String pathB) {
        this.pathB = pathB;
    }

    public int getConfidenceValue() {
        return confidenceValue;
    }

    public void setConfidenceValue(int confidenceValue) {
        this.confidenceValue = confidenceValue;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


    @Override
    public String toString() {
        return "PartitionItem{" +
                "i=" + i +
                ", j=" + j +
                ", pathA='" + pathA + '\'' +
                ", pathB='" + pathB + '\'' +
                ", confidenceValue=" + confidenceValue +
                ", isActive=" + isActive +
                "}\n";
    }
}