package com.example.listossimage.test;

public class Father {
    private float l = 0;//长
    private float w = 0;//宽
    private float h = 0;//高

    public Father(float l) {
        this.l = l;
        this.w = l;
        this.h = l;
    }

    public Father(float l, float w) {
        this.l = l;
        this.w = w;
        this.h = w;
    }

    public Father(float l, float w, float h) {
        this.l = l;
        this.w = w;
        this.h = h;
    }

    //求面积
    public float area () {
        return this.l * this.h;
    }

    //求周长
    public float perimeter() {
        return (this.l + this.w) * 2;
    }
}
