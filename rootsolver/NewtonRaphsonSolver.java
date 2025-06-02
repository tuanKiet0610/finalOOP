package rootsolver;

public class NewtonRaphsonSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public NewtonRaphsonSolver(double tolerance, int maxIterations) {
        this.tolerance =tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của hàm một biến sử dụng phương pháp Newton-Raphson.
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm.
     */
    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        double x0 = (lower + upper) / 2; // Giá trị khởi tạo x0 là trung điểm của khoảng [lower, upper]
        double x = x0;
        int iteration = 0;

        while (iteration < maxIterations) {
            double f = function.evaluate(x);
            double fPrime = function.derivative(x);

            if (Math.abs(f) < tolerance) {
                return x;
            }

            if (Math.abs(fPrime) < 1e-10) {
                break;
            }

            double deltaX = -f / fPrime;
            x += deltaX;

            if (Math.abs(deltaX) < tolerance) {
                return x;
            }
            iteration++;
        }

        throw new IllegalStateException("The method failed to converge within the maximum number of iterations.");
    }
}
