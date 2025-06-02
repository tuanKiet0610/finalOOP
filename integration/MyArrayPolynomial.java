package integration;

import java.util.Arrays;

public class MyArrayPolynomial extends MyAbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] coefficients;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayPolynomial() {
        this.coefficients = new double[DEFAULT_CAPACITY];
    }
    public MyArrayPolynomial(double[] coefficents) {
        this.coefficients = coefficents;
        this.size = coefficents.length;
    }

    /**
     * Lấy hệ số của đa thức tại phần tử index
     * @return hệ số tại phần tử index.
     */
    @Override
    public double coefficient(int index) {
        checkIndex(index);
        return coefficients[index];
    }

    /**
     * Lấy mảng các hệ số của đa thức.
     * @return mảng các hệ số của đa thức.
     */
    @Override
    public double[] coefficients() {
        return Arrays.copyOf(coefficients, size);
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào cuối đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public MyArrayPolynomial append(double coefficient) {
        if (size == coefficients.length) {
            enlarge();
        }
        coefficients[size] = coefficient;
        size++;
        return this;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào vị trí index.
     * Nếu index nằm ngoài đoạn [0, length] thì không thêm được.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public MyArrayPolynomial insert(double coefficient, int index) {
        if (size == coefficients.length) {
            enlarge();
        }
        for (int i = size; i > index; i--) {
            coefficients[i] = coefficients[i-1];
        }
        coefficients[index] = coefficient;
        size++;
        return this;
    }

    /**
     * Thay đổi hệ số của đa thức tại phần tử index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public MyArrayPolynomial set(double coefficient, int index) {
        checkIndex(index);
        coefficients[index] = coefficient;
        return this;
    }

    /**
     * Lấy bậc của đa thức.
     * @return bậc của đa thức.
     */
    @Override
    public int degree() {
        //Degree + 1 is the length of the array
        //1 + 2x + x^2 => degree = 2, size = 3
        return this.size - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return giá trị của đa thức.
     */
    @Override
    public double evaluate(double x) {
        double result = 0.0;
        for (int i = 0; i < this.size; i++) {
            //i = 0 - a0 => result += a0 * x^0
            //i = 1 - a1 => result += a1 * x^1
            //i = 2 - a2 => result += a2 * x^2
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ArrayPolynomial là đa thức đạo hàm của đa thức hiện tại.
     */
    @Override
    public MyPolynomial derivative() {
        return new MyArrayPolynomial(differentiate());
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     * @param another
     * @return đa thức hiện tại.
     */
    public MyArrayPolynomial plus(MyArrayPolynomial another) {
        if (this.degree() != another.degree()) {
            throw new RuntimeException("Unequal degree");
        }
        for (int i = 0; i < this.size; i++) {
            coefficients[i] += another.coefficient(i);
        }
        return this;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public MyArrayPolynomial minus(MyArrayPolynomial another) {
        if (this.degree() != another.degree()) {
            throw new RuntimeException("Unequal degree");
        }
        for (int i = 0; i < this.size; i++) {
            coefficients[i] -= another.coefficient(i);
        }
        return this;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public MyArrayPolynomial multiply(MyArrayPolynomial another) {
        int firstLength = this.size;
        int secondLength = another.degree() + 1;
        double[] result = new double[firstLength + secondLength - 1];
        //First polynomial loop
        for (int i = 0; i < firstLength; i++) {
            //Second polynomial loop
            for (int j = 0; j < secondLength; j++) {
                //We do not call coefficient(int index) to save time of calling a function
                result[i+j] += coefficients[i] * another.coefficient(j);
            }
        }
        this.coefficients = result;
        this.size = result.length;
        return this;
    }

    /**
     * Tăng kích thước gấp đôi để lưu đa thức khi cần thiết.
     */
    private void enlarge() {
        //We can use either size or length(of coefficient array) doubled because when we call enlarge, size == length
        this.coefficients = Arrays.copyOf(coefficients, size * 2);
    }
}
