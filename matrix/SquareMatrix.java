package matrix;

public class SquareMatrix extends Matrix {

    /**
     * Hàm dựng, khởi tạo một ma trận có các phần tử được sinh ngẫu nhiên trong đoạn [1, 10]
     * @param size
     */
    public SquareMatrix(int size) {
        super(size, size);
    }

    /**
     * Phương thức lấy ra các phần tử trên đường chéo chính của ma trận.
     * @return đường chéo chính của ma trận.
     */
    public double[] principalDiagonal() {
        int size = data.length;
        double[] diagonal = new double[size];
        for (int i = 0; i < size; i++) {
            diagonal[i] = get(i, i);
        }
        return diagonal;
    }

    /**
     * Phương thức lấy ra các phần tử trên đường chéo phụ của ma trận.
     * @return đường chéo phụ của ma trận.
     */
    public double[] secondaryDiagonal() {
        int size = data.length;
        double[] diagonal = new double[size];
        for (int i = 0; i < size; i++) {
            diagonal[i] = get(i, size - i - 1);
        }
        return diagonal;
    }
}
