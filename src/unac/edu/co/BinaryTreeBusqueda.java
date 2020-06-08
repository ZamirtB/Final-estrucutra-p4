package unac.edu.co;

public class BinaryTreeBusqueda extends BinaryTree {

    public BinaryTreeBusqueda() {
        super();
    }

    public Nodo buscar(Object buscado) {
        Comparador date;
        date = (Comparador) buscado;
        if (root == null)
            return null;
        else
            return localizated(treeRoot(), date);
    }

    protected Nodo localizated(Nodo subRoot, Comparador wanted) {
        if (subRoot == null)
            return null;
        else if (wanted.igualQue(subRoot.valueNode()))
            return root;
        else if (wanted.menorQue(subRoot.valueNode()))
            return localizated(subRoot.subTreeL(), wanted);
        else
            return localizated(subRoot.subTreeR(), wanted);
    }

    public Nodo buscarIterativo(Object wanted) {
        Comparador date;
        boolean encontrado = false;
        Nodo subRoot = root;
        date = (Comparador) wanted;
        while (!encontrado && subRoot != null) {
            if (date.igualQue(subRoot.valueNode()))
                encontrado = true;
            else if (date.menorQue(subRoot.valueNode()))
                subRoot = subRoot.subTreeL();
            else
                subRoot = subRoot.subTreeR();
        }
        return subRoot;
    }

    public void insert(Object value) throws Exception {
        Comparador date;
        date = (Comparador) value;
        root = insert(root, date);
    }

    protected Nodo insert(Nodo raizSub, Comparador date) throws Exception {
        if (raizSub == null)
            raizSub = new Nodo(date);
        else if (date.menorQue(raizSub.valueNode())) {
            Nodo iz;
            iz = insert(raizSub.subTreeL(), date);
            raizSub.branchL(iz);
        } else if (date.mayorQue(raizSub.valueNode())) {
            Nodo dr;
            dr = insert(raizSub.subTreeR(), date);
            raizSub.branchR(dr);
        } else
            throw new Exception("Nodo duplicado");
        return raizSub;
    }

    public void deleted(Object valor) throws Exception {
        Comparador dato;
        dato = (Comparador) valor;
        root = deleted(root, dato);
    }

    protected Nodo deleted(Nodo subRoot, Comparador dato) throws Exception {
        if (subRoot == null)
            throw new Exception("No encontrado el nodo con la clave");
        else if (dato.menorQue(subRoot.valueNode())) {
            Nodo iz;
            iz = deleted(subRoot.subTreeL(), dato);
            subRoot.branchL(iz);
        } else if (dato.mayorQue(subRoot.valueNode())) {
            Nodo dr;
            dr = deleted(subRoot.subTreeR(), dato);
            subRoot.branchR(dr);
        } else {
            Nodo q;
            q = subRoot;
            if (q.subTreeL() == null)
                subRoot = q.subTreeR();
            else if (q.subTreeR() == null)
                subRoot = q.subTreeL();
            else {
                q = replace(q);
            }
            q = null;
        }
        return subRoot;
    }

    private Nodo replace(Nodo act) {
        Nodo a, p;
        p = act;
        a = act.subTreeL();
        while (a.subTreeR() != null) {
            p = a;
            a = a.subTreeR();
        }
        act.newValue(a.valueNode());
        if (p == act)
            p.branchL(a.subTreeL());
        else
            p.branchR(a.subTreeL());
        return a;
    }
}
