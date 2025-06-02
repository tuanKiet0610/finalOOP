package rootsolver;

public class MyMath {
    public static double sin(double x) {
        double result = x;
        double temp = x;
        for (int i = 3; i <= 1001; i = i + 2) {
            temp = -1 * temp * x * x / (i - 1) / i;
            result += temp;
        }
        return result;
    }

    public static double cos(double x) {
        double result = 1.0;
        // temp: từng phần tử của khai triển Taylor;
        double temp = 1.0;
        for (int i = 2; i <= 1000; i = i + 2) {
            temp = -1 * temp * x * x / ((i - 1) * i);
            result += temp;
        }
        return result;
    }

    public double exp(double x) {
        double result = 1.0;
        double temp = 1.0;
        for (int i = 1; i <= 1000; i++) {
            temp = temp * x / i;
            result += temp;
        }
        return result;
    }

    public double ln(double x) {
        /* TODO */
        x = x - 1;
        if (Math.abs(x) <= 1) {
            double result = 0.0;
            double temp = x;
            for (int i = 1; i <= 1000; i++) {
                result += temp;
                temp = -1 * temp * x * i / (i + 1);
            }
            return result;
        } else return ln(1 + 1 / x) - ln(1 / x);
    }
}
