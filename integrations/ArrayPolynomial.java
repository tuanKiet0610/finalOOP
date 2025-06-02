package integrations;

public class ArrayPolynomial extends AbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] coefficents;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ArrayPolynomial() {
        this.coefficents = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Lấy hệ số của đa thức tại phần tử index
     * @return hệ số tại phần tử index.
     */
    @Override
    public double coefficient(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return coefficents[index];
    }

    /**
     * Lấy mảng các hệ số của đa thức.
     * @return mảng các hệ số của đa thức.
     */
    @Override
    public double[] coefficients() {
        double[] copy = new double[size];
        System.arraycopy(coefficents, 0, copy, 0, size);
        return copy;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào đầu đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial insertAtStart(double coefficient) {
        if (size == coefficients().length) {
            enlarge();
        }
        coefficents[size++] = coefficient;
        return this;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào cuối đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial insertAtEnd(double coefficient) {
        if (size == coefficients().length) {
            enlarge();
        }
        coefficents[size++] = coefficient;
        return this;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial insertAtPosition(double coefficient, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (size == coefficents.length) {
            enlarge();
        }
        System.arraycopy(coefficents, index, coefficents, index + 1, size - index);
        coefficents[index] = coefficient;
        size++;
        return this;
    }

    /**
     * Thay đổi hệ số của đa thức tại phần tử index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial set(double coefficient, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        coefficents[index] = coefficient;
        return this;
    }

    /**
     * Lấy bậc của đa thức.
     * @return bậc của đa thức.
     */
    @Override
    public int degree() {
        return size - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return giá trị của đa thức.
     */
    @Override
    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < size; i++) {
            result += coefficents[i] * Math.pow(x, i);
        }
        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ArrayPolynomial là đa thức đạo hàm của đa thức hiện tại.
     */
    @Override
    public ArrayPolynomial derivative() {
        ArrayPolynomial result = new ArrayPolynomial();
        int n = degree();
        for (int i = 0; i <= n; i++) {
            double newCoefficient = coefficents[i] * i;
            result.insertAtEnd(newCoefficient);
        }
        return result;
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     * @param another
     * @return đa thức mới là tổng hai đa thức.
     */
    public ArrayPolynomial plus(Polynomial another) {
        ArrayPolynomial result = new ArrayPolynomial();
        int maxSize = Math.max(this.size, another.degree() + 1);
        for (int i = 0; i < maxSize; i++) {
            double coefficient = (i < this.size) ? this.coefficents[i] : 0;
            double otherCoefficient = (i < another.degree() + 1) ? another.coefficients()[i] : 0;
            result.insertAtEnd(coefficient + otherCoefficient);
        }
        return result;
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial plusTo(Polynomial another) {
        ArrayPolynomial result = new ArrayPolynomial();
        int maxSize = Math.max(this.size, another.degree() + 1);
        for (int i = 0; i < maxSize; i++) {
            double coefficient = (i < this.size) ? this.coefficents[i] : 0;
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
    public ArrayPolynomial minus(Polynomial another) {
        ArrayPolynomial result = new ArrayPolynomial();
        int maxSize = Math.max(this.size, another.degree() + 1);
        for (int i = 0; i < maxSize; i++) {
            double coefficient = (i < this.size) ? this.coefficents[i] : 0;
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
    public ArrayPolynomial minusFrom(Polynomial another) {
        ArrayPolynomial result = new ArrayPolynomial();
        int maxSize = Math.max(this.size, another.degree() + 1);
        for (int i = 0; i < maxSize; i++) {
            double coefficient = (i < this.size) ? this.coefficents[i] : 0;
            double otherCoefficient = (i < another.degree() + 1) ? another.coefficients()[i] : 0;
            result.insertAtEnd(coefficient - otherCoefficient);
        }
        return result;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức mới là đa thức nhân của hai đa thức.
     */
    public ArrayPolynomial multiply(Polynomial another) {
        ArrayPolynomial result = new ArrayPolynomial();
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < another.degree() + 1; j++) {
                int newDegree = i + j;
                double newCoefficient = this.coefficents[i] * another.coefficients()[j];
                if (newDegree >= result.size) {
                    for (int k = result.size; k <= newDegree; k++) {
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
    public ArrayPolynomial multiplyBy(Polynomial another) {
        ArrayPolynomial result = new ArrayPolynomial();
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < another.degree() + 1; j++) {
                int newDegree = i + j;
                double newCoefficient = this.coefficents[i] * another.coefficients()[j];
                if (newDegree >= result.size) {
                    for (int k = result.size; k <= newDegree; k++) {
                        result.insertAtEnd(0);
                    }
                }
                result.set(result.coefficient(newDegree) + newCoefficient, newDegree);
            }
        }
        return result;
    }

    /**
     * Thêm kích thước để lưu đa thức khi cần thiết.
     */
    private void enlarge() {
        int newCapacity = coefficents.length * 2;
        double[] newCoefficients = new double[newCapacity];
        System.arraycopy(coefficents, 0, newCoefficients, 0, size);
        coefficents = newCoefficients;
    }
}
