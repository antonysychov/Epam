package HomeWork.HomeWork1.Task1;

public class Trapezium extends Shape {
    /*
              upperBase
             -----------
           / |           \
          /  |altitude    \
         /   |             \
        --------------------
              lowerBase
    */
    private float upperBase;
    private float lowerBase;
    private float altitude;

    public Trapezium(float altitude, float lowerBase, float upperBase) {
        this.altitude = altitude;
        this.lowerBase = lowerBase;
        this.upperBase = upperBase;
    }

    @Override
    public float getSquare() {
        return 0.5f * (lowerBase + upperBase) * altitude;
    }

    public float getAltitude() {
        return altitude;
    }

    public float getLowerBase() {
        return lowerBase;
    }

    public float getUpperBase() {
        return upperBase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trapezium trapezium = (Trapezium) o;

        if (Float.compare(trapezium.altitude, altitude) != 0) return false;
        if (Float.compare(trapezium.lowerBase, lowerBase) != 0) return false;
        if (Float.compare(trapezium.upperBase, upperBase) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (upperBase != +0.0f ? Float.floatToIntBits(upperBase) : 0);
        result = 31 * result + (lowerBase != +0.0f ? Float.floatToIntBits(lowerBase) : 0);
        result = 31 * result + (altitude != +0.0f ? Float.floatToIntBits(altitude) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Trapezium{" +
                "altitude=" + altitude +
                ", upperBase=" + upperBase +
                ", lowerBase=" + lowerBase +
                '}';
    }
}
