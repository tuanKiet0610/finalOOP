package integration;

public class MidpointMethod extends AbstractIntegrator {
    public MidpointMethod(double precision, int maxIterations) {
        super(precision,maxIterations);
    }

    /**
     * Phương thức tính xấp xỉ giá trị tích phân. Giá trị xấp xỉ được chấp nhận nếu phép tính đạt độ chính xác đã cho,
     * hoặc có số vòng lặp vượt quá ngưỡng quy định.
     * Độ chính xác được xác định như sau, chọn n_0 tùy ý, sau đó tính I_n với n = n_0, 2n_0, 4n_0, ...
     * Việc tính toán dừng lại khi |I_2n - I_n|/3 < eps (precision), hoặc số lần chia đôi vượt quá ngưỡng quy định (maxIterations).
     * @param polynomial
     * @param lower
     * @param upper
     * @return
     */
    @Override
    public double integrate(MyPolynomial polynomial, double lower, double upper) {
        int n = 1;
        double I_n = integrate(polynomial, lower, upper, n);
        for (int i = 0; i < maxIterations; i++) {
            n *= 2;
            double I_2n = integrate(polynomial, lower, upper, n);
            if (Math.abs(I_2n - I_n) / 3 < precision) {
                return I_2n;
            }
            I_n = I_2n;
        }
        return I_n;
    }

    /**
     * Phương thức tính xấp xỉ giá trị tích phân với numOfSubIntervals khoảng phân hoạch đều.
     * @param polynomial
     * @param lower
     * @param upper
     * @param numOfSubIntervals
     * @return giá trị xấp xỉ giá trị tích phân.
     */
    private double integrate(MyPolynomial polynomial, double lower, double upper, int numOfSubIntervals) {
        double result = 0;
        double delta = (upper - lower) / numOfSubIntervals;
        for (int i = 1; i < numOfSubIntervals; i++) {
            double x_prev = lower + delta * (i-1);
            double x_curr = lower + delta * (i);
            result += polynomial.evaluate((x_prev + x_curr) / 2);
        }
        return result * (delta);
    }
    @Override
    public String toString() {
        return "MidpointMethod{" +
                "precision=" + precision +
                ", maxIterations=" + maxIterations +
                '}';
    }
}
