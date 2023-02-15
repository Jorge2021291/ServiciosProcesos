package Act3_8;



import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] arg) throws IOException, ClassNotFoundException {
        //DatagramSocket serverSocket = new DatagramSocket(9999);
        //BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];
        byte[] recibos = new byte[1024];

        Persona per = new Persona("pepe", 15);
        System.out.println("Envio: " + per.getNombre() + ", " + per.getEdad());

        //convierto a bytes al objeto
        //Serialización de objeto a bytes
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bs);
        out.writeObject(per);

        out.close();
        byte[] buffer = bs.toByteArray();

        DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, IPAddress, 9876);

       clientSocket.send(paquete);

        //recibo datagrama

        DatagramPacket paqRecibo = new DatagramPacket(recibos, recibos.length);
        clientSocket.receive(paqRecibo);

        //Deserialización del objeto recibido
        ByteArrayInputStream bais = new ByteArrayInputStream(paqRecibo.getData());
        ObjectInputStream ois = new ObjectInputStream(bais);

        //Obtención del objeto recibido
        Persona perMod = (Persona) ois.readObject();
        System.out.println("Recibo: "+perMod.getNombre()+", "+perMod.getEdad());



    out.close();
    bs.close();
    clientSocket.close();

    }

}
