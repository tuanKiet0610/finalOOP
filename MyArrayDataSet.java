package hus.oop.fraction;

public class MyArrayDataSet implements MyDataSet {
    private static int DEFAULT_CAPACITY = 16;
    private MyFraction[] fractions;
    private int length;

    /**
     * Hàm dựng khởi tạo mảng chứa các phân số có kích thước là DEFAULT_CAPACITY.
     */
    public MyArrayDataSet() {
        /* TODO */
        fractions = new MyFraction[DEFAULT_CAPACITY];
        length = 0;
    }

    /**
     * Hàm dựng khởi tạo mảng chứa các phân số truyền vào.
     * @param fractions
     */
    public MyArrayDataSet(MyFraction[] fractions) {
        /* TODO */
        this.fractions = new MyFraction[Math.max(DEFAULT_CAPACITY, fractions.length * 2)];
        this.length = 0;
        for (MyFraction fraction : fractions) {
            this.fractions[length++] = new MyFraction(fraction);
        }

    }

    /**
     * Phương thức chèn phân số fraction vào vị trí index.
     * Nếu index nằm ngoài đoạn [0, length] thì không chèn được vào.
     * Nếu mảng hết chỗ để thêm dữ liệu, mở rộng kích thước mảng gấp đôi.
     * @param fraction là một phân số.
     * @return true nếu chèn được số vào, false nếu không chèn được số vào.
     */
    @Override
    public boolean insert(MyFraction fraction, int index) {
        /* TODO */
        if (!checkBoundaries(index, length)) {
            return false;
        }
        if (length >= fractions.length) {
            allocateMore();
        }
        // Dịch chuyển các phần tử sang phải
        System.arraycopy(fractions, index, fractions, index + 1, length - index);
        fractions[index] = new MyFraction(fraction); // Thêm mới
        length++;
        return true;
    }

    /**
     * Phương thức thêm phân số fraction vào vị trí cuối cùng chưa có dứ liệu của mảng data.
     * Nếu mảng hết chỗ để thêm dữ liệu, mở rộng kích thước mảng gấp đôi.
     * @param fraction
     * @return true nếu chèn được số vào, false nếu không chèn được số vào.
     */
    @Override
    public boolean append(MyFraction fraction) {
        /* TODO */
        if (length >= fractions.length) {
            allocateMore();
        }
        fractions[length++] = new MyFraction(fraction);
        return true;
    }

    @Override
    public MyArrayDataSet toSimplify() {
        /* TODO */
        MyFraction[] simplifiedFractions = new MyFraction[length];
        for (int i = 0; i < length; i++) {
            simplifiedFractions[i] = new MyFraction(fractions[i]);
            simplifiedFractions[i].simplify();
        }
        return new MyArrayDataSet(simplifiedFractions);

    }

    @Override
    public MyArrayDataSet sortIncreasing() {
        /* TODO */
        MyFraction[] sorted = new MyFraction[length];
        for (int i = 0; i < length; i++) {
            sorted[i] = new MyFraction(fractions[i]);
        }
        java.util.Arrays.sort(sorted, (f1, f2) -> {
            int cmp = Double.compare(f1.doubleValue(), f2.doubleValue());
            if (cmp == 0) {
                return Integer.compare(f1.getDenominator(), f2.getDenominator());
            }
            return cmp;
        });
        return new MyArrayDataSet(sorted);
    }

    @Override
    public MyArrayDataSet sortDecreasing() {
        /* TODO */
        MyFraction[] sorted = new MyFraction[length];
        for (int i = 0; i < length; i++) {
            sorted[i] = new MyFraction(fractions[i]);
        }
        java.util.Arrays.sort(sorted, (f1, f2) -> {
            int cmp = Double.compare(f2.doubleValue(), f1.doubleValue());
            if (cmp == 0) {
                return Integer.compare(f2.getDenominator(), f1.getDenominator());
            }
            return cmp;
        });
        return new MyArrayDataSet(sorted);
    }

    @Override
    public String myDataSetToString() {
        /* TODO */
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < length; i++) {
            sb.append(fractions[i]);
            if (i < length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    @Override
    public void print() {
        /* TODO */
        System.out.println(myDataSetToString());
    }

    /**
     * Phương thức mở rộng kích thước mảng gấp đôi, bằng cách tạo ra mảng mới có kích thước
     * gấp đôi, sau đó copy dự liệu từ mảng cũ vào.
     */
    private void allocateMore() {
        /* TODO */
        MyFraction[] newFractions = new MyFraction[fractions.length * 2];
        System.arraycopy(fractions, 0, newFractions, 0, fractions.length);
        fractions = newFractions;
    }

    /**
     * Phương thức kiểm tra xem index có nằm trong khoảng [0, upperBound] hay không.
     * @param index
     * @param upperBound
     * @return true nếu index nằm trong khoảng [0, upperBound], false nếu ngược lại.
     */
    private boolean checkBoundaries(int index, int upperBound) {
        /* TODO */
        return index >= 0 && index < upperBound;
    }
}
