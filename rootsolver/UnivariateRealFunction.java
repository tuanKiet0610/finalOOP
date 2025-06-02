package rootsolver;

public class UnivariateRealFunction implements AbstractFunction {
    @Override
    public double evaluate(double x) {
        return x * MyMath.sin(x) - 3;
    }

    @Override
    public double derivative(double x) {
        return Math.sin(x) + x * MyMath.cos(x);
    }
}
