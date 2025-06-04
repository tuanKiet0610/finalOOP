package hus.oop.fraction;

import java.util.Random;

public class TestFraction {
    private MyDataSet myDataSet;
    private Random rand = new Random();

    public TestFraction(MyDataSet myDataSet) {
        /* TODO */
        this.myDataSet = myDataSet;
    }

    public static void main(String[] args) {
        /* TODO:
         - Viết code cho các hàm test.
         - Chạy chương trình và lưu kết quả chạy chương trình và file text được đặt tên
           là <TenSinhVien_MaSinhVien_MyFractions>.txt (Ví dụ, NguyenVanA_123456_MyFractions.txt).
         - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
           <TenSinhVien_MaSinhVien_MyFractions>.zip (Ví dụ, NguyenVanA_123456_MyFractions.zip),
           nộp lên classroom.
         */
        TestFraction test = new TestFraction(null);
        test.testMyArrayDataSet();
        test.testMyListDataSet();

    }

    public void testMyArrayDataSet() {
        /* TODO
        1. Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu giá trị vào biến numbers.
        2. Tạo ra numbers phân số, trong đó tử số và mẫu số được sinh ngẫu nhiên là các số tự nhiên nằm trong đoạn [1, 100].
           Lưu các phân số vào trong một tập dữ liệu myDataSet dùng MyArrayDataSet.

        3. Sắp xếp và in ra tập dữ liệu đã tạo ra theo các tiêu chí sau:
             - In ra các phân số theo thứ tự có giá trị tăng dần, nếu phân số bằng nhau thì được sắp xếp theo thứ tự
               có giá trị tăng dần của mẫu số.
             - In ra các phân số theo thứ tự có giá trị giảm dần, nếu phân số bằng nhau thì được sắp xếp theo thứ tự
               có giá trị giảm dần của mẫu số.

         4. In ra các dữ liệu sau:
             - In ra các phân số tối giản của các phân số đã tạo ra theo thứ tự trong dữ liệu gốc.
             - In ra các phân số tối giản theo thứ tự tăng dần.
             - In ra các phân số tối giản theo thứ tự giảm dần.
        */

        int numbers = rand.nextInt(21) + 30;
        MyArrayDataSet dataSet = new MyArrayDataSet();

        for (int i = 0; i < numbers; i++) {
            int numerator = rand.nextInt(100) + 1;
            int denominator = rand.nextInt(100) + 1;
            dataSet.append(new MyFraction(numerator, denominator));
        }

        System.out.println("Original ArrayDataSet:");
        dataSet.print();

        System.out.println("Sorted Increasing:");
        dataSet.sortIncreasing().print();

        System.out.println("Sorted Decreasing:");
        dataSet.sortDecreasing().print();

        System.out.println("Simplified:");
        dataSet.toSimplify().print();

        System.out.println("Simplified and Sorted Increasing:");
        dataSet.toSimplify().sortIncreasing().print();

        System.out.println("Simplified and Sorted Decreasing:");
        dataSet.toSimplify().sortDecreasing().print();
    }

    public void testMyListDataSet() {
        /* TODO
        1. Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu giá trị vào biến numbers.
        2. Tạo ra numbers phân số, trong đó tử số và mẫu số được sinh ngẫu nhiên là các số tự nhiên nằm trong đoạn [1, 100].
           Lưu các phân số vào trong một tập dữ liệu myDataSet dùng MyListDataSet.

        3. Sắp xếp và in ra tập dữ liệu đã tạo ra theo các tiêu chí sau:
             - In ra các phân số theo thứ tự có giá trị tăng dần, nếu phân số bằng nhau thì được sắp xếp theo thứ tự
               có giá trị tăng dần của mẫu số.
             - In ra các phân số theo thứ tự có giá trị giảm dần, nếu phân số bằng nhau thì được sắp xếp theo thứ tự
               có giá trị giảm dần của mẫu số.

         4. In ra các dữ liệu sau:
             - In ra các phân số tối giản của các phân số đã tạo ra theo thứ tự trong dữ liệu gốc.
             - In ra các phân số tối giản theo thứ tự tăng dần.
             - In ra các phân số tối giản theo thứ tự giảm dần.
        */
        Random rand = new Random();
        int numbers = rand.nextInt(21) + 30;
        MyListDataSet dataSet = new MyListDataSet();

        for (int i = 0; i < numbers; i++) {
            int numerator = rand.nextInt(100) + 1;
            int denominator = rand.nextInt(100) + 1;
            dataSet.append(new MyFraction(numerator, denominator));
        }

        System.out.println("Original ListDataSet:");
        dataSet.print();

        System.out.println("Sorted Increasing:");
        dataSet.sortIncreasing().print();

        System.out.println("Sorted Decreasing:");
        dataSet.sortDecreasing().print();

        System.out.println("Simplified:");
        dataSet.toSimplify().print();

        System.out.println("Simplified and Sorted Increasing:");
        dataSet.toSimplify().sortIncreasing().print();

        System.out.println("Simplified and Sorted Decreasing:");
        dataSet.toSimplify().sortDecreasing().print();
    }
}
