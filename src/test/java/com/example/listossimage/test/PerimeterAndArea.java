package com.example.listossimage.test;

public class PerimeterAndArea {
    private float l;//长
    private float w;//宽
    private float h;//高
    public PerimeterAndArea(){

    }

    public PerimeterAndArea(float l) {
        this.l = l;
        square();
    }

    public PerimeterAndArea(float l, float w) {
        this.l = l;
        this.w = w;
        rectangle();
    }

    public PerimeterAndArea(float l, float w, float h) {
        this.l = l;
        this.w = w;
        this.h = h;
        quadrilateral();
    }

    private void square() {
        System.out.println("正方形的面积是：" + l * l);
        System.out.println("正方形的周长是：" + l * 4);
    }

    private void rectangle() {
        System.out.println("长方形的面积是：" + l * w);
        System.out.println("长方形的周长是：" + (l + w) * 2);
    }
    private void quadrilateral() {
        System.out.println("四边形的面积是：" + l * h);
        System.out.println("四边形的周长是：" + (l + w) * 2);
    }
}
