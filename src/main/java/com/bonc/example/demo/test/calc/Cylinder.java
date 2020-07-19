package com.bonc.example.demo.test.calc;

import com.bonc.example.demo.test.ThreeDimensionalGraphics;

/**
 * @Description 圆柱的表面积和体积
 */
public class Cylinder extends ThreeDimensionalGraphics {

    //圆柱底面半径
    private double R;
    //圆柱高
    private double H;
    //表面积
    private double superficialArea;
    //体积
    private double volume;

    @Override
    public void calculateSuperficialArea(double... args) {
        this.R = args[0];
        this.H = args[1];
        this.superficialArea = 2*Math.PI*R*R+2*Math.PI*R*H;
    }

    @Override
    public void calculateVolume(double... args) {
        this.R = args[0];
        this.H = args[1];
        this.volume = Math.PI * R * R * H;
    }

    @Override
    public String print() {
        return "当前为Cylinder \n" +
                "R=" + R +
                "\nH=" + H +
                "\nsuperficialArea=" + superficialArea +
                "\nvolume=" + volume;
    }

    public static void main(String[] args) {
        double R = 1.0f;
        double H = 2.0f;
        Cylinder cylinder = new Cylinder();
        cylinder.calculateSuperficialArea(R,H);
        cylinder.calculateVolume(R,H);
        System.out.println(cylinder.print());
        //当前为Cylinder
        //R=1.0
        //H=2.0
        //superficialArea=18.84955592153876
        //volume=6.283185307179586
    }
}
