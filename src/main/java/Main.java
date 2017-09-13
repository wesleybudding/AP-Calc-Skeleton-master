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

    public TokenList readTokens(String input) {
        Scanner in = new Scanner(input);
        TokenList result = new TokenList(input.length());

        while(in.hasNext()){
            String currentToken = in.next();
            if(nextTokenIsDouble(currentToken)){
                result.add(parseNumber(currentToken));
            }
            else if(nextTokenIsOperator(currentToken)){
                result.add(parseOperator(currentToken));
            }
            else{
                result.add(parseParentheses(currentToken));
            }

        }
        return null;
    }

    Token parseNumber(String token){
        Token t = new Token(token,1,-1);
        return t;
    }

    Token parseOperator(String token){
        if (token.matches("[-+]")){
            Token t = new Token(token,2,1);
            return t;
        }
        else if (token.matches("[*/]")){
            Token t = new Token(token,2,2);
            return t;
        }
        else{
            Token t = new Token(token,2,3);
            return t;
        }
    }

    Token parseParentheses(String token){
        Token t = new Token(token,3,-1);
        return t;
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
