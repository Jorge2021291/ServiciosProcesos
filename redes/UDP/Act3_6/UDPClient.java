package Act3_6;

import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String args[]) throws Exception {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        String sentence = "";
        clientSocket.setSoTimeout(5000);
        while (!sentence.equals("*")) {
            try {
                System.out.print("Introduzca una cadena: ");
                sentence = inFromUser.readLine();
                sendData = sentence.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
                clientSocket.send(sendPacket);
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);
                String modifiedSentence = new String(receivePacket.getData());
                System.out.println("Del servidor: " + modifiedSentence);
            } catch (InterruptedIOException e) {
                System.out.println("El paquete se ha perdido.");
            }
        }
        clientSocket.close();
    }
}