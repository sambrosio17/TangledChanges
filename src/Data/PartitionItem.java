package Data;

public class PartitionItem {

    boolean active;
    int i,j;
    String pathA,pathB;
    int confidenceValue;


    public PartitionItem() {
        i=-1;
        j=-1;
        pathA="";
        pathB="";
        confidenceValue=-1;
        active=true;

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
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object x){

        PartitionItem p=(PartitionItem) x;

        return p.getI()==this.i && p.getJ()==this.j && p.getConfidenceValue()==this.confidenceValue;
    }

    @Override
    public String toString() {
        return "PartitionItem{" +
                "active=" + active +
                ", i=" + i +
                ", j=" + j +
                ", pathA='" + pathA + '\'' +
                ", pathB='" + pathB + '\'' +
                ", confidenceValue=" + confidenceValue +
                '}'+'\n';
    }
}
