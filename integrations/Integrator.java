package integrations;

public interface Integrator {
    double integrate(Polynomial poly, double lower, double upper);
}
