package Act3_6;

import java.net.*;

public class UDPServer {
    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            System.out.println("Recibido: " + sentence);
            if (sentence.equals("*")) {
                break;
            }
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            sentence = sentence.toUpperCase();
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
        serverSocket.close();
    }
}