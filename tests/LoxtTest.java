package tests.tests;

import com.company.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class LoxtTest {

    @org.junit.jupiter.api.Test
    void testPlus() {
        String source = "+";
        Scanner s = new Scanner(source);
        var tokens = s.scanTokens();
        var first = tokens.get(0);
        System.out.println(source + " => " + first);
        assertEquals(first.toString(), "PLUS + 1");
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        String source = "==";
        Scanner s = new Scanner(source);
        var tokens = s.scanTokens();
        var first = tokens.get(0);
        System.out.println(source + " => " + first);
        assertEquals(first.toString(), "EQUAL_EQUAL == 1");
    }

    @org.junit.jupiter.api.Test
    void testSlash() {
        String source = "/";
        Scanner s = new Scanner(source);
        var tokens = s.scanTokens();
        var first = tokens.get(0);
        System.out.println(source + " => " + first);
        assertEquals(first.toString(), "SLASH / 1");
    }

    @org.junit.jupiter.api.Test
    void testComment() {
        String source = "// ";
        Scanner s = new Scanner(source);
        var tokens = s.scanTokens();
        var first = tokens.get(0);
        System.out.println(source + " => " + first);
        assertEquals(first.toString(), "EOF  1");
    }

    @org.junit.jupiter.api.Test
    void testNewLine() {
        String source = "\n";
        Scanner s = new Scanner(source);
        var tokens = s.scanTokens();
        var first = tokens.get(0);
        System.out.println(source + " => " + first);
        assertEquals(first.toString(), "EOF  2");
    }

    @org.junit.jupiter.api.Test
    void testSpace() {
        String source = " \t\r\n";
        Scanner s = new Scanner(source);
        var tokens = s.scanTokens();
        var first = tokens.get(0);
        System.out.println(source + " => " + first);
        assertEquals(first.toString(), "EOF  2");
    }
    @org.junit.jupiter.api.Test
    void testParen() {
        String source = "()";
        Scanner s = new Scanner(source);
        var tokens = s.scanTokens();
        var first = tokens.get(0);
        var next = tokens.get(1);
        System.out.println(source + " => " + first);
        assertEquals(first.toString(), "LEFT_PAREN ( 1");
        assertEquals(next.toString(), "RIGHT_PAREN ) 1");
    }

    @org.junit.jupiter.api.Test
    void testUnexpectedChar() {
        String source = "?";
        Scanner s = new Scanner(source);
        var tokens = s.scanTokens();
        var first = tokens.get(0);
        System.out.println(source + " => " + first);
        assertEquals(first.toString(), "EOF  1");
    }

    @org.junit.jupiter.api.Test
    void testStringLiteral() {
        String source = "\"dog\"";
        Scanner s = new Scanner(source);
        var tokens = s.scanTokens();
        var first = tokens.get(0);
        System.out.println(source + " => " + first);
        assertEquals(first.toString(), "STRING \"dog\" 1");
    }

    @org.junit.jupiter.api.Test
    void testSymbolSoup() {
        String source = "( ) { } , . - ; *";
        Scanner s = new Scanner(source);
        var tokens = s.scanTokens();
        var tok = tokens.get(0);

        assertEquals(tok.toString(), "LEFT_PAREN ( 1");
        tok = tokens.get(1);
        assertEquals(tok.toString(), "RIGHT_PAREN ) 1");
        tok = tokens.get(2);
        assertEquals(tok.toString(), "LEFT_BRACE { 1");
        tok = tokens.get(3);
        assertEquals(tok.toString(), "RIGHT_BRACE } 1");
        tok = tokens.get(4);
        assertEquals(tok.toString(), "COMMA , 1");
        tok = tokens.get(5);
        assertEquals(tok.toString(), "DOT . 1");
        tok = tokens.get(6);
        assertEquals(tok.toString(), "MINUS - 1");
        tok = tokens.get(7);
        assertEquals(tok.toString(), "SEMICOLON ; 1");
        tok = tokens.get(8);
        assertEquals(tok.toString(), "STAR * 1");
    }

    @org.junit.jupiter.api.Test
    void testNumberLiteral() {
        String source = "123 3.14";
        Scanner s = new Scanner(source);
        var tokens = s.scanTokens();
        var first = tokens.get(0);
        var next = tokens.get(1);
        System.out.println(source + " => " + first);
        assertEquals(first.toString(), "NUMBER 123 1");
        assertEquals(next.toString(), "NUMBER 3.14 1");
    }

    // TODO 4.6.2 https://craftinginterpreters.com/scanning.html#number-literals
}