package math;

public record raytraceing(Vector3 origin, Vector3 dir) {

    public Vector3 pointAt(double t) {
        return origin.add(dir.multiply(t));
    }
}