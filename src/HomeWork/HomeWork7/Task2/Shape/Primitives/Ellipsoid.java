package HomeWork.HomeWork7.Task2.Shape.Primitives;

import HomeWork.HomeWork7.Task2.Shape.Primitives.Primitive;
import HomeWork.HomeWork7.Task2.Shape.Primitives.PrimitiveType;

public class Ellipsoid extends Primitive {
    {type = PrimitiveType.ELLIPSOID;}
    int xCenter, yCenter, bigRadius, smallRadius;

    public Ellipsoid(int xCenter, int yCenter, int bigRadius, int smallRadius) {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.bigRadius = bigRadius;
        this.smallRadius = smallRadius;
    }

    public int getxCenter() {
        return xCenter;
    }

    public void setxCenter(int xCenter) {
        this.xCenter = xCenter;
    }

    public int getyCenter() {
        return yCenter;
    }

    public void setyCenter(int yCenter) {
        this.yCenter = yCenter;
    }

    public int getBigRadius() {
        return bigRadius;
    }

    public void setBigRadius(int bigRadius) {
        this.bigRadius = bigRadius;
    }

    public int getSmallRadius() {
        return smallRadius;
    }

    public void setSmallRadius(int smallRadius) {
        this.smallRadius = smallRadius;
    }
}
