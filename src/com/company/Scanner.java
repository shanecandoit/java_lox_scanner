package com.company;

import java.util.ArrayList;
import java.util.List;
import static com.company.TokenType.*;

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
            case '=':
                addToken(match('=') ? EQUAL_EQUAL : EQUAL);
                break;
            case '/':
                if (match('/')){
                    // comments run til end of line
                    while (peek() != '\n' && !isDone()) {
                        advance();
                    }
                }else{
                    addToken(SLASH);
                }
                break;
                // white space
            case ' ':
            case '\r':
            case '\t':
                break;
            case '\n':
                line++;
                break;
            default: Loxt.error(line, "Unexpected character.");
        }
    }

    private char peek() {
        if (isDone()) {
            return '\0';
        }
        return source.charAt(current);
    }

    private boolean match(char expected) {
        if (isDone()) {
            return false;
        }
        if (source.charAt(current)!=expected) {
            return false;
        }

        current++;
        return true;
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
