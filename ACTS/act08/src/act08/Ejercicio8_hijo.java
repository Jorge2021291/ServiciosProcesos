package act08;


public class Ejercicio8_hijo {

        public static void main(String[] args) {

            double resultado=0;
            for (int i=0; i<args.length; i++) {
                int valor;
                valor = Integer.parseInt(args[i]);
                resultado=(resultado+valor);
            }

            System.out.println("La media de todos los numeros son:  "+ resultado/args.length);



        }
    }


