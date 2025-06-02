package fraction;

import java.util.Arrays;

public class DataSet {
    private static final int DEFAULT_CAPACITY = 8;
    private Fraction[] data;
    private int length;

    /**
     * Hàm dựng khởi tạo mảng chứa các phân số có kích thước là DEFAULT_CAPACITY.
     */
    public DataSet() {
        this.data = new Fraction[DEFAULT_CAPACITY];
        this.length = 0;
    }

    /**
     * Hàm dựng khởi tạo mảng chứa các phân số theo data.
     * @param data
     */
    public DataSet(Fraction[] data) {
        this.data = data;
        this.length = data.length;
    }

    /**
     * Phương thức chèn phân số fraction vào vị trí index.
     * Nếu index nằm ngoài đoạn [0, length] thì không chèn được vào.
     * Nếu mảng hết chỗ để thêm dữ liệu, mở rộng kích thước mảng gấp đôi.
     * @param fraction là một phân số.
     * @return true nếu chèn được số vào, false nếu không chèn được số vào.
     */
    public boolean insert(Fraction fraction, int index) {
        if (!checkBoundaries(index, length)) {
            return false;
        }
        if (length >= data.length) {
            enlarge();
        }
        for (int i = length; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = fraction;
        length++;
        return true;
    }

    /**
     * Phương thức tạo ra một tập dữ liệu lưu các phân số tối giản của các phân số trong tập dữ liệu gốc.
     * @return tập dữ liệu mới lưu các phân số tối giản của các phân số trong tập dữ liệu gốc.
     */
    public DataSet toSimplify() {
        Fraction[] simplifiedData = new Fraction[length];
        for (int i = 0; i < length; i++) {
            Fraction simplified = new Fraction(data[i]);
            simplified.simplify();
            simplifiedData[i] = simplified;
        }
        return new DataSet(simplifiedData);
    }

    /**
     * Phương thức thêm phân số fraction vào vị trí cuối cùng chưa có dữ liệu của mảng data.
     * Nếu mảng hết chỗ để thêm dữ liệu, mở rộng kích thước mảng gấp đôi.
     * @param fraction
     * @return
     */
    public void append(Fraction fraction) {
        if (length >= data.length) {
            enlarge();
        }
        data[length] = fraction;
        length++;
    }

    /**
     * Sắp xếp mảng các phân số theo thứ tự có giá trị tăng dần.
     * Nếu hai phân số bằng nhau thì sắp xếp theo thứ tự có mẫu số tăng dần.
     * @return mảng mới được sắp xếp theo thứ tự có giá trị tăng dần.
     */
    public Fraction[] sortIncreasing() {
        Fraction[] sortedData = Arrays.copyOf(data, length);
        Arrays.sort(sortedData, (f1, f2) -> {
            int result = f1.compareTo(f2);
            if (result == 0) {
                return Integer.compare(f1.getDenominator(), f2.getDenominator());
            }
            return result;
        });
        return sortedData;
    }

    /**
     * Sắp xếp mảng các phân số theo thứ tự có giá trị giảm dần.
     * Nếu hai phân số bằng nhau thì sắp xếp theo thứ tự có mẫu số giảm dần.
     * @return mảng mới được sắp xếp theo thứ tự có giá trị giảm dần.
     */
    public Fraction[] sortDecreasing() {
        Fraction[] sortedData = Arrays.copyOf(data, length);
        Arrays.sort(sortedData, (f1, f2) -> {
            int result = f2.compareTo(f1);
            if (result == 0) {
                return Integer.compare(f2.getDenominator(), f1.getDenominator());
            }
            return result;
        });
        return sortedData;
    }

    /**
     * Phương thức mở rộng kích thước mảng gấp đôi, bằng cách tạo ra mảng mới có kích thước
     * gấp đôi, sau đó copy dự liệu từ mảng cũ vào.
     */
    private void enlarge() {
        Fraction[] newData = new Fraction[data.length * 2];
        System.arraycopy(data, 0, newData, 0, length);
        data = newData;
    }

    /**
     * Phương thức kiểm tra xem index có nằm trong khoảng [0, upperBound] hay không.
     * @param index
     * @param upperBound
     * @return true nếu index nằm trong khoảng [0, upperBound], false nếu ngược lại.
     */
    private boolean checkBoundaries(int index, int upperBound) {
        return index >= 0 && index <= upperBound;
    }

    /**
     * In ra tập dữ liệu theo định dạng [a1, a2, ... , an].
     * @return
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < length; i++) {
            result.append(data[i]);
            if (i < length - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    /**
     * In ra mảng các phân số fractions theo định dạng [a1, a2, ... , an].
     * @param fractions
     */
    public static void printFractions(Fraction[] fractions) {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < fractions.length; i++) {
            result.append(fractions[i]);
            if (i < fractions.length - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        System.out.println(result);
    }
}
