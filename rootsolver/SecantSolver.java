package rootsolver;

public class SecantSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public SecantSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của hàm một biến theo phương pháp Secant
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm trong đoạn [lower, upper]
     */
    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        /* TODO */
        double x0 = lower;
        double x1 = upper;
        double f0 = function.evaluate(x0);
        double f1 = function.evaluate(x1);

        int iteration = 0;
        double error = Math.abs(x1 - x0);

        while (error > tolerance && Math.abs(f1) > tolerance && iteration < maxIterations) {
            double x2 = x1 - (f1 * (x1 - x0)) / (f1 - f0);
            double f2 = function.evaluate(x2);

            x0 = x1;
            f0 = f1;
            x1 = x2;
            f1 = f2;

            error = Math.abs(x1 - x0);
            iteration++;
        }

        if (Math.abs(f1) <= tolerance) {
            return x1;
        } else {
            throw new IllegalStateException("The method failed to converge within the maximum number of iterations.");
        }
    }
}
