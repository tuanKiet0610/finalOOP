package integration;

import java.util.ArrayList;
import java.util.List;

public class MyListPolynomial extends MyAbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyListPolynomial() {
        this.coefficients = new ArrayList<>();
    }
    public MyListPolynomial(double[] coefficients) {
        this.coefficients = new ArrayList<>();
        for (double num: coefficients) {
            this.coefficients.add(num);
        }
    }

    /**
     * Lấy hệ số của đa thức tại vị trí index.
     * @return
     */
    @Override
    public double coefficient(int index) {
        //checkIndex(index); redundant because List ADT will automatically do it for us
        return coefficients.get(index);
    }

    /**
     * Lấy các hệ số của đa thức.
     * @return
     */
    @Override
    public double[] coefficients() {
        double[] result = new double[coefficients.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = coefficients.get(i);
        }
        return result;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào cuối đa thức hiện tại.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public MyListPolynomial append(double coefficient) {
        coefficients.add(coefficient);
        return this;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào vị trí index.
     * Nếu index nằm ngoài đoạn [0, coefficients.length()] thì không thêm được.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public MyListPolynomial insert(double coefficient, int index) {
        //checkIndex(index); redundant because List ADT will automatically do it for us
        coefficients.add(index, coefficient);
        return this;
    }

    /**
     * Sửa hệ số của phần tử index là coefficient.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public MyListPolynomial set(double coefficient, int index) {
        //checkIndex(index); redundant because List ADT will automatically do it for us
        coefficients.set(index, coefficient);
        return this;
    }

    /**
     * Lấy ra bậc của đa thức.
     * @return
     */
    @Override
    public int degree() {
        return this.coefficients.size() - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return
     */
    @Override
    public double evaluate(double x) {
        double result = 0.0;
        for (int i = 0; i < coefficients.size(); i++) {
            result += coefficients.get(i) * Math.pow(x,i);
        }
        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ListPolynomial là đa thức đạo hàm của đa thức ban đầu.
     */
    @Override
    public MyPolynomial derivative() {
        return new MyListPolynomial(differentiate());
    }

    /**
     * Cộng đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public MyListPolynomial plus(MyListPolynomial another) {
        if (this.degree() != another.degree()) {
            throw new RuntimeException("Unequal degree");
        }
        for (int i = 0; i < this.coefficients.size(); i++) {
            this.coefficients.set(i, this.coefficients.get(i) + another.coefficient(i));
        }
        return this;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public MyListPolynomial minus(MyListPolynomial another) {
        if (this.degree() != another.degree()) {
            throw new RuntimeException("Unequal degree");
        }
        for (int i = 0; i < this.coefficients.size(); i++) {
            this.coefficients.set(i, this.coefficients.get(i) - another.coefficient(i));
        }
        return this;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public MyListPolynomial multiply(MyListPolynomial another) {
        int firstLength = this.degree() + 1;
        int secondLength = another.degree() + 1;
        double[] result = new double[firstLength + secondLength - 1];
        //First polynomial loop
        for (int i = 0; i < firstLength; i++) {
            //Second polynomial loop
            for (int j = 0; j < secondLength; j++) {
                //We do not call coefficient(int index) to save time of calling a function
                result[i+j] += this.coefficients.get(i) * another.coefficient(j);
            }
        }
        //We have to clear the coefficients list then append all the number from the result array back
        //We cannot return a new instance of ListPolynomial using the constructor(double[] coefficient) because we want to
        //return this instance of ListPolynomial, not a new one
        this.coefficients.clear();
        for (double num: result) {
            this.coefficients.add(num);
        }
        return this;
    }
}
