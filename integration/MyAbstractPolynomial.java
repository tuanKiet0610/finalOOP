package integration;

public abstract class MyAbstractPolynomial implements MyPolynomial {
    /**
     * Mô tả đa thức theo định dạng [a0 + a1x + a2x^2 + ... + anx^n]
     * @return String mô tả về đa thức.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < degree() + 1; i++) {
            sb.append(coefficient(i));
            if (i == 1) {
                sb.append("x");
            }
            else if (i >= 2) {
                sb.append("x^").append(i);
            }
            sb.append(" + ");
        }
        return sb.substring(0, sb.length() - 3) + "]";
    }

    /**
     * Lấy đạo hàm đa thức.
     * @return mảng các phần tử là hệ số của đa thức đạo hàm.
     */
    public double[] differentiate() {
        //[a0 + a1x + a2x^2 + ... + anx^n]
        //a1 + 2a2x + ... + nx^n-1
        double[] result = new double[degree()];
        for (int i = 0; i < result.length; i++) {
            result[i] = coefficient(i + 1) * (i + 1);
        }
        return result;
    }
    /**
     * Kiểm tra chỉ số có nằm ngoài giới hạn của mảng không
     * .Mặc dù ListPolynomial không dùng nhưng nếu sau này có mở rộng ra LinkedList hoặc 1 dạng ADT nào khác lưu dữ liệu
     * thì hàm này vẫn có tác dụng thay vì chỉ để trong class ArrayPolynomial
     * @throws IndexOutOfBoundsException
     */
    protected void checkIndex(int index) {

        //Degree + 1 is the length of the array
        //1 + 2x + x^2 => degree = 2, size = 3
        if (index < 0 || index > degree() + 1) {
            throw new IndexOutOfBoundsException();
        }
    }
}
