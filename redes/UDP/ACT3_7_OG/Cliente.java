package ACT3_7_OG;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] arg) throws IOException,
            ClassNotFoundException {
        String Host = "localhost";
        int Puerto = 6000;//puerto remoto
        int NumBase = 1;
        boolean test = true;

        Scanner sc = new Scanner(System.in);

        System.out.println("PROGRAMA CLIENTE INICIADO....");


        while(test){
            Socket cliente = null;

            cliente = new Socket(Host, Puerto);
            ObjectOutputStream outObjeto = new ObjectOutputStream(
                    cliente.getOutputStream());

            System.out.print("Introduce el numero: ");

            NumBase = sc.nextInt();
            if (NumBase <= 0) {
                ACT3_7_OG.Numeros num = new ACT3_7_OG.Numeros(NumBase, 0, 0);
                outObjeto.writeObject(num); //enviando objeto
                System.out.println("Envio: " + num.getNumero());
                test = false;
            }
            else{
                ACT3_7_OG.Numeros num = new ACT3_7_OG.Numeros(NumBase, 0, 0);
                outObjeto.writeObject(num); //enviando objeto
                System.out.println("Envio: " + num.getNumero());


                ObjectInputStream inObjeto = new ObjectInputStream(
                        cliente.getInputStream());
                ACT3_7_OG.Numeros numReci = (Numeros) inObjeto.readObject();

                System.out.println("Recibo: " + numReci.getNumero() + ", " + numReci.getCuadrado() + ", " + numReci.getCubo());

                outObjeto.close();
                inObjeto.close();
                cliente.close();
            }



        }





    }

}
