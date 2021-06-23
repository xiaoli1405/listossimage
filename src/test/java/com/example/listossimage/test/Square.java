package com.example.listossimage.test;

/**
 * 正方形
 */
public class Square extends Father{

    public Square(float l) {
        super(l);
    }

    public static void main(String[] args) {
        Square square = new Square(1);
        System.out.println("正方形的面积是：" + square.area());
        System.out.println("正方形的周长是：" + square.perimeter());

    }
}
