package com.bonc.example.demo.test.calc;

import com.bonc.example.demo.test.ThreeDimensionalGraphics;

/**
 * @Description 球的表面积和体积
 */
public class Ball extends ThreeDimensionalGraphics {

    private double R;
    //表面积
    private double superficialArea;
    //体积
    private double volume;

    @Override
    public void calculateSuperficialArea(double... args) {
        //球的半径
        this.R = args[0];
        this.superficialArea = 4 * Math.PI * R * R;
    }

    @Override
    public void calculateVolume(double... args) {
        //球的半径
        this.R = args[0];
        this.volume = (4.0 * Math.PI * R * R * R) / 3;
    }

    @Override
    public String print() {
        return "当前为Ball \n" +
                "R=" + R +
                "\nsuperficialArea=" + superficialArea +
                "\nvolume=" + volume;
    }

    public static void main(String[] args) {
        double R = 2.0f;
        Ball ball = new Ball();
        ball.calculateSuperficialArea(R);
        ball.calculateVolume(R);
        System.out.println(ball.print());
        //当前为Ball
        //R=2.0
        //superficialArea=50.26548245743669
        //volume=33.510321638291124
    }
}
