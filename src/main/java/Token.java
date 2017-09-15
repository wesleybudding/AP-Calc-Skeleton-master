/**
 * Created by lucasfaijdherbe on 13-09-17.
 */
public class Token implements TokenInterface {

    static final int    NUMBER_TYPE = 1,
            OPERATOR_TYPE = 2,
            PARENTHESIS_TYPE = 3;

    private String value;
    private int type;
    private int precedence;

    Token(String token, int type, int precedence){
        this.value = token;
        this.precedence = precedence;

        switch(type){
            case 1: this.type = NUMBER_TYPE;
            break;
            case 2: this.type = OPERATOR_TYPE;
            break;
            case 3: this.type = PARENTHESIS_TYPE;
            break;
        }
    }

    public String getValue() {
        return value;
    }

    public int getType() {
        return type;
    }

    public int getPrecedence() {
        return precedence;
    }
}
