/**
 * @elements Tokens of the type TokenInterface
 * @structure linear
 * @domain all rows of tokens
 **/
public interface TokenStack {

    /**
     * @pre -
     * @post token TokenInterface is now at the top of the stack.
     */
    void push(TokenInterface token);

    /**
     * @pre The stack is not empty
     * @post The token at the top of the stack is returned and deleted.
     */
    TokenInterface pop();

    /**
     * @pre The stack is not empty
     * @post The token at the top of the stack is returned.
     */
    TokenInterface top();

    /**
     * @pre -
     * @post The number of elements on the stack is returned
     */
    int size();
}
