import unac.edu.co.BinaryTree;
import unac.edu.co.BinaryTreeBusqueda;
import unac.edu.co.Estudiantes;
import unac.edu.co.Nodo;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner input;
    static String c = "";
    static String n[] = new String[19];
    static int i = 0;

    static BinaryTreeBusqueda h = new BinaryTreeBusqueda();
    static BufferedReader entry = new BufferedReader(new InputStreamReader(System.in));
    static Estudiantes z;
    static String b;

    private static void readPrintLine() {
        String line = input.nextLine();
        c = "";
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            String a = Character.toString(c);
            Main.c = Main.c + a;
        }
        n[i] = c;
    }
    public static void main(String[] a) {
        int nm;
        Random r;
        r = new Random(413);
        final int Mx = 999;
        try {
            input = new Scanner(new File("alumnos.txt"));
            for (i = 0; i < 19; i++) {
                readPrintLine();
                int a1 = r.nextInt(Mx) + 1;
                z = new Estudiantes(Main.c, a1);
                h.insert(z);
            }
            for (i = 0; i < 19; i++) {
                for (int j = i + 1; j < 19; j++) {
                    if (n[i].compareTo(n[j]) > 0) {
                        b = n[i];
                        n[i] = n[j];
                        n[j] = b;
                    }
                }
            }
            do {
                System.out.println("1. Mostrar el  Árbol");
                System.out.println("2. Eliminar un estudiante");
                System.out.println("3. Ordenado");
                System.out.println("4. Salir");

                do
                    nm = Integer.parseInt(entry.readLine());
                while (nm < 1 || nm > 4);
                if (nm == 1) {
                    System.out.println("Estudiantes");
                    BinaryTree.inorden(h.treeRoot()) ;
                    System.out.print("\n \n preorden \n");
                    BinaryTree.preorden(h.treeRoot());



                } else if (nm == 2) {
                    int nmt;
                    System.out.print("Matricula: ");
                    nmt = Integer.parseInt(entry.readLine());
                    try {
                        h.deleted(new Estudiantes(null, nmt));
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                } else if (nm == 3) {
                    for (int i = 0; i <= 19 - 1; i++) {
                        System.out.print(n[i] + ", \n");
                    }

                }
            } while (nm != 4);
        } catch (Exception er) {
            er.printStackTrace();
        }
    }
    static void visualizar(Nodo r) {
        if (r != null) {
            visualizar(r.subTreeL());
            System.out.println(r.valueNode());
            visualizar(r.subTreeR());
        }
    }
    public static void searchMax(Nodo n) {

        if (n != null) {

        }

    }

}