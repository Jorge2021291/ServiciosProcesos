package Act7;

import java.io.*;
import java.util.Scanner;

public class Ej7 {
    public static void main(String[] args) {



        Scanner sc = new Scanner (System.in);

        System.out.print("Introduce el numero a duplicar: ");

        String entrada = sc.nextLine();

        //creamos el processbuilder con la entrada del usuario

        ProcessBuilder pb = new ProcessBuilder("java", "Duplicador.java", entrada);


        File directorio = new File("C:\\Users\\Jorge\\Documents\\ServiciosProcesos\\UD1\\EjerciciosUD1\\src\\Act7\\");

        pb.directory(directorio);

        Process p;

        try {

            p = pb.start();



            //Leemos la salida del proceso hijo

            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String linea;

            while((linea = br.readLine())!=null) {

                System.out.println(linea);

            }

            br.close();




        } catch (IOException e) {

            e.printStackTrace();

        }



    } //fin del main
}
