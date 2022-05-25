package tests.tests;

import com.company.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class LoxtTest {

    @org.junit.jupiter.api.Test
    void testPlus() {
        Scanner s = new Scanner("+");
        var tokens = s.scanTokens();
        var first = tokens.get(0);
        System.out.println("first = " + first);
        //return (first.type==TokenType.PLUS);
        assertEquals(first.toString(), "PLUS + 1");
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        Scanner s = new Scanner("==");
        var tokens = s.scanTokens();
        var first = tokens.get(0);
        System.out.println("first = " + first);
        assertEquals(first.toString(), "EQUAL_EQUAL == 1");
    }
}