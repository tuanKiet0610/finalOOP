package hus.oop.vector;


import java.util.Random;

public class TestVector {
    private MyVector vector;
    private Random random = new Random();

    public TestVector(MyVector vector) {
        this.vector = vector;
    }

    public static void main(String[] args) {
        /* TODO
           - Thực hiện các hàm test.
           - Lưu các kết quả chạy chương trình vào file text có tên <Ten_MaSinhVien_Vector>.txt
             (ví dụ NguyenVanA_123456_Vector.txt). Nén các file source code và file kết quả vào file zip có tên
             <Ten_MaSinhVien_Vector>.zip (ví dụ NguyenVanA_123456_Vector.zip), nộp lên classroom.
         */
        TestVector test = new TestVector(null);
        test.testArrayVector();
        test.testListVector();
    }

    public void testArrayVector() {
        /* TODO
         - Sinh ngẫu nhiên một số tự nhiên, lưu giá trị sinh ra vào biến n.
         - Tạo ra vector có kích thước n, với các phần tử được sinh ngẫu nhiên, lưu vào biến vector, sử dụng MyArrayVector.
         - Viết các các chứ năng của các vector, như thêm vào phần tử, xóa bớt phần tử, sửa giá trị các
           phần tử, cộng các vector, nhân vector với vô hướng, tích vô hướng 2 vector, chuẩn vector, ... Mỗi lần thay
           đổi vector hoặc tính toán, in các kết quả ra terminal.
         */
        int n = random.nextInt(5) + 5;
        MyArrayVector vector = new MyArrayVector();
        System.out.println("Creating vector of size " + n);
        for (int i = 0; i < n; i++) {
            double value = random.nextDouble() * 10;
            vector.insert(value);
        }
        System.out.println("Original Array Vector: " + vector);
        System.out.println("Norm: " + vector.norm());
        System.out.println("Add 5: " + vector.add(5));
        System.out.println("Scale 2: " + vector.scale(2));
        System.out.println("Pow 2: " + vector.pow(2));
    }

    public void testListVector() {
        /* TODO
         - Sinh ngẫu nhiên một số tự nhiên, lưu giá trị sinh ra vào biến n.
         - Tạo ra vector có kích thước n, với các phần tử được sinh ngẫu nhiên, lưu vào biến vector, sử dụng MyListVector.
         - Viết các các chứ năng của các vector, như thêm vào phần tử, xóa bớt phần tử, sửa giá trị các
           phần tử, cộng các vector, nhân vector với vô hướng, tích vô hướng 2 vector, chuẩn vector, ... Mỗi lần thay
           đổi vector hoặc tính toán, in các kết quả ra terminal.
         */
        int n = random.nextInt(10) + 5;
        MyListVector vector = new MyListVector();
        for (int i = 0; i < n; i++) {
            vector.insert(random.nextDouble() * 10);
        }
        System.out.println("Original List Vector: " + vector);
        System.out.println("Norm: " + vector.norm());
        System.out.println("Add 5: " + vector.add(5));
        System.out.println("Scale 2: " + vector.scale(2));
        System.out.println("Pow 2: " + vector.pow(2));
    }
}
