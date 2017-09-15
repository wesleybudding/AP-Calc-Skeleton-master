/**
 * Created by lucasfaijdherbe on 15-09-17.
 */
public class TokenStack implements  TokenStackInterface {

    private Token[] stack;
    private int top;

    TokenStack(){
        stack = new Token[1000000];
        top = 0;
    }

    public void push(Token token) {
        stack[top] = token;
        top++;
    }

    public Token pop() {
        return null;
    }

    public Token top() {
        return null;
    }

    public int size() {
        return 0;
    }
}
