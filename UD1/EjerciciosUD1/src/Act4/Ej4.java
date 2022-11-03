package Act4;

import java.io.File;
import java.io.IOException;

public class Ej4 {

    public static void main(String[] args) throws IOException {
        try {
            ProcessBuilder pb = new ProcessBuilder(new String[]{"CMD"});
            File fichero = new File("d:\\Users\\JorgeYu\\Documents\\ServiciosProcesos\\ACTS\\ACt4\\Act04\\NUEVO\\fichero.bat");
            File fOut = new File("d:\\Users\\JorgeYu\\Documents\\ServiciosProcesos\\ACTS\\ACt4\\Act04\\NUEVO\\salida.txt");
            File fErr = new File("d:\\Users\\JorgeYu\\Documents\\ServiciosProcesos\\ACTS\\ACt4\\Act04\\NUEVO\\error.txt");
            pb.redirectInput(fichero);
            pb.redirectOutput(fOut);
            pb.redirectError(fErr);
            pb.start();
        } catch (Exception var5) {
            throw new RuntimeException(var5);
        }
    }
}
