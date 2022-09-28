package UT1;


public class EJ2 {
    public static void main(String[] args) {
        try{
            String[] infoProceso =
                    {"java", "UT1.EJ1"};
            Process proceso = Runtime.getRuntime().exec(infoProceso);

            int valorRetorno = proceso.waitFor();
            if (valorRetorno==0){
                System.out.println("El proceso se ha completado satisfactoriamente");

            } else {
                System.out.println("El Proceso ha fallado. Código de error: " + valorRetorno);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
