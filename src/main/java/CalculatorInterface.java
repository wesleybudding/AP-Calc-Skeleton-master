interface CalculatorInterface {

    /*
     * @param in String of tokens to be parsed
     * @return the list of arithmetic tokens from the String input
     */
    TokenList_interface readTokens(String input);

    /*
     * @param tokens A list of tokens signifying an RPN expression.
     * @return The result of the RPN expression.
     */
    Double rpn(TokenList_interface tokens);

    /*
     * @param tokens A list of tokens signifying an arithmetic expression.
     * @return The arithmetic expression tokens converted into
     * Reverse-Polish-Notation.
     */
    TokenList_interface shuntingYard(TokenList_interface tokens);
}
