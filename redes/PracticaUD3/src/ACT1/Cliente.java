package ACT1;

import java.io.*;
import java.net.*;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] arg) throws IOException {
        String Host = "localhost";
        int Puerto = 12345;
        String NumBase = null;

        Scanner sc = new Scanner(System.in);

        System.out.println("PROGRAMA CLIENTE INICIADO....");
        Socket Cliente = new Socket(Host, Puerto);

        System.out.println("#################### Calculadora Naútica #################### + " +
                "'Sintaxis: operando operador operando. Operadores: + - * /. Ejemplo: 5 + 5' ");

        while (NumBase != "close") {
            System.out.println("¿Qué necesita calcular?: ");
            NumBase = sc.nextLine();
            System.out.println(NumBase);

            while (true) {
                String[] NumFin = NumBase.split(" ");
                if (NumFin.length != 3) {
                    System.out.println(NumFin.length);
                    System.out.println("Tiene que tener este formato [1 + 4]");
                    System.out.println("Introduce la operacion bien: ");
                    NumBase = sc.nextLine();
                } else {
                    String regexOperand = "-?\\d+(\\.\\d+)?"; // allows integer or decimal operands
                    String regexOperator = "[+\\-*/]";

                    if (!NumFin[0].matches(regexOperand) || !NumFin[1].matches(regexOperator) || !NumFin[2].matches(regexOperand)) {
                        System.out.println("Tiene que tener este formatooo [1 + 5]");
                        System.out.println("Introduce la operacion bien: ");
                        NumBase = sc.nextLine();
                    } else {
                        DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());
                        flujoSalida.writeUTF(NumBase);
                        System.out.println("Se ha enviado " + NumBase);

                        DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());

                        // EL SERVIDOR ME ENVIA UN MENSAJE
                        System.out.println("Recibiendo del SERVIDOR: \n\t" +
                                flujoEntrada.readUTF());

                        // CERRAR STREAMS
                        flujoSalida.close();
                        flujoEntrada.close();
                        break;
                    }
                }
            }
        }

        // CERRAR SOCKET
        Cliente.close();
    }
}


