package rootsolver;


public class RootFindingTestDrive {
    public static void main(String[] args) {
        /*
        TODO

        Chạy các hàm test để test chương trình.
        Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_RootFinding>.txt
        (ví dụ, NguyenVanA_123456_RootFinding.txt).
        Nén tất cả các file source code và file kết quả chạy chương trình vào file zip có tên
        <TenSinhVien_MaSinhVien_RootFinding>.zip (ví dụ, NguyenVanA_123456_RootFinding.txt), và nộp bài
        lên classroom.
        */
        AbstractFunction function = new UnivariateRealFunction();
        UnivariateRealRootFinding rootFinding = new UnivariateRealRootFinding(function);
        double lower = 12.0;
        double upper = 14.0;
        System.out.println("Hàm cần tìm nghiệm: f(x) = x.sin(x) - 3");
        System.out.println("Khoảng tìm nghiệm: [" + lower + ", " + upper + "]");
        System.out.println("Giá trị nghiệm tìm được: " + rootFinding.solve(lower, upper));
        System.out.println();
        testRootSolver();
    }

    public static void testRootSolver() {
        /*
         TODO

         - Viết chương trình tìm nghiệm của hàm (sin(x).x - 3) theo các phương pháp đã cho (Bisection, Newton-Raphson, Secant) sử dụng
           UnivariateRealRootFinding. Các phương pháp tìm nghiệm của thể thay đổi ở thời gian chạy chương trình.
         - In ra phương pháp sử dụng, hàm và nghiệm của hàm tìm được.
         */
        AbstractFunction function = new UnivariateRealFunction();
        double lower = 11.0;
        double upper = 13.0;

        RootSolver bisectionSolver = new BisectionSolver(1e-6, 100);
        RootSolver newtonRaphsonSolver = new NewtonRaphsonSolver(1e-6, 100);
        RootSolver secantSolver = new SecantSolver(1e-6, 100);

        UnivariateRealRootFinding rootFinding = new UnivariateRealRootFinding(function);

        rootFinding.setRootSolver(bisectionSolver);
        double bisectionResult = rootFinding.solve(lower, upper);
        System.out.println("Phương pháp sử dụng: Bisection");
        System.out.println("Hàm cần tìm nghiệm: f(x) = sin(x) * x - 3");
        System.out.println("Khoảng tìm nghiệm: [" + lower + ", " + upper + "]");
        System.out.println("Giá trị nghiệm tìm được: " + bisectionResult);
        System.out.println();

        rootFinding.setRootSolver(newtonRaphsonSolver);
        double newtonRaphsonResult = rootFinding.solve(lower, upper);
        System.out.println("Phương pháp sử dụng: Newton-Raphson");
        System.out.println("Hàm cần tìm nghiệm: f(x) = sin(x) * x - 3");
        System.out.println("Khoảng tìm nghiệm: [" + lower + ", " + upper + "]");
        System.out.println("Giá trị nghiệm tìm được: " + newtonRaphsonResult);
        System.out.println();

        rootFinding.setRootSolver(secantSolver);
        double secantResult = rootFinding.solve(lower, upper);
        System.out.println("Phương pháp sử dụng: Secant");
        System.out.println("Hàm cần tìm nghiệm: f(x) = sin(x) * x - 3");
        System.out.println("Khoảng tìm nghiệm: [" + lower + ", " + upper + "]");
        System.out.println("Giá trị nghiệm tìm được: " + secantResult);
        System.out.println();
    }
}
