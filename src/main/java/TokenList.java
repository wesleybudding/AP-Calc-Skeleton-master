/**
 * Created by wesleybudding on 13/09/2017.
 */
public class TokenList implements TokenList_interface {

    private Token[] array;
    private int top;
    private int arraySize;

    TokenList(){
        top = 0;
        arraySize = 50;
        array = new Token[arraySize];
    }

    public void add(Token token) {
        if (top < arraySize){
            array[top] = token;
            top++;
        }
        else{
            enlargeArray();
        }
    }

    private void enlargeArray(){
        Token[] copyArray = new Token[arraySize];
        for(int i = 0; i < arraySize; i++){
            copyArray[i] = array[i];
        }
        array = new Token[arraySize *=2];

        for(int i = 0; i < copyArray.length; i++){
            array[i] = copyArray[i];
        }
    }

    public void remove(int index) {
        if (withinRange(index)) {
            for (int i = index; i < --top; i++) {
                array[i] = array[i + 1];
            }
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
        return i <= arraySize && i >= 0;
    }

}
