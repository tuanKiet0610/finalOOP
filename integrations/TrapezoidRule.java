package integrations;

public class TrapezoidRule implements Integrator {
    private double precision;
    private int maxIterations;

    public TrapezoidRule(double precision, int maxIterations) {
        /* TODO */
    }

    /**
     * Phương thức tính xấp xỉ giá trị tích phân. Giá trị xấp xỉ được chấp nhận nếu phép tính đạt độ chính xác đã cho,
     * hoặc có số vòng vượt quá ngưỡng quy định.
     * Độ chính xác được xác định như sau, chọn n0 tùy ý, sau đó tính I_n với n = n0, 2n0, 4n0, ...
     * Việc tính toán dừng lại khi |I_2n - In|/3 < eps (precision), hoặc số lần chia đôi vượt quá ngưỡng quy định (maxIterations).
     * @param poly
     * @param lower
     * @param upper
     * @return
     */
    @Override
    public double integrate(Polynomial poly, double lower, double upper) {
        int n = 1;
        double result = trapezoidRule(poly, lower, upper, n);
        double prevResult;
        do {
            prevResult = result;
            n *= 2;
            result = trapezoidRule(poly, lower, upper, n);
        } while (Math.abs(result - prevResult) / 3 >= precision && n <= maxIterations);
        return result;
    }

    private double trapezoidRule(Polynomial poly, double lower, double upper, int n) {
        double h = (upper - lower) / n;
        double sum = 0.5 * (poly.evaluate(lower) + poly.evaluate(upper));
        for (int i = 1; i < n; i++) {
            double x = lower + i * h;
            sum += poly.evaluate(x);
        }
        return sum * h;
    }

    /**
     * Phương thức tính xấp xỉ giá trị tích phân với numOfSubIntervals khoảng phân hoạch đều.
     * @param poly
     * @param lower
     * @param upper
     * @param numOfSubIntervals
     * @return giá trị xấp xỉ giá trị tích phân.
     */
    private double integrate(Polynomial poly, double lower, double upper, int numOfSubIntervals) {
        double h = (upper - lower) / numOfSubIntervals;
        double sum = 0.5 * (poly.evaluate(lower) + poly.evaluate(upper));
        for (int i = 1; i < numOfSubIntervals; i++) {
            double x = lower + i * h;
            sum += poly.evaluate(x);
        }
        return sum * h;
    }
}
