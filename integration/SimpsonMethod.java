package integration;

public class SimpsonMethod extends AbstractIntegrator {
    public SimpsonMethod(double precision, int maxIterations) {
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
        int n = 2;
        double I_n = integrate(polynomial, lower, upper, n);
        double I_2n = 0;
        for (int i = 0; i < maxIterations; i++) {
            n *= 2;
            I_2n = integrate(polynomial, lower, upper, n);
            if ((Math.abs(I_2n - I_n) / 3) < precision) {
                return I_2n;
            }
            I_n = I_2n;
        }
        return I_2n;
    }

    /**
     * Phương thức tính xấp xỉ giá trị tích phân với numOfSubIntervals (số chẵn) khoảng phân hoạch đều.
     * @param polynomial
     * @param lower
     * @param upper
     * @param numOfSubIntervals
     * @return giá trị xấp xỉ giá trị tích phân.
     */
    private double integrate(MyPolynomial polynomial, double lower, double upper, int numOfSubIntervals) {
        if (numOfSubIntervals % 2 != 0) {
            throw new RuntimeException("Number of subintervals has to be even");
        }
        double result = polynomial.evaluate(lower);
        double delta = (upper - lower) / numOfSubIntervals;
        for (int i = 1; i < numOfSubIntervals; i++) {
            //x_i = a + i * delta_x
            double x = lower + i * delta;
            if (i % 2 != 0) {
                result += 4 * polynomial.evaluate(x);
            }
            if (i % 2 == 0) {
                result += 2 * polynomial.evaluate(x);
            }
        }
        result += polynomial.evaluate(upper);
        return result * (delta / 3);
    }
    @Override
    public String toString() {
        return "SimpsonMethod{" +
                "precision=" + precision +
                ", maxIterations=" + maxIterations +
                '}';
    }
}
