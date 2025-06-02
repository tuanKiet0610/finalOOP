package rootsolver;

public class BisectionSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public BisectionSolver(double tolerance, int maxIterations) {
        this.maxIterations = maxIterations;
        this.tolerance = tolerance;
    }

    /**
     * Tìm nghiệm của hàm một biến theo phương pháp chia đôi (Bisection)
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm.
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

        while (error > tolerance && Math.abs(f0) > tolerance && iteration < maxIterations) {
            double xMid = (x0 + x1) / 2;
            double fMid = function.evaluate(xMid);

            if (fMid == 0) {
                return xMid;
            } else if (fMid * f0 < 0) {
                x1 = xMid;
                f1 = fMid;
            } else {
                x0 = xMid;
                f0 = fMid;
            }

            error = Math.abs(x1 - x0);
            iteration++;
        }

        if (Math.abs(f0) <= tolerance) {
            return x0;
        } else {
            throw new IllegalStateException("The method failed to converge within the maximum number of iterations.");
        }
    }
}
