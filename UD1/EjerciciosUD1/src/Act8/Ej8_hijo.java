package Act8;

import java.util.ArrayList;
import java.util.Arrays;

public class Ej8_hijo {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();


        String lista = args[0];
        char[] nums = lista.toCharArray();
        int resultado = 0;


        int fin;

        for (char i: nums) {
            if (Character.getNumericValue(i) != -1) {
                numeros.add(Character.getNumericValue(i));
                resultado += Character.getNumericValue(i);



            }
        }


        System.out.println("La media de todos los numeros son:  "+ resultado/numeros.size());










    }

    }
