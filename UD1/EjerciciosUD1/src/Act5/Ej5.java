package Act5;

import java.io.*;
import java.util.Scanner;

public class Ej5 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Ej5 eje = new Ej5();

        System.out.print("1/ProcessBuilder. 2/RunTime: ");
        int elec = sc.nextInt();

        String ruta = System.getProperty("user.home");

        System.out.print("Numero de peticiones que quieres: ");
        int peticiones = sc.nextInt();

        if(elec == 1) {
            eje.ejecucionPB(peticiones, ruta);
        }else if (elec == 2) {
            eje.ejecucionRT(peticiones, ruta);
        }else {
            System.out.printf("opción no valida ejecuta de nuevo el programa y elige bien.");
        }
        sc.close();

    }

    public void ejecucionPB(int peticiones, String ruta) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("CMD","/C","ping", "-n", Integer.toString(peticiones), "www.google.com");
        File salida = new File(ruta,"/Documents/salidaPing.txt");
        pb.redirectOutput(salida);

        pb.start();
    }

    public void ejecucionRT(int peticiones, String ruta) {
        Runtime r=Runtime.getRuntime();

        String comando = "CMD /C ping -n "+ peticiones + " www.google.com";
        File salida2 = new File(ruta,"/Documents/salidaPing2.txt");
        try {

            FileOutputStream fos = new FileOutputStream(salida2);
            PrintWriter pw = new PrintWriter(fos);

            Process p = r.exec(comando);

            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea;

            while((linea = br.readLine()) !=null){

                System.out.println(linea);

                pw.println(linea);

            }

            br.close();

            pw.close();

        }catch (Exception e) {

            e.printStackTrace();

        }
    }
}
