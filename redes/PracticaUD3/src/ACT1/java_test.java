package ACT1;

public class java_test {
    public static void main(String[] args) {
        String NumBase = "1 + 2";
        String[] NumFin = NumBase.split(" ");
        System.out.println(NumFin.length);

        String regexOperand = "-?\\d+(\\.\\d+)?"; // allows integer or decimal operands
        String regexOperator = "[+\\-*/]";

        if (!NumFin[0].matches(regexOperand) || !NumFin[1].matches(regexOperator) || !NumFin[2].matches(regexOperand)) {
            System.out.println("Tiene que tener este formato [1 + 5]");

        } else {
            System.out.println("good");
        }

        }
}
