package rootsolver;

public class UnivariateRealRootFinding {
    private AbstractFunction function;
    private RootSolver rootSolver;

    /**
     * Khởi tạo hàm.
     * @param function
     */
    public UnivariateRealRootFinding(AbstractFunction function) {
        this.function = function;
        this.rootSolver = new BisectionSolver(1e-6, 100);
    }

    /**
     * Khởi tạo hàm và phương pháp tìm nghiệm.
     * @param function
     * @param rootSolver
     */
    public UnivariateRealRootFinding(AbstractFunction function, RootSolver rootSolver) {
        this.rootSolver = rootSolver;
        this.function = function;
    }

    public void setFunction(AbstractFunction function) {
        this.function = function;
    }

    public void setRootSolver(RootSolver rootSolver) {
        this.rootSolver = rootSolver;
    }

    /**
     * Tìm nghiệm của hàm theo phương pháp đã cho.
     * @param lower
     * @param upper
     * @return nghiệm của hàm.
     */
    public double solve(double lower, double upper) {
        return this.rootSolver.solve(this.function, lower, upper);
    }
}
