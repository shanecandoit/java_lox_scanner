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
            case '(': addToken(LEFT_PAREN); break;
            case ')': addToken(RIGHT_PAREN); break;
            case '{': addToken(LEFT_BRACE); break;
            case '}': addToken(RIGHT_BRACE); break;
            case ',': addToken(COMMA); break;
            case '.': addToken(DOT); break;
            case '-': addToken(MINUS); break;
            case ';': addToken(SEMICOLON); break;
            case '*': addToken(STAR); break;
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
            case '"':
                // string literals
                string();
                break;
            default: Loxt.error(line, "Unexpected character.");
        }
    }

    private void string() {
        while (peek() != '"' && !isDone()) {
            if (peek() == '\n') {
                line++;
            }
            advance();
        }

        if (isDone()) {
            Loxt.error(line, "Unterminated string");
            return;
        }

        // the closing "
        advance();

        // trim quotes
        String value = source.substring(start+1,
                current-1);
        addToken(STRING, value);
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
