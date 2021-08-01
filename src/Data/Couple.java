package Data;

public class Couple {

    String pathA, pathB;
    int counter;

    public Couple(){
        pathA="";
        pathB="";
        counter=0;
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

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "Couple{" +
                "pathA='" + pathA + '\'' +
                ", pathB='" + pathB + '\'' +
                ", counter=" + counter +
                "}\n";
    }
}
