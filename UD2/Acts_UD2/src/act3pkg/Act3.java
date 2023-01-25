package act3pkg;


public class Act3 {
    public static void main(String[] args) {
        HiloControlador h1 = new HiloControlador();
        h1.start();



    }

}



class Monitor{
    private int temperatura = 0;
    private int humedad = 0;
    private int turno = 0;
    private int contador = 0;



    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public int getHumedad() {
        return humedad;
    }

    public void setHumedad(int humedad) {
        this.humedad = humedad;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}

class HiloSensortemp extends Thread{

    private Monitor monitor;

    public HiloSensortemp(String temperatura, Monitor monitor) {
        super(temperatura);
        this.monitor = monitor;



    }
    @Override
    public void run() {
        synchronized (monitor){
            monitor.setTemperatura((int)(Math.random()*50));

        }


    }


}






class HiloSensorHumedad extends Thread{
    private Monitor monitor;

    public HiloSensorHumedad(String nombre, Monitor monitor) {
        super(nombre);
        this.monitor = monitor;
    }

    @Override
    public void run() {
        synchronized (monitor){
            monitor.setHumedad((int)(Math.random()*50));

        }


    }

}


class HiloControlador extends Thread{
    Monitor monitor = new Monitor();


    @Override
    public void run() {
        synchronized (monitor){

//            while (monitor.getTurno() == 0){
//
//                }

            HiloSensorHumedad humedad = new HiloSensorHumedad("humedad", monitor);
            HiloSensortemp temperatura = new HiloSensortemp("temperatura", monitor);
            System.out.println("---------------------------");
            System.out.println("Temperatura: " + monitor.getTemperatura());
            System.out.println("Humedad: " + monitor.getHumedad());

            if(monitor.getHumedad() > 40 && monitor.getTemperatura() > 25){
                System.out.println("Hace Calor");

            }else {
                System.out.println("Hace Frio");
            }
            }


        }
    }



