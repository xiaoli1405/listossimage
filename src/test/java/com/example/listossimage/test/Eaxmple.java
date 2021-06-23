package com.example.listossimage.test;

public class Eaxmple {
    String string = new String("good");
    char[] chars = {'a', 'b', 'c'};

    public static void main(String[] args) {
        Eaxmple eaxmple = new Eaxmple();
        eaxmple.change(eaxmple.string, eaxmple.chars);
        System.out.print(eaxmple.string + "and");
        System.out.print(eaxmple.chars);
    }

    public void change(String s, char chars[]) {
        s  = "test ok";
        chars[0] = 'g';
    }

}
