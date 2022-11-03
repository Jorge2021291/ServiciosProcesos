package Act1;

import java.util.Scanner;

public class Ej1 {
    public static int sumar(int n1, int n2){
        int resultado = 0;
        for(int i = n1; i <=n2; i++ ){
            resultado += i;

        }

        return resultado;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Introduce el Primer numero: ");
        int n1 = sc.nextInt();

        System.out.printf("Introduce el Segundo numero: ");
        int n2 = sc.nextInt();

        System.out.printf("El resultado es " + sumar(n1,n2) + "\n");

    }//fin del main
}//fin clase


