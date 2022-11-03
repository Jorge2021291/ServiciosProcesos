package Act2;

import java.util.ArrayList;
import java.util.Scanner;

public class Ej2 {
    public static ArrayList<Integer> divisor(int n1) {

        ArrayList<Integer> numeros = new ArrayList<>();


        for(int i = 1; i <=n1; i++){

            if(n1%i == 0){
                numeros.add(i);
            }

        }

        return numeros;

    }



}
