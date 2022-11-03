package Act6;

import java.io.*;
import java.util.Scanner;

public class Ej6 {

    public static void main(String[]args){

        Process p = null;
        Scanner sc = new Scanner(System.in);
        String entrada = "";



        try {
            while(!entrada.equals("fin")){
                System.out.print("Introduce petición: ");
                entrada = sc.nextLine();
                entrada = entrada.toLowerCase();

                if(!entrada.equals("fin") ){
                    LeerLinea(p, entrada);
                }

            }



            System.out.println("Finalizado.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }//fin del main



    private static void LeerLinea(Process p, String entrada) {

        try
        {
            ProcessBuilder pb = new ProcessBuilder("java", "Random.java");
            File directorio = new File("C:\\Users\\Jorge\\Documents\\ServiciosProcesos\\UD1\\EjerciciosUD1\\src\\Act6\\");
            pb.directory(directorio);


            p = pb.start();
            // lee la salida //

            InputStream is = p.getInputStream();

            BufferedReader br = new BufferedReader (new InputStreamReader (is));
            String ln = br.readLine();

            if (ln !=null){
                System.out.println(ln);

            }
            br.close();

        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }//fin del metodo
}//fin de la clase