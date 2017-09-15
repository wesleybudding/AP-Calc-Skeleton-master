import java.util.EmptyStackException;

/**
 * Created by lucasfaijdherbe on 15-09-17.
 */
public class TokenStack implements  TokenStackInterface {

    private Token[] stack;
    private int top;
    private int stackSize;

    TokenStack(){
        top = 0;
        stackSize = 50;
        stack = new Token[stackSize];
    }

    public void push(Token token) {
        if (top < stackSize){
            stack[top] = token;
            top++;
        }
        else{
            enlargeStack();
        }
    }

    private void enlargeStack(){
        Token[] copyStack = new Token[stackSize];
        for(int i = 0; i < stackSize; i++){
            copyStack[i] = stack[i];
        }
        stack = new Token[stackSize *=2];

        for(int i = 0; i < copyStack.length; i++){
            stack[i] = copyStack[i];
        }
    }

    public Token pop() {
        if (top != 0){
            return stack[--top];
        } else{
            throw new EmptyStackException();
        }
    }

    public Token top() {
        if (top != 0){
            return stack[top - 1];
        } else{
            throw new EmptyStackException();
        }
    }

    public int size() {
        return top;
    }
}
