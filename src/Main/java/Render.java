import Shapes.Shape;
import Shapes.HitRecord;
import math.Color;
import math.raytraceing;
import math.Vector3;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Render {

    private final int width;
    private final int height;
    private final Color shapeColor;

    public Render(int width, int height, Color shapeColor) {
        this.width = width;
        this.height = height;
        this.shapeColor = shapeColor;
    }

    public void render(Scene scene, String filename) throws IOException {

        BufferedImage image = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_RGB
        );

        for (int y = 0; y < height; y++) {

            for (int x = 0; x < width; x++) {

                Color color = tracePixel(scene, x, y);

                int red = toRGB(color.getRed());
                int green = toRGB(color.getGreen());
                int blue = toRGB(color.getBlue());

                int rgb = (red << 16) | (green << 8) | blue;

                image.setRGB(x, y, rgb);
            }
        }

        ImageIO.write(
                image,
                "png",
                new File(filename)
        );
    }

    private Color tracePixel(Scene scene, int x, int y) {

        double viewportWidth = 2.0;
        double viewportHeight = 2.0;

        double pixelX =
                (x + 0.5) / width * viewportWidth
                        - viewportWidth / 2.0;

        double pixelY =
                viewportHeight / 2.0
                        - (y + 0.5) / height * viewportHeight;

        Vector3 origin = new Vector3(0, 0, 0);

        Vector3 direction = new Vector3(
                pixelX,
                pixelY,
                -1
        ).normalize();

        raytraceing ray = new raytraceing(origin, direction);

        for (Shape shape : scene.getShapes()) {

            HitRecord hit = shape.hit(ray);

            if (hit.hit()) {
                return shapeColor;
            }
        }

        return new Color(0.0, 0.0, 0.0);
    }

    private int toRGB(double value) {

        value = Math.max(
                0.0,
                Math.min(1.0, value)
        );

        return (int) (value * 255);
    }
}