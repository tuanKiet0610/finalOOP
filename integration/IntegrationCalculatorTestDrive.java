package integration;

public class IntegrationCalculatorTestDrive {
    public static void main(String[] args) {
        /*
           - Chạy demo các hàm test.
           - Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_Integration>.txt
             (ví dụ, NguyenVanA_123456_Integration.txt)
           - Nộp file kết quả chạy chương trình (file text trên) cùng với các file source code.
         */
        System.out.println("------------Testing MyArrayPolynomial------------");
        testArrayPolynomial();
        System.out.println("------------Testing MyListPolynomial------------");
        testListPolynomial();
        System.out.println("------------Testing IntegrationCalculator------------");
        testIntegrationCalculator();
    }

    public static void testArrayPolynomial() {
        /*
           - Tạo ra các đa thức MyArrayPolynomial, trong đó bậc của đa thức là số tự nhiên được sinh ngẫu nhiên trong đoạn [1, 10],
             và các hệ số của đa thức được sinh ngẫu nhiên trong đoạn [1, 10].
           - Viết chương trình test các chức năng của MyArrayPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
             sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
             giá trị của x).
         */
        MyArrayPolynomial basicPoly1 = new MyArrayPolynomial();
        //1 + 3x + 3x^2 + x^3 = (x+1)^3
        basicPoly1.append(1);
        basicPoly1.append(3);
        basicPoly1.append(3);
        basicPoly1.append(1);
        System.out.println("(x+1)^3 = " + basicPoly1);
        System.out.println("Degree of (x+1)^3 = " + basicPoly1.degree());
        System.out.println("Getting a2 at x^2 = " + basicPoly1.coefficient(2));
        basicPoly1.set(100.5, 1);
        System.out.println("Changing a1 = 3 at x to a1 = 100.5: " + basicPoly1);
        basicPoly1.set(3, 1);
        System.out.println("Evaluating (x+1)^3 at x = 2 = " + basicPoly1.evaluate(2));
        System.out.println("First-order derivative of (x+1)^3 = " + basicPoly1.derivative());

        MyArrayPolynomial basicPoly2 = new MyArrayPolynomial(new double[]{-1, 4, 7, -2});
        System.out.println("Poly2 = " + basicPoly2);
        System.out.println("Poly1 = Poly1 + Poly2 = " + basicPoly1.plus(basicPoly2));
        System.out.println("Poly1 = Poly1 - Poly2 = " + basicPoly1.minus(basicPoly2));

        MyArrayPolynomial basicPoly3 = new MyArrayPolynomial(new double[]{5, 0, 10, 6});
        MyArrayPolynomial basicPoly4 = new MyArrayPolynomial(new double[]{1,2,4});
        System.out.println("Poly 3 = " + basicPoly3);
        System.out.println("Poly 4 = " + basicPoly4);
        System.out.println("Poly3 * Poly4 = " + basicPoly3.multiply(basicPoly4));
    }

    public static void testListPolynomial() {
        /*
           - Tạo ra các đa thức MyListPolynomial, trong đó bậc của đa thức là số tự nhiên được sinh ngẫu nhiên trong đoạn [1, 10],
             và các hệ số của đa thức được sinh ngẫu nhiên trong đoạn [1, 10].
           - Viết chương trình test các chức năng của MyListPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
             sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
             giá trị của x).
         */
        MyListPolynomial basicPoly1 = new MyListPolynomial();
        //1 + 3x + 3x^2 + x^3 = (x+1)^3
        basicPoly1.append(1);
        basicPoly1.append(3);
        basicPoly1.append(3);
        basicPoly1.append(1);
        System.out.println("(x+1)^3 = " + basicPoly1);
        System.out.println("Degree of (x+1)^3 = " + basicPoly1.degree());
        System.out.println("Getting a2 at x^2 = " + basicPoly1.coefficient(2));
        basicPoly1.set(100.5, 1);
        System.out.println("Changing a1 = 3 at x to a1 = 100.5: " + basicPoly1);
        basicPoly1.set(3, 1);
        System.out.println("Evaluating (x+1)^3 at x = 2 = " + basicPoly1.evaluate(2));
        System.out.println("First-order derivative of (x+1)^3 = " + basicPoly1.derivative());

        MyListPolynomial basicPoly2 = new MyListPolynomial(new double[]{-1, 4, 7, -2});
        System.out.println("Poly2 = " + basicPoly2);
        System.out.println("Poly1 = Poly1 + Poly2 = " + basicPoly1.plus(basicPoly2));
        System.out.println("Poly1 = Poly1 - Poly2 = " + basicPoly1.minus(basicPoly2));

        MyListPolynomial basicPoly3 = new MyListPolynomial(new double[]{5, 0, 10, 6});
        MyListPolynomial basicPoly4 = new MyListPolynomial(new double[]{1,2,4});
        System.out.println("Poly 3 = " + basicPoly3);
        System.out.println("Poly 4 = " + basicPoly4);
        System.out.println("Poly3 * Poly4 = " + basicPoly3.multiply(basicPoly4));
    }

    public static void testIntegrationCalculator() {
        /*
           - Tạo ra các đa thức MyArrayPolynomial và MyListPolynomial, trong đó bậc của đa thức là số tự nhiên được sinh
             ngẫu nhiên trong đoạn [1, 10], và các hệ số của đa thức được sinh ngẫu nhiên trong đoạn [1, 10].
           - Viết demo chương trình tính tích phân xác định của đa thức theo các phương pháp đã cho
             (MidpointMethod, TrapezoidMethod, SimpsonMethod) sử dụng IntegrationCalculator. Các phương pháp tính tích phân
             có thể thay đổi ở thời gian chạy chương trình.
           - In ra thông tin phương pháp sử dụng, đa thức, và giá trị tích phân của đa thức.
         */
        MyPolynomial polynomial = new MyListPolynomial(new double[]{-1, 0, 1});
        System.out.println("Polynomial: " + polynomial);
        Integrator integrator = new MidpointMethod(1e-6, 1000);
        IntegrationCalculator calculator = new IntegrationCalculator(integrator, polynomial);
        System.out.println("Integrator type: " + integrator);
        System.out.println("Integral over the interval [0,1] of poly is equal to " + calculator.integrate(0,1));
        integrator = new TrapezoidMethod(1e-6, 1000);
        calculator.setIntegrator(integrator);
        System.out.println("Integrator type: " + integrator);
        System.out.println("Integral over the interval [0,1] of poly is equal to " + calculator.integrate(0,1));
        integrator = new SimpsonMethod(1e-6, 1000);
        calculator.setIntegrator(integrator);
        System.out.println("Integrator type: " + integrator);
        System.out.println("Integral over the interval [0,1] of poly is equal to " + calculator.integrate(0,1));
    }
}
