package com.company;

public enum TokenType {
    // single char
    PLUS, EQUAL, SLASH, STAR,
    COMMA, DOT, MINUS, SEMICOLON,
    // pairs
    LEFT_PAREN, LEFT_BRACE,
    RIGHT_PAREN, RIGHT_BRACE,
    // double char
    EQUAL_EQUAL,

    // literals
    IDENTIFIER, STRING, NUMBER,

    // keywords
    PRINT, FUN, IF, RETURN,

    EOF,
}
