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

    // TODO https://craftinginterpreters.com/scanning.html#string-literals 4.6.1
}