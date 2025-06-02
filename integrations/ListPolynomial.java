package integrations;

import java.util.ArrayList;
import java.util.List;

public class ListPolynomial extends AbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ListPolynomial() {
        this.coefficients = new ArrayList<Double>();
    }

    /**
     * Lấy hệ số của đa thức tại vị trí index.
     * @return
     */
    @Override
    public double coefficient(int index) {
        return coefficients.get(index);
    }

    /**
     * Lấy các hệ số của đa thức.
     * @return
     */
    @Override
    public double[] coefficients() {
        double[] coeffs = new double[coefficients.size()];
        for (int i = 0; i < coefficients.size(); i++) {
            coeffs[i] = coefficients.get(i);
        }
        return coeffs;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào đầu đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ListPolynomial insertAtStart(double coefficient) {
        coefficients.add(0, coefficient);
        return this;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào cuối đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ListPolynomial insertAtEnd(double coefficient) {
        coefficients.add(coefficient);
        return this;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial insertAtPosition(double coefficient, int index) {
        coefficients.add(index, coefficient);
        return this;
    }

    /**
     * Sửa hệ số của phần tử index là coefficient.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial set(double coefficient, int index) {
        coefficients.set(index, coefficient);
        return this;
    }

    /**
     * Lấy ra bậc của đa thức.
     * @return
     */
    @Override
    public int degree() {
        return coefficients.size() - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return
     */
    @Override
    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < coefficients.size(); i++) {
            result += coefficients.get(i) * Math.pow(x, i);
        }
        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ListPolynomial là đa thức đạo hàm của đa thức ban đầu.
     */
    @Override
    public ListPolynomial derivative() {
        ListPolynomial result = new ListPolynomial();
        for (int i = 0; i < coefficients.size(); i++) {
            result.insertAtEnd(coefficients.get(i) * i);
        }
        return result;
    }

    /**
     * Cộng đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức mới là tổng hai đa thức.
     */
    public ListPolynomial plus(Polynomial another) {
        ListPolynomial result = new ListPolynomial();
        int maxSize = Math.max(this.coefficients.size(), another.degree() + 1);
        for (int i = 0; i < maxSize; i++) {
            double coefficient = (i < this.coefficients.size()) ? this.coefficients.get(i) : 0;
            double otherCoefficient = (i < another.degree() + 1) ? another.coefficients()[i] : 0;
            result.insertAtEnd(coefficient + otherCoefficient);
        }
        return result;
    }

    /**
     * Cộng đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial plusTo(Polynomial another) {
        ListPolynomial result = new ListPolynomial();
        int maxSize = Math.max(this.coefficients.size(), another.degree() + 1);
        for (int i = 0; i < maxSize; i++) {
            double coefficient = (i < this.coefficients.size()) ? this.coefficients.get(i) : 0;
            double otherCoefficient = (i < another.degree() + 1) ? another.coefficients()[i] : 0;
            result.insertAtEnd(coefficient + otherCoefficient);
        }
        return result;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức mới là hiệu hai đa thức.
     */
    public ListPolynomial minus(Polynomial another) {
        ListPolynomial result = new ListPolynomial();
        int maxSize = Math.max(this.coefficients.size(), another.degree() + 1);
        for (int i = 0; i < maxSize; i++) {
            double coefficient = (i < this.coefficients.size()) ? this.coefficients.get(i) : 0;
            double otherCoefficient = (i < another.degree() + 1) ? another.coefficients()[i] : 0;
            result.insertAtEnd(coefficient - otherCoefficient);
        }
        return result;
    }

    /**
     * Trừ đa thức hiện tại cho đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial minusFrom(Polynomial another) {
        ListPolynomial result = new ListPolynomial();
        int maxSize = Math.max(this.coefficients.size(), another.degree() + 1);
        for (int i = 0; i < maxSize; i++) {
            double coefficient = (i < this.coefficients.size()) ? this.coefficients.get(i) : 0;
            double otherCoefficient = (i < another.degree() + 1) ? another.coefficients()[i] : 0;
            result.insertAtEnd(coefficient + otherCoefficient);
        }
        return result;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức mới là đa thức nhân của hai đa thức.
     */
    public ListPolynomial multiply(Polynomial another) {
        ListPolynomial result = new ListPolynomial();
        for (int i = 0; i < this.coefficients.size(); i++) {
            for (int j = 0; j < another.degree() + 1; j++) {
                int newDegree = i + j;
                double newCoefficient = this.coefficients.get(i) * another.coefficients()[j];
                if (newDegree >= result.degree() + 1) {
                    for (int k = result.degree() + 1; k <= newDegree; k++) {
                        result.insertAtEnd(0);
                    }
                }
                result.set(result.coefficient(newDegree) + newCoefficient, newDegree);
            }
        }
        return result;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial multiplyBy(Polynomial another) {
        ListPolynomial result = new ListPolynomial();
        for (int i = 0; i < this.coefficients.size(); i++) {
            for (int j = 0; j < another.degree() + 1; j++) {
                int newDegree = i + j;
                double newCoefficient = this.coefficients.get(i) * another.coefficients()[j];
                if (newDegree >= result.degree() + 1) {
                    for (int k = result.degree() + 1; k <= newDegree; k++) {
                        result.insertAtEnd(0);
                    }
                }
                result.set(result.coefficient(newDegree) + newCoefficient, newDegree);
            }
        }
        return result;
    }
}
