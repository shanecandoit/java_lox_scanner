package com.company;

public enum TokenType {
    // single char
    PLUS, EQUAL,
    // double char
    EQUAL_EQUAL,

    // literals
    IDENTIFIER, STRING, NUMBER,

    // keywords
    PRINT, FUN, IF, RETURN,

    EOF,
}
