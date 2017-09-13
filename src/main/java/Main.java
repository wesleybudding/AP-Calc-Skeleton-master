import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main implements CalculatorInterface {

    static final String OPERATOR_TOKENS = "-+*\\/^";

    boolean nextTokenIsDouble(String token) {
        Scanner in = new Scanner(token);
        return in.hasNextDouble();
    }

    boolean nextTokenIsOperator(String token) {
        System.out.println(token);
        System.out.println(token.matches("[OPERATOR_TOKENS]"));
        return true;
    }

    public TokenList readTokens(String input) {
        Scanner in = new Scanner(input);
        while(in.hasNext()){
            String currentToken = in.next();
            if(nextTokenIsDouble(currentToken)){
                System.out.println(currentToken);
            }
            else if(nextTokenIsOperator(currentToken)){
                System.out.println("");
            }
            else{
                System.out.println("parentesis");
            }

        }


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
        String result = in.nextLine();
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
