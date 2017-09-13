import java.util.Scanner;

public class Main implements CalculatorInterface {

    static final String OPERATOR_TOKENS = "-+*/^";

    boolean nextTokenIsDouble(String token) {
        Scanner in = new Scanner(token);
        return in.hasNextDouble();
    }

    boolean nextTokenIsOperator(String token) {
        System.out.println(token);
        return token.matches("[-+*/^]");

    }

    public TokenList_interface readTokens(String input) {
        Scanner in = new Scanner(input);
        TokenList_interface
        while(in.hasNext()){
            String currentToken = in.next();
            if(nextTokenIsDouble(currentToken)){
                System.out.println(currentToken);
            }
            else if(nextTokenIsOperator(currentToken)){
                System.out.println("opperator");
            }
            else{
                System.out.println("paren");
            }

        }


        return null;
    }

    public Double rpn(TokenList_interface tokens) {
        // TODO: Implement this
        return null;
    }

    public TokenList_interface shuntingYard(TokenList_interface tokens) {
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
