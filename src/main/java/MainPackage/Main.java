package MainPackage;

import javaCalculus.*;

public class Main
{
    public static double f0(double valueOfX) { return Math.pow(valueOfX, 4)-4*Math.pow(valueOfX, 2)+4;}
    public static double f0Der(double valueOfX) { return 4*Math.pow(valueOfX, 3)-8*valueOfX;}
    public static void f0Gradient(double epsilon, double step, double[]vector)
    {
        double[]newVector = {0.0};
        while (true)
        {
            newVector[0] = vector[0] - step * f0Der(vector[0]);

            double max = Math.abs(newVector[0]-vector[0]);

            if (max<epsilon)
            {
                System.out.println("----------");
                System.out.println("Wyznaczono minimum");
                System.out.println("x0 = "+newVector[0]);
                System.out.println("wartość = "+f0(newVector[0]));
                System.out.println("----------");
                break;
            }

            vector[0] = newVector[0];
        }
    }
    public static void main(String[]args)
    {
        f0Gradient(0.0000001, 0.01, new double[]{-5.0});
    }
}
