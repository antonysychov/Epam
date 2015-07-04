package HomeWork.HomeWork1.Task1;

public class Triangle extends Shape {

    private float base;
    private float altitude;

    public Triangle(float altitude, float base) {
        this.altitude = altitude;
        this.base = base;
    }

    public float getAltitude() {
        return altitude;
    }

    @Override
    public float getSquare() {
        return 0.5f * base * altitude;
    }

    public float getBase() {
        return base;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (Float.compare(triangle.altitude, altitude) != 0) return false;
        if (Float.compare(triangle.base, base) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (base != +0.0f ? Float.floatToIntBits(base) : 0);
        result = 31 * result + (altitude != +0.0f ? Float.floatToIntBits(altitude) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "altitude=" + altitude +
                ", base=" + base +
                '}';
    }
}
