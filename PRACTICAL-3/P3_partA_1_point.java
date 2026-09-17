public class P3_partA_1_point {
    private int x;
    private int y;

    P3_partA_1_point(int x,int y) {
        this.x=x;
        this.y=y;
    }

    public String toString() {
        return "("+x+", "+y+")";
    }

    public boolean equals(Object o) {
        P3_partA_1_point p=(P3_partA_1_point)o;

        if(x==p.x && y==p.y)
            return true;

        return false;
    }

    public int hashCode() {
        return x*31+y;
    }
}