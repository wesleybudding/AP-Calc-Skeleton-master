import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main implements CalculatorInterface {

    boolean nextTokenIsDouble(String token) {
        Scanner in = new Scanner(token);
        return in.hasNextDouble();
    }

    public TokenList readTokens(String input) {
        if
        return null;
    }

    public Double rpn(TokenList tokens) {
        // TODO: Implement this
        return null;
    }

    public TokenList shuntingYard(TokenList tokens) {
        // TODO: Implement this
        return null;
    }

    String read(){
        Scanner in = new Scanner(System.in);
        String result = in.next();
        return result;
    }

    private void start() {
        System.out.println("enter formula:");
        String formula = read();
        System.out.println(formula);
        readTokens(formula);
    }

    public static void main(String[] argv) {
        new Main().start();
    }
}
