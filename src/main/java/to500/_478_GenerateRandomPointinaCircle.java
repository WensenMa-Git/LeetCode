package to500;


public class _478_GenerateRandomPointinaCircle {


    double rad, xc, yc;

    public _478_GenerateRandomPointinaCircle(double radius, double x_center, double y_center) {
        rad = radius;
        xc = x_center;
        yc = y_center;
    }

    public double[] randPoint() {
        double x0 = xc - rad;
        double y0 = yc - rad;

        while (true) {
            double xg = x0 + Math.random() * rad * 2;
            double yg = y0 + Math.random() * rad * 2;
            if (Math.sqrt(Math.pow((xg - xc), 2)) + Math.sqrt(Math.pow((yg - yc), 2)) <= rad) {
                return new double[]{xg, yg};
            }
        }
    }

    public void _478_GenerateRandomPointinaCircle(double radius, double x_center, double y_center) {
        rad = radius;
        xc = x_center;
        yc = y_center;
    }

    public double[] randPoint2() {
        double d = rad * Math.sqrt(Math.random());
        double theta = Math.random() * 2 * Math.PI;
        return new double[]{d * Math.cos(theta) + xc, d * Math.sin(theta) + yc};
    }
}
