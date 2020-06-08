package unac.edu.co;

public class Nodo {

    protected Object date;
    protected Nodo left;
    protected Nodo right;

    public Nodo(Object value) {
        date = value;
        left = right = null;
    }

    public Nodo(Nodo branchL, Object value, Nodo branchR) {
        date = value;
        left = branchL;
        right = branchR;
    }

    public Object valueNode() {
        return date;
    }

    public Nodo subTreeL() {
        return left ;
    }

    public Nodo subTreeR() {
        return right;
    }

    public void newValue(Object d) {
        date = d;
    }

    public void branchL(Nodo n) {
        left = n;
    }

    public void branchR(Nodo n) {
        right = n;
    }

    public void visited() {
        System.out.print(" " + date + " ");
    }
}
