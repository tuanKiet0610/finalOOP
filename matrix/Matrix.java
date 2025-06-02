package matrix;

import java.util.Arrays;
import java.util.Random;

public class Matrix {
    public double[][] data;

    /**
     * Hàm dựng, khởi tạo một ma trận có các phần tử được sinh ngẫu nhiên trong đoạn [1, 10]
     * @param rows số hàng, columns số cột
     */
    public Matrix(int rows, int columns) {
        initRandom(rows, columns);
    }

    /**
     * Phương thức khởi tạo ma trận, các phần tử của ma trận được sinh ngẫu nhiên trong đoạn [1, 10]
     * @param rows số hàng, columns số cột
     */
    private void initRandom(int rows, int columns) {
        data = new double[rows][columns];
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = 1 + rand.nextInt(10);
            }
        }
    }

    /**
     * Lấy giá trị phần tử ở vị trí (row, col).
     * @param row
     * @param col
     * @return
     */
    public double get(int row, int col) {
        return data[row][col];
    }

    /**
     * Sửa giá trị phần tử ở vị trí (row, col) thành value.
     * @param row
     * @param col
     * @param value
     */
    public void set(int row, int col, double value) {
        data[row][col] = value;
    }

    /**
     * Phương thức sắp xếp các phần tử của ma trận theo thứ tự tăng dần.
     * @return ma trận có các phần tử là phần tử của ma trận ban đầu được sắp xếp theo thứ tự tăng dần.
     * Các phần tử được sắp xếp theo thứ tự từ trái sang phải ở mỗi hàng, và từ trên xuống dưới.
     */
    public Matrix getSortedMatrix() {
        int rows = data.length;
        int columns = data[0].length;
        double[] temp = new double[rows * columns];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                temp[index++] = data[i][j];
            }
        }
        Arrays.sort(temp);
        Matrix sortedMatrix = new Matrix(rows, columns);
        index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sortedMatrix.set(i, j, temp[index++]);
            }
        }
        return sortedMatrix;
    }

    /**
     * Phương thức cộng ma trận hiện tại với một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận tổng của 2 ma trận.
     */
    public Matrix add(Matrix that) {
        int rows = data.length;
        int columns = data[0].length;
        Matrix result = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.set(i, j, this.get(i, j) + that.get(i, j));
            }
        }
        return result;
    }

    /**
     * Phương thức trừ ma trận hiện tại cho một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận hiệu của ma trận hiện tại và ma trận truyền vào.
     */
    public Matrix minus(Matrix that) {
        int rows = data.length;
        int columns = data[0].length;
        Matrix result = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.set(i, j, this.get(i, j) - that.get(i, j));
            }
        }
        return result;
    }

    /**
     * Phương thức nhân ma trận hiện tại với một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận nhân của ma trận hiện tại với ma trận truyền vào.
     */
    public Matrix multiply(Matrix that) {
        int rows = data.length;
        int columns = that.data[0].length;
        int commonDim = data[0].length;
        Matrix result = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                double sum = 0;
                for (int k = 0; k < commonDim; k++) {
                    sum += this.get(i, k) * that.get(k, j);
                }
                result.set(i, j, sum);
            }
        }
        return result;
    }

    /**
     * Phương thức nhân ma trận với một số vô hướng.
     * @param value
     * @return ma trận mới là ma trận hiện tại được nhân với một số vô hướng.
     */
    public Matrix scaled(int value) {
        int rows = data.length;
        int columns = data[0].length;
        Matrix result = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.set(i, j, this.get(i, j) * value);
            }
        }
        return result;
    }

    /**
     * Phương thức nhân hàng thứ rowIndex của ma trận với một số vô hướng.
     * @param value
     * @return ma trận mới là ma trận có hàng rowIndex bằng hàng rowIndex của ma trận hiện tại nhân với một số vô hướng.
     */
    public Matrix scaledRow(int value, int rowIndex) {
        int columns = data[0].length;
        for (int j = 0; j < columns; j++) {
            data[rowIndex][j] *= value;
        }
        return this;
    }

    /**
     * Phương thức nhân cột thứ columnIndex của ma trận với một số vô hướng.
     * @param value
     * @return ma trận mới là ma trận có cột columnIndex bằng cột columnIndex của ma trận hiện tại nhân với một số vô hướng.
     */
    public Matrix scaledColumn(int value, int columnIndex) {
        int rows = data.length;
        for (int i = 0; i < rows; i++) {
            data[i][columnIndex] *= value;
        }
        return this;
    }

    /**
     * Phương thức hoán đổi hai hàng của ma trận.
     * @param firstIndex
     * @param secondIndex
     */
    public void swapRows(int firstIndex, int secondIndex) {
        double[] temp = data[firstIndex];
        data[firstIndex] = data[secondIndex];
        data[secondIndex] = temp;
    }

    /**
     * Phương thức hoán đổi hai cột của ma trận.
     * @param firstIndex
     * @param secondIndex
     */
    public void swapColumns(int firstIndex, int secondIndex) {
        int rows = data.length;
        for (int i = 0; i < rows; i++) {
            double temp = data[i][firstIndex];
            data[i][firstIndex] = data[i][secondIndex];
            data[i][secondIndex] = temp;
        }
    }

    /**
     * Phương thức cộng hàng destIndex của ma trận với hàng sourceIndex của ma trận được nhân với một số value.
     * @param value
     * @param sourceIndex
     * @param destIndex
     */
    public void addRow(double value, int sourceIndex, int destIndex) {
        int columns = data[0].length;
        for (int j = 0; j < columns; j++) {
            data[destIndex][j] += data[sourceIndex][j] * value;
        }
    }

    /**
     * Phương thức cộng cột destIndex của ma trận với cột sourceIndex của ma trận được nhân với một số value.
     * @param value
     * @param sourceIndex
     * @param destIndex
     */
    public void addColumn(double value, int sourceIndex, int destIndex) {
        int rows = data.length;
        for (int i = 0; i < rows; i++) {
            data[i][destIndex] += data[i][sourceIndex] * value;
        }
    }

    /**
     * Phương thức lấy ma trận chuyển vị.
     * @return ma trận mới là ma trận chuyển vị của ma trận hiện tại.
     */
    public Matrix transpose() {
        int rows = data.length;
        int columns = data[0].length;
        Matrix result = new Matrix(columns, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.set(j, i, data[i][j]);
            }
        }
        return result;
    }

    /**
     * Phương thức lấy ra ma trận dạng hình thang theo hàng (row echelon form)
     * sau khi thực hiện phép khử Gauss.
     * @return ma trận dạng hình thang theo hàng.
     */
    public Matrix gaussianElimination() {
        int rows = data.length;
        int columns = data[0].length;
        Matrix result = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.set(i, j, data[i][j]);
            }
        }

        for (int i = 0; i < rows; i++) {
            if (result.get(i, i) == 0) {
                for (int j = i + 1; j < rows; j++) {
                    if (result.get(j, i) != 0) {
                        result.swapRows(i, j);
                        break;
                    }
                }
            }

            if (result.get(i, i) != 0) {
                for (int j = i + 1; j < rows; j++) {
                    double scaleFactor = result.get(j, i) / result.get(i, i);
                    for (int k = 0; k < columns; k++) {
                        result.set(j, k, result.get(j, k) - scaleFactor * result.get(i, k));
                    }
                }
            }
        }
        return result;
    }

    /**
     * Phương thức lấy ra ma trận dạng hình thang theo hàng rút gọn (reduced row echelon form)
     * sau khi thực hiện phép khử Gauss-Jordan
     * @return
     */
    public Matrix gaussJordanElimination() {
        Matrix result = gaussianElimination();
        int rows = result.data.length;
        int columns = result.data[0].length;

        for (int i = rows - 1; i >= 0; i--) {
            if (result.get(i, i) != 0) {
                double scaleFactor = result.get(i, i);
                for (int j = 0; j < columns; j++) {
                    result.set(i, j, result.get(i, j) / scaleFactor);
                }

                for (int j = i - 1; j >= 0; j--) {
                    scaleFactor = result.get(j, i);
                    for (int k = 0; k < columns; k++) {
                        result.set(j, k, result.get(j, k) - scaleFactor * result.get(i, k));
                    }
                }
            }
        }
        return result;
    }

    /**
     * Biểu diễn ma trận theo định dạng
     * a11 a12 ... a1n
     * a21 a22 ... a2n
     * ...
     * am1 am2 ... amn
     * @return một chuỗi biểu diễn ma trận.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double[] row : data) {
            for (double value : row) {
                sb.append(String.format("%.2f ", value));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
