package Act3_8;

import java.io.*;
import java.io.IOException;
import java.net.*;

public class Servidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] sendData = new byte[1024];
        byte[] recibos = new byte[1024];

        byte[] buffer = new byte[1024];

        DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
        serverSocket.receive(paquete);

        //Deserialización del objeto recibido
        ByteArrayInputStream bais = new ByteArrayInputStream(paquete.getData());
        ObjectInputStream ois = new ObjectInputStream(bais);

        Persona dato = (Persona) ois.readObject();
        System.out.println("Recibo: "+dato.getNombre()+", "+dato.getEdad());

        //Modificación del objeto recibido

        int edad2 = dato.getEdad()*2;
        String nom2 = dato.getNombre().toUpperCase();
        dato.setNombre(nom2);
        dato.setEdad(edad2);

        //Serialización de objeto a bytes
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        //Envío del objeto
        oos.writeObject(dato);
        byte[] buffer2 = baos.toByteArray();

        //Creación del paquete a enviar
        InetAddress direccion = paquete.getAddress();
        int puerto = paquete.getPort();
        DatagramPacket paquete2 = new DatagramPacket(buffer2, buffer2.length, direccion, puerto);


        //Envío del paquete
        serverSocket.send(paquete2);
        System.out.println("Envio: "+dato.getNombre()+", "+dato.getEdad());

        // CERRAR STREAMS
        oos.close();
        baos.close();
        ois.close();
        bais.close();
    }


}
