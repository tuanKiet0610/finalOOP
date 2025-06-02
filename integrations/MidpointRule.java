package integrations;

public class MidpointRule implements Integrator {
    private double precision;
    private int maxIterations;

    public MidpointRule(double precision, int maxIterations) {
        this.precision = precision;
        this.maxIterations = maxIterations;
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
        double result = midpointRule(poly, lower, upper, n);
        double prevResult;
        do {
            prevResult = result;
            n *= 2;
            result = midpointRule(poly, lower, upper, n);
        } while (Math.abs(result - prevResult) / 3 >= precision && n <= maxIterations);
        return result;
    }

    private double midpointRule(Polynomial poly, double lower, double upper, int n) {
        double h = (upper - lower) / n;
        double sum = 0;
        for (int i = 0; i < n; i++) {
            double x1 = lower + i * h;
            double x2 = lower + (i + 1) * h;
            double midpoint = (x1 + x2) / 2;
            sum += poly.evaluate(midpoint);
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
        double sum = 0;
        for (int i = 0; i < numOfSubIntervals; i++) {
            double x1 = lower + i * h;
            double x2 = lower + (i + 1) * h;
            double midpoint = (x1 + x2) / 2;
            sum += poly.evaluate(midpoint);
        }
        return sum * h;
    }
}
