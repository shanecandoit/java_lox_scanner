package com.company;

public class Loxt {
    public static void main(String[] args) {

        System.out.println("Loxt");
    }

    public static void error(int line, String message) {
        System.err.println("["+line+"] Error: "+message);
    }
}
