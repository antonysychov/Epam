package HomeWork.HomeWork1.Task1;

public class Parallelogram extends Shape {
    /*
                  base
             --------------
           / |            /
          /  |altitude   /
         /   |          /
        ---------------
    */
    private float base;
    private float altitude;

    public Parallelogram(float altitude, float base) {
        this.altitude = altitude;
        this.base = base;
    }

    @Override
    public float getSquare() {
        return base * altitude;
    }

    public float getAltitude() {
        return altitude;
    }

    public float getBase() {
        return base;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parallelogram)) return false;

        Parallelogram that = (Parallelogram) o;

        if (Float.compare(that.base, base) != 0) return false;
        return Float.compare(that.altitude, altitude) == 0;

    }

    @Override
    public int hashCode() {
        int result = (base != +0.0f ? Float.floatToIntBits(base) : 0);
        result = 31 * result + (altitude != +0.0f ? Float.floatToIntBits(altitude) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Parallelogram{" +
                "altitude=" + altitude +
                ", base=" + base +
                '}';
    }
}
