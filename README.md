# Raytracer – Laboratory 2

## Description

This project is a simple raytracer written in Java using object-oriented programming.

The program creates rays from a camera and checks if the rays hit objects in a scene. The scene can contain different types of shapes, such as spheres and triangles.

When a ray hits a shape, the renderer gives the shape a selected color. The final image is saved as a PNG file.

## Classes

- Vector3 – represents a 3D vector and provides mathematical operations.
- Color – represents a color using red, green, and blue values.
- raytraceing – represents a ray with an origin and a direction.
- HitRecord – stores whether a ray hit a shape.
- Shape – an interface that defines the hit() method.
- Sphere – represents a sphere and checks if a ray hits it.
- Triangle – represents a triangle and checks if a ray hits it.
- Scene – stores all shapes in a List<Shape>.
- Render – creates rays, checks for intersections, colors the shapes, and saves the image.
- Main – starts the program and creates the scene.

## Object-Oriented Design

The project uses an interface called Shape.

Both Sphere and Triangle implement the Shape interface.

The Scene stores the shapes as a List<Shape>. This allows different types of shapes to be stored in the same scene.

The renderer does not need to know which specific type of shape it is working with. It simply calls the hit() method through the Shape interface.

This uses polymorphism because each shape has its own implementation of the hit() method.

The design also follows the Open/Closed Principle. New shapes can be added without changing the existing Scene or Render classes.

## How to Add a New Shape

To add a new shape, create a new class that implements the Shape interface.

For example, a new Box class could look like this:

public class Box implements Shape {

    @Override
    public HitRecord hit(raytraceing ray) {
        // Calculate if the ray hits the box
        return new HitRecord(false);
    }
}

The new shape can then be added to the scene:

scene.addShape(new Box());

No changes are needed in the Scene or Render classes.

## Choosing a Shape

The shape is selected in Main.java.

To use a sphere:

scene.addShape(
new Sphere(
new Vector3(0, 0, -5),
1
)
);

To use a triangle instead:

scene.addShape(
new Triangle(
new Vector3(-2, -1, -4),
new Vector3(2, -1, -4),
new Vector3(0, 2, -4)
)
);

Both shapes can also be added to the same scene.

## Choosing a Color

The color is selected in Main.java.

For example:

Color color = new Color(1.0, 0.0, 0.0);

The values represent red, green, and blue. Each value is between 0.0 and 1.0.

Examples:

new Color(1.0, 0.0, 0.0) – Red
new Color(0.0, 1.0, 0.0) – Green
new Color(0.0, 0.0, 1.0) – Blue
new Color(1.0, 1.0, 0.0) – Yellow
new Color(1.0, 1.0, 1.0) – White

The background is black.

## How the Raytracer Works

For every pixel in the image, the renderer creates a ray.

The ray starts at the camera and travels into the scene.

The renderer then checks the ray against every shape in the scene.

If the ray hits a shape, the selected color is used for that pixel.

If the ray does not hit anything, the pixel gets the background color.

## How to Run

Run Main.java.

The program renders the scene and saves the result as:

output.png

The image is saved in the project's working directory.

## Requirements

- Java
- An IDE such as IntelliJ IDEA
- Java classes for the raytracer and math operations
