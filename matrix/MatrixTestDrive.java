package matrix;

import java.util.Random;

public class MatrixTestDrive {
    public static void main(String[] args) {
        Random rand = new Random();
        int size = 5 + rand.nextInt(6);  // Kích thước ngẫu nhiên từ 5 đến 10

        SquareMatrix matrix1 = new SquareMatrix(size);
        SquareMatrix matrix2 = new SquareMatrix(size);

        System.out.println("Matrix 1:");
        System.out.println(matrix1);

        System.out.println("Matrix 1 Transpose:");
        System.out.println(matrix1.transpose());

        System.out.println("Matrix 2:");
        System.out.println(matrix2);

        System.out.println("Matrix 2 Transpose:");
        System.out.println(matrix2.transpose());

        System.out.println("Principal Diagonal of Matrix 1:");
        for (double value : matrix1.principalDiagonal()) {
            System.out.print(value + " ");
        }
        System.out.println();

        System.out.println("Secondary Diagonal of Matrix 1:");
        for (double value : matrix1.secondaryDiagonal()) {
            System.out.print(value + " ");
        }
        System.out.println();

        System.out.println("Principal Diagonal of Matrix 2:");
        for (double value : matrix2.principalDiagonal()) {
            System.out.print(value + " ");
        }
        System.out.println();

        System.out.println("Secondary Diagonal of Matrix 2:");
        for (double value : matrix2.secondaryDiagonal()) {
            System.out.print(value + " ");
        }
        System.out.println();

        System.out.println("Sum of Matrix 1 and Matrix 2:");
        System.out.println(matrix1.add(matrix2));

        System.out.println("Difference of Matrix 1 and Matrix 2:");
        System.out.println(matrix1.minus(matrix2));

        System.out.println("Product of Matrix 1 and Matrix 2:");
        System.out.println(matrix1.multiply(matrix2));

        System.out.println("Row Echelon Form of Matrix 1:");
        System.out.println(matrix1.gaussianElimination());

        System.out.println("Row Echelon Form of Matrix 2:");
        System.out.println(matrix2.gaussianElimination());

        System.out.println("Reduced Row Echelon Form of Matrix 1:");
        System.out.println(matrix1.gaussJordanElimination());

        System.out.println("Reduced Row Echelon Form of Matrix 2:");
        System.out.println(matrix2.gaussJordanElimination());
    }
}
