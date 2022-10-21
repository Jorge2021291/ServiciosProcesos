package UT1;

public class UnSaludo {

    public static void main(String[] args) {
// TODO Auto-generated method stub
        if(args.length ==0) {
            System.out.println("SE NECESITA UN SALUDO...");
            System.exit(1);
        }
        else {
            for (int i = 0; i < 5; i++) {
                System.out.println(i+1 + ". " + args[0]);
            }
            System.exit(0);
        }
    }

}