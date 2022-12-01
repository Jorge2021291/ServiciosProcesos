package MostruoGalletas;

public class Ejercicio1 extends Thread {
    public static void main(String[] args) {
        Almacen almacen = new Almacen();

        Monstruo m1 = new Monstruo("Monstruo 1", almacen);
        Monstruo m2 = new Monstruo("Monstruo 2", almacen);
        Monstruo m3 = new Monstruo("Monstruo 3", almacen);
        Guardian g = new Guardian(almacen);

        System.out.println("El almacen tiene: " + almacen.getGalletas() + " galletas");

        m1.start();
        m2.start();
        m3.start();
        g.start();



    }

}


class Monstruo extends Thread{
    private final String nombre;
    private Almacen galletas;

    public Monstruo(String nombre, Almacen galletas){
        this.nombre = nombre;
        this.galletas = galletas;


    }

    @Override
    public void run() {
        synchronized (galletas){



            while (galletas.getTotal() < 100){

                while (galletas.getGalletas() == 0){
                    if(galletas.getTotal() == 100){
                        break;

                    }
                    try {
                        galletas.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                int nGalletas = galletas.getGalletas();
                int comer = (int) (Math.random()*(10)+1);
                int total = galletas.getTotal();

                if(comer <= nGalletas){
                    galletas.setGalletas(nGalletas - comer);
                    galletas.setTotal(total + comer);
                } else{
                    galletas.setTotal(total + galletas.getGalletas());
                    galletas.setGalletas(0);
                    if(total == 100){
                        break;
                    }
                }
                System.out.println("El " + nombre +  " come: " + comer + " Galletas" + ".  Total Galletas robadas: " + galletas.getTotal());
                System.out.println("quedan: " + galletas.getGalletas() + " Galletas");
                System.out.println("--------------------------------------------");
                galletas.notifyAll();


            }





        }
    }
}

class Guardian extends Thread{
    private Almacen galletas;

    public Guardian(Almacen galletas){
        this.galletas = galletas;


    }

    @Override
    public void run() {
        synchronized (galletas){



            while (galletas.getTotal() < 100){
                while (galletas.getGalletas() > 0){
                    try {
                        galletas.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                int nGalletas = galletas.getGalletas();
                int nCont = galletas.getContador();

                while (nCont < 9){

                    if(nGalletas == 0){
                        galletas.setGalletas(10);
                        galletas.setContador(nCont += 1);

                        System.out.println("No hay galletas!, Guardian repone 10 galletas");
                        System.out.println("--------------------------------------------");
                        galletas.notifyAll();



                    }

                    break;



                }




            }





        }
    }
}

class Almacen {
    private int Galletas;
    private int contador;
    private int total;



    public Almacen(){
        this.Galletas = 10;
        this.contador = 0;
        this.total = 0;

    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getGalletas() {
        return Galletas;
    }

    public void setGalletas(int galletas) {
        Galletas = galletas;
    }
}
