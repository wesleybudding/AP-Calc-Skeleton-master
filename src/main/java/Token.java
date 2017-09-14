/**
 * Created by lucasfaijdherbe on 13-09-17.
 */
public class Token implements TokenInterface {

    static final int    NUMBER_TYPE = 1,
            OPERATOR_TYPE = 2,
            PARENTHESIS_TYPE = 3;

    private int tokenType;
    private String value;
    private int type;
    private int precedence;

    Token(String token, int type, int precedence){
        this.value = token;
        this.type = type;
        this.precedence = precedence;
    }

    public String getValue() {
        return value;
    }

    public int getType() {
        return tokenType;
    }

    public int getPrecedence() {
        return precedence;
    }
}
