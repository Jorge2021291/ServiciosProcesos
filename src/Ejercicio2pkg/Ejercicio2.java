package Ejercicio2pkg;

public class Ejercicio2 extends Thread{
    public static void main(String[] args) throws InterruptedException {

        numeros num = new numeros();

        suma Hilo1 = new suma("Hilo 1", num);
        resta Hilo2 = new resta("Hilo 2", num);

        Hilo1.start();
        Hilo2.start();





    }

}


class resta extends Thread {

    private numeros num;
    private String nombre;

    public resta(String nombre, numeros num) {
        this.nombre = nombre;
        this.num = num;
    }

    @Override
    public void run() {
        synchronized (num) {
            while (num.getResta() >= 1){

                while (num.getTurno() != 2) {
                    try {
                        num.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                    int totalRes = num.getResta();
                    num.setResta(totalRes - 1);
                    System.out.println("  \t" + nombre + ": " + totalRes);
                    num.setTurno(1);
                    num.notifyAll();





            }

        }
    }
}

class suma extends Thread {
    private numeros num;
    private String nombre;

    public suma(String nombre, numeros num) {
        this.nombre = nombre;
        this.num = num;
    }


    @Override
    public void run() {

        synchronized (num) {

            while (num.getSuma() <= 100) {
                int totalSum = num.getSuma();
                while (num.getTurno() != 1) {
                    try {
                        num.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                num.setSuma(totalSum + 1);
                System.out.println(nombre + ": " + totalSum);
                num.setTurno(2);

                num.notifyAll();
            }
        }
    }
}




class numeros {
    private int suma;
    private int resta;
    private  int turno;

    public numeros() {
        this.suma = 1;
        this.resta = 100;
        this.turno = 1;
    }


    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public int getResta() {
        return resta;
    }

    public void setResta(int resta) {
        this.resta = resta;
    }
}
