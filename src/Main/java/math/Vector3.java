package math;

public record Vector3(double x, double y, double z) {

    public double dotProduct(Vector3 b) {
        return this.x * b.x + this.y * b.y + this.z * b.z;
    }

    public static double dotProduct(Vector3 a, Vector3 b) {
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }

    public Vector3 crossProduct(Vector3 b) {
        return new Vector3(
                this.y * b.z - this.z * b.y,
                this.z * b.x - this.x * b.z,
                this.x * b.y - this.y * b.x
        );
    }

    public static Vector3 crossProduct(Vector3 a, Vector3 b) {
        return new Vector3(
                a.y * b.z - a.z * b.y,
                a.z * b.x - a.x * b.z,
                a.x * b.y - a.y * b.x
        );
    }

    public Vector3 add(Vector3 b) {
        return new Vector3(
                this.x + b.x,
                this.y + b.y,
                this.z + b.z
        );
    }

    public Vector3 subtract(Vector3 b) {
        return new Vector3(
                this.x - b.x,
                this.y - b.y,
                this.z - b.z
        );
    }

    public Vector3 multiply(double scalar) {
        return new Vector3(
                this.x * scalar,
                this.y * scalar,
                this.z * scalar
        );
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Vector3 normalize() {
        double length = this.length();

        if (length == 0) {
            throw new IllegalStateException("Cannot normalize a zero vector");
        }

        return new Vector3(
                x / length,
                y / length,
                z / length
        );
    }
}