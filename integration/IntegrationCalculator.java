package integration;

public class IntegrationCalculator {
    private Integrator integrator;
    private MyPolynomial polynomial;

    /**
     * Hàm dựng, khởi tạo đa thức cần tính tích phân.
     * @param polynomial
     */
    public IntegrationCalculator(MyPolynomial polynomial) {
        this.polynomial = polynomial;
        this.integrator = new SimpsonMethod(1e-6, 1000);
    }

    /**
     * Hàm dựng, khởi tạo phương pháp tính tích phân và đa thức cần tính tích phân.
     * @param integrator
     * @param polynomial
     */
    public IntegrationCalculator(Integrator integrator, MyPolynomial polynomial) {
        this.integrator = integrator;
        this.polynomial = polynomial;
    }

    public void setIntegrator(Integrator integrator) {
        this.integrator = integrator;
    }

    public void setPolynomial(MyPolynomial polynomial) {
        this.polynomial = polynomial;
    }

    public double integrate(double lower, double upper) {
        return integrator.integrate(polynomial,lower,upper);
    }
}
