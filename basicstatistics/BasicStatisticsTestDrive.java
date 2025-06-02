package basicstatistics;

public class BasicStatisticsTestDrive {
    public static void main(String[] args) {
        /*
           - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
             là <TenSinhVien_MaSinhVien_BasicStatistics>.txt (Ví dụ, NguyenVanA_123456_BasicStatistics.txt).
           - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
             <TenSinhVien_MaSinhVien_BasicStatistics>.zip (Ví dụ, NguyenVanA_123456_BasicStatistics.zip),
             nộp lên classroom.
         */
        testMyArrayList();
        System.out.println("******************************************");
        testMyLinkedList();
    }

    public static void testMyArrayList() {
        /*
           - Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu vào biến length.
           - Tạo một danh sách kiểu MyArrayList có các phần tử dữ liệu kiểu Double, các giá trị của phần
             tử được sinh ngẫu nhiên nằm trong đoạn [1, 20].
           - Sử dụng BasicStatistic để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai).
             In ra các dữ liệu và các đại lượng thống kê.
         */

        // Generate a random number between 30 and 50 for the length of the list
        int length = 30 + (int)(Math.random() * 21);  // [30, 50]

        // Create an instance of MyArrayList and populate it with random double values between 1 and 20
        MyList arrayList = new MyArrayList();
        for (int i = 0; i < length; i++) {
            double value = 1 + Math.random() * 19;  // [1, 20]
            arrayList.append(value);
        }

        // Use BasicStatistic to calculate and print basic statistics
        BasicStatistic stats = new BasicStatistic(arrayList);
        System.out.println("ArrayList Data: " + arrayList);
        System.out.println("Max: " + stats.max());
        System.out.println("Min: " + stats.min());
        System.out.println("Mean: " + stats.mean());
        System.out.println("Variance: " + stats.variance());
    }

    public static void testMyLinkedList() {
        /*
           - Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu vào biến length.
           - Tạo ra một danh sách kiểu MyLinkedList có các phần tử dữ liệu kiểu Double, các giá trị của phần
             tử được sinh ngẫu nhiên nằm trong đoạn [1, 20].
           - Sử dụng BasicStatistic để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai).
             In ra terminal các thông tin về dữ liệu và các đại lượng thống kê.
         */

        // Create an instance of MyArrayList and populate it with random double values between 1 and 20
        int length = 30 + (int)(Math.random() * 21);
        MyList arrayList = new MyLinkedList();
        for (int i = 0; i < length; i++) {
            double value = 1 + Math.random() * 19;  // [1, 20]
            arrayList.append(value);
        }

        // Use BasicStatistic to calculate and print basic statistics
        BasicStatistic stats = new BasicStatistic(arrayList);
        System.out.println("LinkedList Data: " + arrayList);
        System.out.println("Max: " + stats.max());
        System.out.println("Min: " + stats.min());
        System.out.println("Mean: " + stats.mean());
        System.out.println("Variance: " + stats.variance());
    }
}
