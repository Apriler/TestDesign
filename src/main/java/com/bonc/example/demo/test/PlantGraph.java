package com.bonc.example.demo.test;

/**
 * @Description 平面图形抽象类
 */
public abstract class PlantGraph extends GeometricGraph{

    /**
     * 计算周长
     *
     * @return
     */
    public abstract void calculatePerimeter(double ... args);

    /**
     * 计算面积
     * @return
     */
    public abstract void calculateArea(double ... args);
}
