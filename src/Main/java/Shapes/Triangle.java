package Shapes;

import math.Vector3;
import math.raytraceing;

public class Triangle implements Shape {

    private Vector3 a;
    private Vector3 b;
    private Vector3 c;

    public Triangle(Vector3 a, Vector3 b, Vector3 c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public HitRecord hit(raytraceing ray) {

        Vector3 edge1 = b.subtract(a);
        Vector3 edge2 = c.subtract(a);

        Vector3 h = ray.dir().crossProduct(edge2);

        double d = edge1.dotProduct(h);

        if (Math.abs(d) < 0.000001) {
            return new HitRecord(false);
        }

        double f = 1.0 / d;

        Vector3 s = ray.origin().subtract(a);

        double u = f * s.dotProduct(h);

        if (u < 0 || u > 1) {
            return new HitRecord(false);
        }

        Vector3 q = s.crossProduct(edge1);

        double v = f * ray.dir().dotProduct(q);

        if (v < 0 || u + v > 1) {
            return new HitRecord(false);
        }

        double t = f * edge2.dotProduct(q);

        return new HitRecord(t > 0);
    }
}