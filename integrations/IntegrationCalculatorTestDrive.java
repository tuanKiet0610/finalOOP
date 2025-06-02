package integrations;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class IntegrationCalculatorTestDrive {
    public static void main(String[] args) throws FileNotFoundException {
        /*
         TODO

         - Viết chương trình test các chức năng của đa thức và các phương pháp tính tích phân.

         - Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_Integration>.txt
           (ví dụ, NguyenVanA_123456_Integration.txt)
         - Nộp file kết quả chạy chương trình (file text trên) cùng với các file source code.
         */
        PrintStream out = new PrintStream(new FileOutputStream("Phantanson_20002090_intergration.txt"));
        System.setOut(out);

        System.out.println("Test Polinomial: ");
        testPolynomial();
        System.out.println("Test intergration calculator: ");
        testIntegrationCalculator();
    }

    public static void testPolynomial() {
        /*
         TODO

         - Tạo ra các đá thức kiểu ArrayPolynomial và ListPolynomial.
         - Viết chương trình test các chức năng của đa thức (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         - In kết quả ra terminal mỗi lần thực hiện các chức năng.
         */

        Polynomial polynomial1 = new ArrayPolynomial();
        polynomial1.insertAtEnd(1);
        polynomial1.insertAtEnd(2);
        polynomial1.insertAtEnd(3);
        System.out.println("Poly 1: " + polynomial1);
        polynomial1.set(2, 0);
        System.out.println("Poly after set: " + polynomial1);
        Polynomial polynomial2 = new ListPolynomial();
        polynomial2.insertAtEnd(1);
        polynomial2.insertAtEnd(2);
        polynomial2.insertAtEnd(3);
        System.out.println("Poly 2: " + polynomial2);
        Polynomial addPoly = polynomial1.plus(polynomial2);
        System.out.println("Add two poly: "+ addPoly);
        Polynomial minusPoly = polynomial1.minus(polynomial2);
        System.out.println("Minus two poly: "+ minusPoly);
        Polynomial multiPoly = polynomial1.multiply(polynomial2);
        System.out.println("Multiply two poly: "+ multiPoly);
    }

    public static void testIntegrationCalculator() {
        /*
         TODO

         - Tạo một đa thức.
         - Viết demo chương trình tính tích phân xác định của đa thức theo các phương pháp đã cho (MidpointRule, TrapezoidRule, SimpsonRule) sử dụng
           IntegrationCalculator. Các phương pháp tính tích phân có thể thay đổi ở thời gian chạy chương trình.
         - In ra thông tin phương pháp sử dụng, đa thức, và giá trị tích phân của đa thức.
         */

        Polynomial polynomial = new ListPolynomial();
        polynomial.insertAtEnd(1);
        polynomial.insertAtEnd(2);
        polynomial.insertAtEnd(3);
        polynomial.insertAtEnd(4);
        System.out.println("Original: " + polynomial);

        double precision = 20;
        int maxIterations = 100;
        int lower = 2;
        int upper = 3;
        IntegrationCalculator calculator = new IntegrationCalculator(polynomial);
        System.out.println("Integration calc using midpoint approach: ");
        Integrator midpoint = new MidpointRule(precision, maxIterations);
        calculator.setIntegrator(midpoint);
        double result1 = calculator.integrate(lower, upper);
        System.out.println("Answer: " + result1);

        System.out.println("Integration calc using simpson approach: ");
        Integrator simpson = new SimpsonRule(precision, maxIterations);
        calculator.setIntegrator(simpson);
        double result2 = calculator.integrate(lower, upper);
        System.out.println("Answer: " + result2);


        System.out.println("Integration calc using trapezoid approach: ");
        Integrator trapezoid = new TrapezoidRule(precision, maxIterations);
        calculator.setIntegrator(trapezoid);
        double result3 = calculator.integrate(lower, upper);
        System.out.println("Answer: " + result3);

    }
}
