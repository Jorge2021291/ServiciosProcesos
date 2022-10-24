package act07;

import java.io.*;
import java.io.File;
import java.util.Scanner;

public class act07 {
    public static void main(String[] args) {



        Scanner sc = new Scanner (System.in);

        System.out.print("Introduce un numero y te calculo el doble: ");

        String n = sc.nextLine();



        //Pasamos el comando al ProcessBuilder

        ProcessBuilder pb = new ProcessBuilder("java", "Dobles.java", n);

        //Indicamos el directorio

        File directorio = new File(System.getProperty("user.dir"),"\\src\\dobles");



        //Directorio archivo txt

        //File fOut = new File(System.getProperty("user.dir"),"\\src\\dobles\\result.txt");

        //Si sacamos el numero por consola, no podemos usar el pb.redirectOutput a otro archivo.



        //Pasamos al PB el directorio

        pb.directory(directorio);



        Process p;

        try {

            p = pb.start();



            //Leemos la salida del proceso hijo invocado

            BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));

            String linea;

            while((linea=br.readLine())!=null) {

                System.out.println("El numero es: "+linea);

            }

            br.close();

            sc.close();



        } catch (IOException e) {

            e.printStackTrace();

        }



    } // FIN DEL MAIN

}
