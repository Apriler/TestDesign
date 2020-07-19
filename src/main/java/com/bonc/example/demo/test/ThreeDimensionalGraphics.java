package com.bonc.example.demo.test;

/**
 * @Description 立体图形抽象类
 */
public abstract class ThreeDimensionalGraphics extends GeometricGraph{
    /**
     * 计算表面积
     * @return
     */
    public abstract void calculateSuperficialArea(double ... args);

    /**
     * 计算体积
     * @return
     */
    public abstract void calculateVolume(double ... args);
}
