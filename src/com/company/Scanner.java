package com.company;

import java.util.ArrayList;
import java.util.List;

import static com.company.TokenType.EOF;
import static com.company.TokenType.PLUS;

public class Scanner {

    private final String source;
    private final List<Token> tokens = new ArrayList();

    private int start=0;
    private int current=0;
    private int line=1;

    public Scanner(String source){
        this.source=source;
    }

    public List<Token> scanTokens() {
        while (!isDone()) {
            start = current;
            scanToken();
        }
        tokens.add(new Token(EOF, "", null, line ));
        return tokens;
    }

    private boolean isDone() {
        return current>=source.length();
    }

    private void scanToken() {
        char c = advance();
        switch (c) {
            case '+': addToken(PLUS); break;
        }
    }

    private char advance() {
        char c= source.charAt(current);
        current++;
        return c;
    }

    private void addToken(TokenType type) {
        addToken(type, null);
    }

    private void addToken(TokenType type, Object literal) {
        String text = source.substring(start, current);
        tokens.add(new Token(type, text, literal, line));
    }
}
