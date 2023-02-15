package ACT1;

import java.io.*;
import java.net.*;


public class Servidor {
    public static void main(String[] args) throws IOException {
        String Host = "localhost";
        int Puerto = 12345;
        ServerSocket serverSocket = new ServerSocket(Puerto);


        
        PrintWriter out = null;
        BufferedReader in = null;

        System.out.println("PROGRAMA SERVIDOR INICIADO....");
        Socket Cliente = new Socket(Host, Puerto);

        while (true) {

            Cliente = serverSocket.accept();
            System.out.println("Aceptado");


                InputStream entrada = null;
                entrada = Cliente.getInputStream();
                DataInputStream flujoEntrada = new DataInputStream(entrada);

                String NumClien = flujoEntrada.readUTF();

                // EL CLIENTE ME ENVIA UN MENSAJE
                System.out.println("Recibiendo del CLIENTE: \n\t" +
                        NumClien);


                OutputStream salida = null;
                DataOutputStream flujoSalida = null;
                while ((NumClien = in.readLine()) != null) {
                    String[] tokens = NumClien.split(" ");

                    double operand1 = Double.parseDouble(tokens[0]);
                    double operand2 = Double.parseDouble(tokens[2]);
                    double result;
                    switch (tokens[1]) {
                        case "+":
                            result = operand1 + operand2;
                            break;
                        case "-":
                            result = operand1 - operand2;
                            break;
                        case "*":
                            result = operand1 * operand2;
                            break;
                        case "/":
                            result = operand1 / operand2;
                            break;
                        default:
                            out.println("Invalid operator.");
                            continue;
                    }
                    
                    salida = Cliente.getOutputStream();
                    flujoSalida = new DataOutputStream(salida);

                    // ENVIO UN SALUDO AL CLIENTE
                    flujoSalida.writeUTF(String.valueOf(result));
                    out.println(result);
                }
                entrada.close();
                flujoEntrada.close();
                salida.close();
                flujoSalida.close();
                Cliente.close();
                Cliente.close();
            }
        }
    }
