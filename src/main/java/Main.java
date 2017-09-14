import java.util.Scanner;

public class Main implements CalculatorInterface {

    public TokenList readTokens(String input) {
        Scanner in = new Scanner(input);
        TokenList result = new TokenList();

        while(in.hasNext()){
            String currentToken = in.next();
            if(nextTokenIsDouble(currentToken)){
                result.add(parseNumber(currentToken));
            }
            else if(nextTokenIsOperator(currentToken)){
                result.add(parseOperator(currentToken));
            }
            else if(nextTokenIsParentheses(currentToken)){
                result.add(parseParentheses(currentToken));
            }
            else{
                System.err.println("error");
                System.exit(0);
            }
        }
        return null;
    }

    private boolean nextTokenIsDouble(String token) {
        Scanner in = new Scanner(token);
        return in.hasNextDouble();
    }

    private boolean nextTokenIsOperator(String token) {
        return token.matches("[-+*/^]");

    }

    private boolean nextTokenIsParentheses(String token) {
        return token.matches("[()]");
    }

    private Token parseNumber(String token){
        Token t = new Token(token,1,-1);
        return t;
    }

    private Token parseOperator(String token){
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

    private Token parseParentheses(String token){
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

    private String read(){
        Scanner in = new Scanner(System.in);
        String result = in.nextLine();
        return result;
    }

    private void start() {
        System.out.println("enter formula:");
        String formula = read();
        readTokens(formula);
    }

    public static void main(String[] argv) {
        new Main().start();
    }
}
