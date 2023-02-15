package ACT3_7_OG;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        int numeroPuerto = 6000;// Puerto
        boolean test = true;
        ServerSocket servidor =  new ServerSocket(numeroPuerto);
        System.out.println("Esperando al cliente.....");

        while(test){
            Socket cliente = servidor.accept();
            ObjectInputStream inObjeto = new ObjectInputStream(
                    cliente.getInputStream());
            ACT3_7_OG.Numeros numReci = (ACT3_7_OG.Numeros) inObjeto.readObject();
            System.out.println("Recibo: " + numReci.getNumero());
            if(numReci.getNumero() <= 0){
                test = false;
            }
            else{


                ACT3_7_OG.Numeros numEnvi = new Numeros(numReci.getNumero(),(long) Math.pow(numReci.getNumero(), 2) , (long)Math.pow(numReci.getNumero(), 3));
                ObjectOutputStream outObjeto = new ObjectOutputStream(
                        cliente.getOutputStream());

                outObjeto.writeObject(numEnvi); //enviando objeto
                System.out.println("Envio: " + numEnvi.getNumero() + ", " + numEnvi.getCuadrado() + ", " + numEnvi.getCubo());

                outObjeto.close();
                inObjeto.close();
                cliente.close();
            }
        }
        servidor.close();
    }
}