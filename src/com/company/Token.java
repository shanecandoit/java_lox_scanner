package com.company;

public class Token {

    final TokenType type;
    final String lexeme;
    final int line;
    final Object literal;

    public Token(TokenType tokenType, String lexeme, Object literal, int line ){
        this.type=tokenType;
        this.lexeme=lexeme;
        this.line=line;
        this.literal = literal;
    }

    public String toString() {
        return "" + type+" "+lexeme+" "+line;
    }
}
