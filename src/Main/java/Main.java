import Shapes.Sphere;
import Shapes.Triangle;
import math.Vector3;
import math.Color;

public class Main {

    public static void main(String[] args) {

        Scene scene = new Scene();

        // Välj Sphere
        scene.addShape(
                new Sphere(
                        new Vector3(0, 0, -5),
                        1
                )
        );

        /*
        // Välj Triangle istället
        scene.addShape(
                new Triangle(
                        new Vector3(-2, -1, -4),
                        new Vector3(2, -1, -4),
                        new Vector3(0, 2, -4)
                )
        );
        */

        // Välj färg
        Color color = new Color(
                0.0, 1.0, 0.0
        );

        Render render = new Render(
                800,
                600,
                color
        );

        try {
            render.render(
                    scene,
                    "output.png"
            );

            System.out.println("Rendering complete!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}