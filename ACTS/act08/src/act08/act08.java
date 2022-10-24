package act08;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class act08 {

    public static void main(String[] args) {

        //a continuacion se iran pidiendo por teclado valores y guardándolos para que lo ejecute el proceso hijo
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe números, el valor 0 detendría la secuencia(introduce  número + Enter)");
        int num=1;
        ArrayList<String> comandos = new ArrayList<>();//arraylist para meter todas las instrucciones para el processBuilder
        int cont = 0;
        comandos.add("java");
        comandos.add("Ejercicio8_hijo.java");// sera como meter "java Ejercicio8_hijo.java"
        while(num!=0){
            cont++;
            System.out.print("El "+cont+"º numero: ");
            num = sc.nextInt();
            if(num!=0){
                String o = String.valueOf(num);
                comandos.add(o);//ira añadiendo los valores numericos que interpretara el processBuilder para que opere el hijo
            }
        }//fin while
        sc.close();

        ProcessBuilder pb = new ProcessBuilder(comandos);
        File directorio = new File("D:\\Users\\JorgeYu\\Documents\\ServiciosProcesos\\ACTS");
        pb.directory(directorio);// donde va a buscar el programa para ejecutar el proceso hijo
        Process p = null;
        InputStream is = null;
        try {
            p = pb.start();
            is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String linea = null;
            linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                    System.out.println("IOE generada " + ex.getMessage());
                }
            }
        }

    }//fin main
}//fin clase

