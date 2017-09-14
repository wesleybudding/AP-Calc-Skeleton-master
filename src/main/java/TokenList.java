/**
 * Created by wesleybudding on 13/09/2017.
 */
public class TokenList implements TokenList_interface {

    private Token[] array;
    private int top = 0;

    TokenList(){
        array = new Token[100000000];
    }

    public void add(Token token) {
        array[top] = token;
        top++;
    }

    public void remove(int index) {
        if (withinRange(index)) {
            for (int i = index; i < --top; i++) {
                array[i] = array[i + 1];
            }
        }
        else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void set(int index, Token token) {
        if (withinRange(index)){
            for(int i = ++top; i > index; i++){
                array[i] = array[i - 1];
            }
            array[index] = token;
        }
    }

    public Token get(int index) {
        if (withinRange(index)){
            return array[index];
        }
        return null;
    }

    public int size() {
        return top-1;
    }

    boolean withinRange(int i){
        return i <= top && i >= 0;
    }

}
