package HomeWork.HomeWork1.Task1;

public class Ring extends Shape {

    private float radius;

    public Ring(float radius) {
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }

    @Override
    public float getSquare() {
        return (float) (radius * radius * Math.PI);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ring ring = (Ring) o;

        if (Float.compare(ring.radius, radius) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (radius != +0.0f ? Float.floatToIntBits(radius) : 0);
    }

    @Override
    public String toString() {
        return "Ring{" +
                "radius=" + radius +
                '}';
    }
}
