/**
 * Created by lucasfaijdherbe on 13-09-17.
 */
public abstract class Token implements TokenInterface {

    static final int    NUMBER_TYPE = 1,
            OPERATOR_TYPE = 2,
            PARENTHESIS_TYPE = 3;


    int tokenType;
    String token;

    Token(String token){
        this.token = token;
    }

    public String getValue() {
        return null;
    }

    public int getType() {
        return tokenType;
    }

    public int getPrecedence() {
        return 0;
    }
}
