package UT1;

import java.io.IOException;

public class ej3 {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String comando = "NOTEPAD";
        Process p;
        try {
            p = r.exec(comando);
            throw new Exception("JIJIJIJÀ");

        } catch (Exception e) {
            System.out.println("Error en " + comando);
            e.printStackTrace();
        }
    }
}
