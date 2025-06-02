package fraction;

public class Fraction implements FractionComparable {
    private int numerator;
    private int denominator;

    /**
     * Hàm dựng khởi tạo giá trị mặc định là 1/1.
     */
    public Fraction() {
        this.numerator = 1;
        this.denominator = 1;
    }

    /**
     * Hàm dựng khởi tạo giá trị cho tử số và mẫu số.
     * @param numerator
     * @param denominator
     */
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
//        simplify();
    }

    /**
     * Hàm dựng copy, copy giá trị của phân số truyền vào.
     * @param copyFraction
     */
    public Fraction(Fraction copyFraction) {
        this.numerator = copyFraction.numerator;
        this.denominator = copyFraction.denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        simplify();
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.denominator = denominator;
        simplify();
    }

    /**
     * Phương thức trả về giá trị kiểu byte của phân số.
     * @return
     */
    public byte byteValue() {
        return (byte) doubleValue();
    }

    /**
     * Phương thức trả về giá trị kiểu int của phân số.
     * @return
     */
    public int intValue() {
        return (int) doubleValue();
    }

    /**
     * Phương thức trả về giá trị kiểu long của phân số.
     * @return
     */
    public long longValue() {
        return (long) doubleValue();
    }

    /**
     * Phương thức trả về giá trị kiểu short của phân số.
     * @return
     */
    public short shortValue() {
        return (short) doubleValue();
    }

    /**
     * Phương thức trả về giá trị kiểu double của phân số.
     * @return
     */
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    /**
     * Phương thức trả về giá trị kiểu float của phân số.
     * @return
     */
    public float floatValue() {
        return (float) doubleValue();
    }

    /**
     * Phương thức tính ước số chung lớn nhất của tử số và mẫu số.
     * @return ước số chung lớn nhất của tử số và mẫu số.
     */
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * Phương thức rút gọn phân số về phân số tối giản.
     */
    public void simplify() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    @Override
    public int compareTo(Fraction another) {
        double thisValue = this.doubleValue();
        double anotherValue = another.doubleValue();
        if (thisValue < anotherValue) {
            return -1;
        } else if (thisValue > anotherValue) {
            return 1;
        } else {
            return Integer.compare(this.denominator, another.denominator);
        }
    }

    /**
     * Phương thức mô tả phân số theo định dạng numerator/denominator;
     * @return
     */
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
