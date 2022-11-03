package Act2;

import java.util.Scanner;

import static Act2.Ej2.divisor;

public class Lanzador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Introduce el Numero: ");
        int n1 = sc.nextInt();

        System.out.printf("El resultado tiene " + divisor(n1).size() + " divisores y son " + divisor(n1) + "\n");
    }
}
