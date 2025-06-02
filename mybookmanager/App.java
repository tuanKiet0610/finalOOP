package mybookmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        /*
        TODO

        Viết code để test cho tất cả các hàm bên dưới.
        Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
        là <TenSinhVien_MaSinhVien_StudentManager>.txt (Ví dụ, NguyenVanA_123456_StudentManager.txt).
        Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
        <TenSinhVien_MaSinhVien_StudentManager>.zip (Ví dụ, NguyenVanA_123456_StudentManager.zip),
        nộp lên classroom.
         */
        System.out.println("--------------------Testing original data--------------------");
        testOriginalData();
        System.out.println("--------------------Testing price sorted decreasing--------------------");
        testPriceOfBooksDecreasing();
        System.out.println("--------------------Testing price sorted increasing--------------------");
        testPriceOfBooksIncreasing();
        System.out.println("--------------------Testing pages sorted decreasing--------------------");
        testSortPagesOfBookDecreasing();
        System.out.println("--------------------Testing pages sorted increasing--------------------");
        testSortPagesOfBookIncreasing();
        System.out.println("--------------------Testing filter books with author Villani Cedric--------------------");
        testFilterBooksOfAuthor();
        System.out.println("--------------------Testing filter books with genre data_science--------------------");
        testFilterBooksOfGenre();
        System.out.println("--------------------Testing Testing filter books with publisher Springer--------------------");
        testFilterBooksOfPublisher();
    }

    public static void init() {
        String filePath = "D:\\OOP\\Cuối kì OOP\\Finals_PreviousYear\\FinalsOOP2\\src\\de3_2223\\data\\books.csv";
        readListData(filePath);
    }

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 6) {
                    continue;
                }

                if (dataList.get(0).equals("title")) {
                    continue;
                }
                /*
                TODO

                Đọc được dữ liệu, tạo ra các đối tượng Book ở đây, và cho vào BookManager để quản lý.
                */
                /*Example
                title,author,genre,pages,price,publisher
                Fundamentals of Wavelets,Goswami Jaideva,signal_processing,228,20.5,Wiley
                Fundamentals of Wavelets will be the first element in the array
                Goswami Jaideva will be the second element
                Since the number is first interpreted as a string, we have to parse it back to type Integer or Double
                 */
                String title = dataList.get(0);
                String author = dataList.get(1);
                String genre = dataList.get(2);
                int page = Integer.parseInt(dataList.get(3));
                double price = Double.parseDouble(dataList.get(4));
                String publisher = dataList.get(5);

                Book book = new Book.BookBuilder(title).
                        withAuthor(author).
                        withGenre(genre).
                        withPages(page).
                        withPrice(price).
                        withPublisher(publisher).
                        build();
                BookManager.getInstance().append(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void testOriginalData() {
        init();
        String studentIds = BookManager.getInstance().titleOfBooksToString(BookManager.getInstance().getBookList());
        System.out.print(studentIds);
    }

    public static void testSortPagesOfBookIncreasing() {
        String studentIds = BookManager.getInstance().titleOfBooksToString(BookManager.getInstance().sortPagesIncreasing());
        System.out.print(studentIds);
    }

    public static void testSortPagesOfBookDecreasing() {
        String studentIds = BookManager.getInstance().titleOfBooksToString(BookManager.getInstance().sortPagesDecreasing());
        System.out.print(studentIds);
    }

    public static void testPriceOfBooksIncreasing() {
        String studentIds = BookManager.getInstance().titleOfBooksToString(BookManager.getInstance().sortPriceIncreasing());
        System.out.print(studentIds);
    }

    public static void testPriceOfBooksDecreasing() {
        String studentIds = BookManager.getInstance().titleOfBooksToString(BookManager.getInstance().sortPriceDecreasing());
        System.out.print(studentIds);
    }

    public static void testFilterBooksOfAuthor() {
        //Random author taken from the .csv file
        String studentIds = BookManager.getInstance().titleOfBooksToString(BookManager.getInstance().filterBooksOfAuthor("Villani Cedric"));
        System.out.print(studentIds);
    }

    public static void testFilterBooksOfPublisher() {
        //Random publisher taken from the .csv file
        String studentIds = BookManager.getInstance().titleOfBooksToString(BookManager.getInstance().filterBooksOfPublisher("Springer"));
        System.out.print(studentIds);
    }

    public static void testFilterBooksOfGenre() {
        //Random publisher taken from the .csv file
        String studentIds = BookManager.getInstance().titleOfBooksToString(BookManager.getInstance().filterBooksOfGenre("data_science"));
        System.out.print(studentIds);
    }
}
