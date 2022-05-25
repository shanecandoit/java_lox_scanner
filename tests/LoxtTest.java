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
}