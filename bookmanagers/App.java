package bookmanagers;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        init();

        /* Yêu cầu:
        - Hoàn thiện code chương trình theo mẫu đã cho.
        - Viết code để test cho tất cả các hàm test bên dưới.

        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_MyBookManager>.txt (Ví dụ, NguyenVanA_123456_MyBookManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_BookMyManager>.zip (Ví dụ, NguyenVanA_123456_BookMyManager.zip),
          nộp lên classroom.
         */
        System.out.println("--------------------Testing original data--------------------");
        testOriginalData();
        System.out.println("--------------------Testing Highest Price book--------------------");
        testGetHighestPriceBook();
        System.out.println("--------------------Testing Lowest Price book--------------------");
        testGetLowestPriceBook();
        System.out.println("--------------------Testing Highest Pages book--------------------");
        testGetHighestNumberOfPagesBook();
        System.out.println("--------------------Testing Lowest Pages book--------------------");
        testGetLowestNumberOfPagesBook();
        System.out.println("--------------------Testing filter books with author Drucker Peter--------------------");
        testFilterBooksOfAuthor();
        System.out.println("--------------------Testing filter books with genre data_science--------------------");
        testFilterBooksOfGenre();
        System.out.println("--------------------Testing Testing filter books with publisher Springer--------------------");
        testFilterBooksOfPublisher();
    }

    public static void init() {
        //The file path is based on the computer of the person running this program
        String filePath = "D:\\OOP\\Cuối kì OOP\\Finals_PreviousYear\\FinalsOOP2\\src\\last\\bookmanager\\data\\books.csv";
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

                Gợi ý:
                Các đội tượng Book không thể được tạo trực tiếp ở đây do hàm dựng là private,
                các đối tượng này được tạo ra bằng cách sử dụng Builder Pattern, ví dụ theo cách sau:
                Book newBook = new Book.BookBuilder(title).
                    .withAuthor(author)
                    .withGenre(genre)
                    ...
                    .build();
                */
                String title = dataList.get(0);
                String author = dataList.get(1);
                String genre = dataList.get(2);
                /*
                The fourth and the fifth element of the list is a number. However, when we read from a file, we receive
                a string. That's why we need to parse it to a numeric type
                 */
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
                BookManager.getInstance().insertAtEnd(book);
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
        String bookTitles = BookManager.getInstance().titleOfBooksToString(BookManager.getInstance().getBookList());
        System.out.println(bookTitles);
    }

    /**
     * Test lọc ra những book theo tác giả.
     */
    public static void testFilterBooksOfAuthor() {
        //Random author taken from the .csv file
        String bookTitles = BookManager.getInstance().titleOfBooksToString(BookManager.getInstance().filterBooksOfAuthor("Drucker Peter"));
        System.out.println(bookTitles);
    }

    /**
     * Test lọc ra những book theo nhà xuất bản.
     */
    public static void testFilterBooksOfPublisher() {
        //Random publisher taken from the .csv file
        String bookTitles = BookManager.getInstance().titleOfBooksToString(BookManager.getInstance().filterBooksOfPublisher("Springer"));
        System.out.println(bookTitles);
    }

    /**
     * Test lọc ra những book theo thể loại.
     */
    public static void testFilterBooksOfGenre() {
        //Random publisher taken from the .csv file
        String bookTitles = BookManager.getInstance().titleOfBooksToString(BookManager.getInstance().filterBooksOfGenre("data_science"));
        System.out.println(bookTitles);
    }

    /**
     * Test lấy ra sách có giá cao nhất.
     */
    public static void testGetHighestPriceBook() {
        String title = BookManager.getInstance().highestPriceBook().getTitle();
        System.out.println("[" + title + "]");
    }

    /**
     * Test lấy ra sách có giá thấp nhất.
     */
    public static void testGetLowestPriceBook() {
        String title = BookManager.getInstance().lowestPriceBook().getTitle();
        System.out.println("[" + title + "]");
    }

    /**
     * Test lấy ra sách có số trang cao nhất.
     */
    public static void testGetHighestNumberOfPagesBook() {
        String title = BookManager.getInstance().highestNumberOfPagesBook().getTitle();
        System.out.println("[" + title + "]");
    }

    /**
     * Test lấy ra sách có số trang thấp nhất.
     */
    public static void testGetLowestNumberOfPagesBook() {
        String title = BookManager.getInstance().lowestNumberOfPagesBook().getTitle();
        System.out.println("[" + title + "]");
    }
}
