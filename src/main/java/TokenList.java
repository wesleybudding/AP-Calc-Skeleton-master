/**
 * Created by wesleybudding on 13/09/2017.
 */
public class TokenList implements TokenList_interface {

    Token[] array;

    TokenList(int length){
        array = new Token[length];
    }


    public void add(Token token) {
        System.out.println(token.value);
        System.out.println(token.type);
        System.out.println(token.precedence);
    }

    public void remove(int index) {

    }

    public void set(int index, Token token) {

    }

    public Token get(int index) {
        return null;
    }

    public int size() {
        return 0;
    }
}
