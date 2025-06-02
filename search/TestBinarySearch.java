package search;

import java.util.Arrays;
import java.util.Random;

public class TestBinarySearch {
    public static void main(String[] args) {
        /* Yêu cầu:
        - Sinh ra ngẫu nhiên một số tự nhiên có giá trị nằm trong khoảng [20 - 30].
        - Sinh ra ngẫu nhiên một mảng các số kiểu double, có kích thước bằng số tự nhiên đã sinh ngẫu nhiên ở trên.
        - Tạo đối tượng có kiểu dữ liệu BinarySearch. Dùng đối tượng này test thuật toán tìm kiếm nhị phân với
          mảng dữ liệu đã sinh ra, và sử dụng 3 thuật toán sắp xếp khác nhau như đã cho.

          Các kết quả test được in ra terminal theo định dạng: ví dụ
          Using Bubble Sort Algorithm:
          Before sorting: [5.0 4.0 3.0 2.0 1.0]
          After sorting: [1.0 2.0 3.0 4.0 5.0]
          Binary search giá trị 3.0: 2

          Using Insertion Sort Algorithm:
          Before sorting: [5.0 4.0 3.0 2.0 1.0]
          After sorting: [1.0 2.0 3.0 4.0 5.0]
          Binary search giá trị 6.0:-1

        - Kết quả chạy chương trình lưu vào file text được đặt tên <TenSinhVien_MaSinhVien_BinarySearch.txt.
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_BinarySearch>.zip (Ví dụ, NguyenVanA_123456_BinarySearch.zip),
          nộp lên classroom
         */
        Random random = new Random(1);
        final int MIN = 20;
        final int MAX = 30;
        int length = random.nextInt(MAX - MIN + 1) + MIN;
        BinarySearch binarySearch = BinarySearch.getInstance();
        double[] originalData = new double[length];
        for (int i = 0; i < length; i++) {
//            originalData[i] = random.nextDouble(MAX + 1);
            //Integer for the value of the array for better formatting in the output
            originalData[i] = random.nextInt(MAX + 1);
        }
        double lastValue = originalData[length - 1];

        System.out.println("---------------------------------");
        System.out.println("Using Selection Sort algorithm: ");
        System.out.println("Before sorting: " + Arrays.toString(originalData));
        double[] sortedData = Arrays.copyOf(originalData, length);
        int index = binarySearch.search(sortedData, lastValue);
        System.out.println("After sorting: " + Arrays.toString(sortedData));
        System.out.println("Binary search for value " + lastValue + " return " + index);

        System.out.println("---------------------------------");
        System.out.println("Using Insertion Sort algorithm: ");
        System.out.println("Before sorting: " + Arrays.toString(originalData));
        binarySearch.setSorter(new InsertionSort());
        sortedData = Arrays.copyOf(originalData,length);
        index = binarySearch.search(sortedData, lastValue);
        System.out.println("After sorting: " + Arrays.toString(sortedData));
        System.out.println("Binary search for value " + lastValue + " return " + index);

        System.out.println("---------------------------------");
        System.out.println("Using Bubble Sort algorithm: ");
        System.out.println("Before sorting: " + Arrays.toString(originalData));
        binarySearch.setSorter(new BubbleSort());
        sortedData = Arrays.copyOf(originalData,length);
        index = binarySearch.search(sortedData, lastValue);
        System.out.println("After sorting: " + Arrays.toString(sortedData));
        System.out.println("Binary search for value " + lastValue + " return " + index);

//        System.out.println("Value we want to search: " + lastValue); //checking if the result is correct
//        System.out.println("Data at sorted array at index 21: " + sortedData[index]);
    }
}
