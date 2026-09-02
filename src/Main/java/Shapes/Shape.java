package Shapes;

import math.raytraceing;

public interface Shape {

    HitRecord hit(raytraceing ray);
}