package Act8;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ej8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> numeros = new ArrayList<>();


        int entrada = 1;

        while (entrada != 0) {
            System.out.print("Introduce un numero(si introduce 0, se le dejara de pedir numeros): ");
            entrada = sc.nextInt();
            if (entrada != 0) {
                String num = String.valueOf(entrada);
                numeros.add(num);


            }
        }


            ProcessBuilder pb = new ProcessBuilder("java", "Ej8_hijo.java", numeros.toString());


            File directorio = new File("C:\\Users\\Jorge\\Documents\\ServiciosProcesos\\UD1\\EjerciciosUD1\\src\\Act8\\");

            pb.directory(directorio);

            Process p;
            InputStream is = null;


        try {

                p = pb.start();
                is = p.getInputStream();


                //Leemos la salida del proceso hijo

                BufferedReader br = new BufferedReader (new InputStreamReader (is));


                String linea;

                while ((linea = br.readLine()) != null) {

                    System.out.println(linea);

                }

                br.close();


            } catch (IOException e) {

                e.printStackTrace();

            }finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                    System.out.println("IOE generada " + ex.getMessage());
                }
            }
        }
        }


    }

