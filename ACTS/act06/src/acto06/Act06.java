package acto06;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Act06 {

    public static void main(String[]args){

        //proces hijo
        Process proceso = null;
        @SuppressWarnings("resource")
        Scanner entrada = new Scanner(System.in);
        String texto = "";

        try        {
            do
            {
                System.out.println("Escriba aqui:");
                texto = entrada.nextLine();

                if(!texto.equals("fin") ){
                    LeerLinea(proceso, texto);
                }
            }
            while(!texto.equals("fin"));

            System.out.println("The End.");
        }
        finally
        {
            if( proceso != null)
                proceso.destroy();
        }

    }


    private static void LeerLinea(Process proceso, String texto) {

        try
        {
            proceso = Runtime.getRuntime().exec("java -jar act2exe.jar");

            //  stream de salida del programa hijo
            InputStream inpst = proceso.getInputStream();

            /*  leer la salida */
            BufferedReader bufr = new BufferedReader (new InputStreamReader (inpst));

            // lee la primera linea
            String ln = bufr.readLine();

            if (ln !=null){
                System.out.println(ln);

            }
        }catch(Exception e)
        {
            // Excepciones.*/
            e.printStackTrace();
        }

    }
}
