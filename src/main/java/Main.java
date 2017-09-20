import java.util.Scanner;

public class Main implements CalculatorInterface {

    public TokenList readTokens(String input) {
        Scanner in = new Scanner(input);
        TokenList result = new TokenList();

        int openParenthesesCounter = 0;
        int closeParenthesesCounter = 0;

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

                if (currentToken.equals("(")){
                    openParenthesesCounter++;
                } else if (currentToken.equals(")")){
                    closeParenthesesCounter++;
                }
            }
            else{
                System.err.println("Error: Invalid input. Make sure you separate all input with whitespaces, and you only input numbers, operators ( + - * / ^) and parentheses.");
                System.exit(1);
            }
        }

        if (openParenthesesCounter != closeParenthesesCounter){
            System.out.println("Incorrect use of parentheses. Make sure you use both and opening and closing parenthesis.");
            System.exit(1);
        }
        
        return result;
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
        return new Token(token,1,-1);
    }

    private Token parseOperator(String token){
        if (token.matches("[-+]")){
            return new Token(token,2,1);
        }
        else if (token.matches("[*/]")){
            return new Token(token,2,2);
        }
        else{
            return new Token(token,2,3);
        }
    }

    private Token parseParentheses(String token){
        return new Token(token,3,-1);
    }

    public Double rpn(TokenList input) {

        Stack stack_rpn = new Stack();
        double finalResult = Double.parseDouble(input.get(0).getValue());

        for (int i = 0; i < input.size(); i++){
            switch(input.get(i).getValue()){
                case "+":
                    finalResult = stack_rpn.pop() + stack_rpn.pop();
                    stack_rpn.push(finalResult);
                    break;
                case "-":
                    finalResult = -stack_rpn.pop() + stack_rpn.pop();
                    stack_rpn.push(finalResult);
                    break;
                case "*":
                    finalResult = stack_rpn.pop() * stack_rpn.pop();
                    stack_rpn.push(finalResult);
                    break;
                case "/":
                    double divisor = stack_rpn.pop();
                    finalResult =  stack_rpn.pop() / divisor;
                    stack_rpn.push(finalResult);
                    break;
                case "^":
                    double power = stack_rpn.pop();
                    finalResult = stack_rpn.pop();
                    double value = finalResult;
                    if(power==0){
                        finalResult=1;
                    }
                    while(power>1){
                        finalResult = finalResult*value;
                        power--;
                    }
                    stack_rpn.push(finalResult);
                    break;
                default :
                    stack_rpn.push(Double.parseDouble(input.get(i).getValue()));
                    break;
            }
        }

        return finalResult;
    }

    public TokenList shuntingYard(TokenList tokens) {
        TokenList output = new TokenList();
        TokenStack stack = new TokenStack();

        for(int i = 0; i < tokens.size(); i++){
            Token t = tokens.get(i);
            if(t.getType() == 1){
                output.add(t);
            }
            else if (t.getType() == 2){
                while (stack.top().getPrecedence() >= t.getPrecedence()){
                    output.add(stack.pop());
                }
                stack.push(t);
            }
            else if (t.getType() == 3){
                if(t.getValue().equals("(")){
                    stack.push(t);
                }
                else if (t.getValue().equals(")")){
                    while(!stack.top().getValue().equals("(")){
                        output.add(stack.pop());
                    }
                    stack.pop();
                }
            }
        }

        while (stack.size() != 0) {
            output.add(stack.pop());
        }

        return output;
    }

    private void start() {
        System.out.println("enter formula: - enter Q to exit");

        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
                String formula = in.nextLine();
                if(formula.toUpperCase().equals("Q")) {
                    System.exit(0);
                } else{
                    Double result = rpn(shuntingYard(readTokens(formula)));
                    System.out.println(result);
                }
        }
        System.exit(0);
    }

    public static void main(String[] argv) {
        new Main().start();
    }
}