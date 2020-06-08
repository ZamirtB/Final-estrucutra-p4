package unac.edu.co;

public class BinaryTree {

    protected Nodo root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(Nodo root) {
        this.root = root;
    }

    public Nodo treeRoot() {
        return root;
    }


    boolean IsEmpty() {
        return root == null;
    }

    public static Nodo nuevoArbol(Nodo ramaIzqda, Object dato, Nodo ramaDrcha) {
        return new Nodo(ramaIzqda, dato, ramaDrcha);
    }

    public static void preorden(Nodo r) {
        if (r != null) {
            System.out.print("\n ");
            r.visited();
            preorden(r.subTreeL());
            preorden(r.subTreeR());

        }
    }

    public static void inorden(Nodo r) {
        if (r != null) {
            inorden(r.subTreeL());
            System.out.println("");
            r.visited();
            inorden(r.subTreeR());
        }
    } // Recorrido de un �rbol binario en postorden

    public static void postorden(Nodo r) {
        if (r != null) {
            postorden(r.subTreeL());
            postorden(r.subTreeR());
            r.visited();
        }
    }

    public static int numNodos(Nodo raiz) {
        if (raiz == null)
            return 0;
        else
            return 1 + numNodos(raiz.subTreeL()) + numNodos(raiz.subTreeR());
    }

    public static int altura(Nodo raiz) {
        if (raiz == null)
            return 0;
        else {
            int alturaIz = altura(raiz.subTreeL());
            int alturaDr = altura(raiz.subTreeR());
            if (alturaIz > alturaDr)
                return alturaIz + 1;
            else
                return alturaDr + 1;
        }
    }

    public static boolean arbolLleno(Nodo raiz) {
        if (raiz == null)
            return true;
        else if (altura(raiz.subTreeL()) != altura(raiz.subTreeR()))
            return false;
        return arbolLleno(raiz.subTreeL()) && arbolLleno(raiz.subTreeR());
    }

    public static BinaryTree copiaArbol(Nodo raiz) {
        Nodo raizCopia;
        if (raiz == null)
            raizCopia = null;
        else {
            BinaryTree izdoCopia, dchoCopia;
            izdoCopia = copiaArbol(raiz.subTreeL());
            dchoCopia = copiaArbol(raiz.subTreeR());
            raizCopia = new Nodo(izdoCopia.treeRoot(), raiz.valueNode(), dchoCopia.treeRoot());
        }
        return new BinaryTree(raizCopia);
    }

    public static double evaluar(Nodo raiz, double[] operandos) throws Exception {
        double x, y, valor;
        char ch;
        Character nr;
        valor = 0.0;
        if (raiz != null) { // no est� vac�o
            nr = (Character) raiz.valueNode();
            ch = nr.charValue();
            if (ch >= 'A' && ch <= 'Z')
                return operandos[ch - 'A'];
            else {
                x = evaluar(raiz.subTreeL(), operandos);
                y = evaluar(raiz.subTreeR(), operandos);

                switch (ch) {
                    case '+':
                        valor = x + y;
                        break;
                    case '-':
                        valor = x - y;
                        break;
                    case '*':
                        valor = x * y;
                        break;
                    case '/':
                        if (y != 0)
                            valor = x / y;
                        else
                            throw new Exception("Error: divisi�n por 0");
                        break;
                    case '^':
                        valor = Math.pow(x, y);
                }
            }
        }
        return valor;
    }

    public static void dibujar(String prefijo, boolean esCola, Nodo n) {
        if (n != null) {
            System.out.println(prefijo + (esCola ? "└── " : "├── ") + n.date);
            dibujar(prefijo + (esCola ? "    " : "│   "), false, n.subTreeL());
            dibujar(prefijo + (esCola ? "    " : "│   "), true, n.subTreeR());
        }
    }

}