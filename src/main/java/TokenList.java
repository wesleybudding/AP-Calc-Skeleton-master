/**
 * Created by wesleybudding on 13/09/2017.
 */
public class TokenList implements TokenList_interface {

    Token[] array;
    int top = 0;

    TokenList(){
        array = new Token[100000];
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
            return;  // ERROR
        }
    }

    public void set(int index, Token token) {
        if (withinRange(index)){

        }
    }

    public Token get(int index) {
        if (withinRange(index)){
            return array[index];
        }
        return null;
    }

    public int size() {
        return 0;
    }

    boolean withinRange(int i){
        return i <= top && i >= 0;
    }

}
