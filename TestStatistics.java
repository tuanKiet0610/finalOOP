package hus.oop.statistics;

import java.util.Random;

public class TestStatistics {
    private Statistics statistics;
    private Random rand = new Random();

    public TestStatistics(Statistics statistics) {
        /* TODO */
        this.statistics = statistics;
    }

    public static void main(String[] args) {
        /* TODO
           - Thực hiện từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
             là <TenSinhVien_MaSinhVien_Statistics>.txt (Ví dụ, NguyenVanA_123456_Statistics.txt).
           - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
             <TenSinhVien_MaSinhVien_Statistics>.zip (Ví dụ, NguyenVanA_123456_Statistics.zip),
             nộp lên classroom.
         */
        TestStatistics test = new TestStatistics(null);
        test.testMyArrayList();
        test.testMyLinkedList();
    }

    public void testMyArrayList() {
        /* TODO
           - Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu vào biến length.
           - Tạo một list kiểu MyArrayList, có các phần tử dữ liệu kiểu double được sinh ngẫu nhiên
             nằm trong đoạn [1, 20]. Tạo Statistics có dữ liệu là list dữ liệu vừa tạo, lưu vào statistics.
           - Sử dụng Statistics để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai, rank, sắp xếp, tìm kiếm).
             In ra terminal tập dữ liệu, tập dữ liệu được sắp xếp, các đại lượng thống kê và kết quả chức năng tìm kiếm.
         */
        int length = rand.nextInt(21) + 30;
        MyArrayList list = new MyArrayList();
        for (int i = 0; i < length; i++) {
            list.add(rand.nextInt(20) + 1);
        }
        statistics = new Statistics(list);

        System.out.println("Data: " + list);
        System.out.println("Sorted: " + list.sortIncreasing());
        System.out.println("Max: " + statistics.max());
        System.out.println("Min: " + statistics.min());
        System.out.println("Mean: " + statistics.mean());
        System.out.println("Variance: " + statistics.variance());
        System.out.println("Ranks: " + java.util.Arrays.toString(statistics.rank()));
        System.out.println("Search for 10: " + statistics.search(10));
    }

    public void testMyLinkedList() {
        /* TODO
           - Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu vào biến length.
           - Tạo một list kiểu MyLinkedList, có các phần tử lưu dữ liệu kiểu double được sinh ngẫu nhiên
             nằm trong đoạn [1, 20]. Tạo Statistics có dữ liệu là list dữ liệu vừa tạo, lưu vào statistics.
           - Sử dụng Statistics để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai, rank, sắp xếp, tìm kiếm).
             In ra terminal tập dữ liệu, tập dữ liệu được sắp xếp, các đại lượng thống kê và kết quả chức năng tìm kiếm.
         */
        int length = rand.nextInt(21) + 30;
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < length; i++) {
            list.add(rand.nextInt(20) + 1);
        }
        statistics = new Statistics(list);

        System.out.println("Data: " + list);
        System.out.println("Sorted: " + list.sortIncreasing());
        System.out.println("Max: " + statistics.max());
        System.out.println("Min: " + statistics.min());
        System.out.println("Mean: " + statistics.mean());
        System.out.println("Variance: " + statistics.variance());
        System.out.println("Ranks: " + java.util.Arrays.toString(statistics.rank()));
        System.out.println("Search for 10: " + statistics.search(10));
    }
}
