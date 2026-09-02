package Shapes;

import math.Vector3;
import math.raytraceing;

public class Sphere implements Shape {

    private Vector3 center;
    private double radius;

    public Sphere(Vector3 center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public HitRecord hit(raytraceing ray) {

        Vector3 oc = ray.origin().subtract(center);

        double a = ray.dir().dotProduct(ray.dir());
        double b = 2 * oc.dotProduct(ray.dir());
        double c = oc.dotProduct(oc) - radius * radius;

        double d = b * b - 4 * a * c;

        if (d < 0) {
            return new HitRecord(false);
        }

        double t = (-b - Math.sqrt(d)) / (2 * a);

        return new HitRecord(t > 0);
    }
}