package mybookmanager;

import java.util.List;

public class BookManager {
    // Singleton pattern
    private static volatile BookManager instance;

    private MyList bookList;
    private List<Object> list;

    private BookManager() {
        bookList = new MyArrayList();
        list = bookList.getList();
    }

    public static BookManager getInstance() {
        if (instance == null) {
            synchronized (BookManager.class) {
                if (instance == null) {
                    instance = new BookManager();
                }
            }
        }
        return instance;
    }

    public MyList getBookList() {
        return bookList;
    }

    /**
     * Thêm book vào cuối danh sách.
     * @param book
     */
    public void append(Book book) {
        if (book == null) {
            return;
        }
        bookList.append(book);
    }

    /**
     * Thêm book vào danh sách ở vị trí index.
     * @param book
     * @param index
     */
    public void add(Book book, int index) {
        //ow
        if (book == null) {
            return;
        }
        //Now we have to check the index compared to bookmanager which uses List
        bookList.insert(book, index);
    }

    /**
     * Xóa book ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        //Now we have to check the index compared to bookmanager which uses List
        bookList.remove(index);
    }

    /**
     * Lấy ra book ở vị trí index
     * @param index
     * @return
     */
    public Book bookAt(int index) {
        //Now we have to check the index compared to bookmanager which uses List
        return (Book) bookList.get(index);
    }

    /**
     * Sắp xếp danh sách book theo thứ tự số trang tăng dần.
     * @return
     */
    public MyList sortPagesIncreasing() {
        int n = bookList.size();

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (bookAt(j).getPages() < bookAt(min_idx).getPages())
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            Book temp = bookAt(min_idx);
            bookList.set(bookList.get(i), min_idx);
            bookList.set(temp, i);
        }
        return bookList;
    }

    /**
     * Sắp xếp book theo thứ tự số trang giảm dần.
     * @return
     */
    public MyList sortPagesDecreasing() {
        int n = bookList.size();

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++) {
            // Find the maximum element in unsorted array
            int max_idx = i;
            for (int j = i + 1; j < n; j++)
                if (bookAt(j).getPages() > bookAt(max_idx).getPages())
                    max_idx = j;

            // Swap the found minimum element with the first
            // element
            Book temp = bookAt(max_idx);
            bookList.set(bookList.get(i), max_idx);
            bookList.set(temp, i);
        }
        return bookList;
    }

    /**
     * Sắp xếp sách theo thứ tự giá tăng dần.
     * @return
     */
    public MyList sortPriceIncreasing() {
        int n = bookList.size();

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (bookAt(j).getPrice() < bookAt(min_idx).getPrice())
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            Book temp = bookAt(min_idx);
            bookList.set(bookList.get(i), min_idx);
            bookList.set(temp, i);
        }
        return bookList;
    }

    /**
     * Sắp xếp sách theo thứ tự giá giảm dần.
     * @return
     */
    public MyList sortPriceDecreasing() {
        int n = bookList.size();

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++) {
            // Find the maximum element in unsorted array
            int max_idx = i;
            for (int j = i + 1; j < n; j++)
                if (bookAt(j).getPrice() > bookAt(max_idx).getPrice())
                    max_idx = j;

            // Swap the found minimum element with the first
            // element
            Book temp = bookAt(max_idx);
            bookList.set(bookList.get(i), max_idx);
            bookList.set(temp, i);
        }
        return bookList;
    }

    /**
     * Lọc ra những sách theo nhà xuất bản.
     * @param publisher
     * @return
     */
    public MyList filterBooksOfPublisher(String publisher) {
        MyList newList = new MyArrayList();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookAt(i).getPublisher().equals(publisher)) {
                newList.append(bookList.get(i));
            }
        }
        return newList;
    }

    /**
     * Lọc ra những sách theo thể loại.
     * @param genre
     * @return
     */
    public MyList filterBooksOfGenre(String genre) {
        MyList newList = new MyArrayList();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookAt(i).getGenre().equals(genre)) {
                newList.append(bookList.get(i));
            }
        }
        return newList;
    }

    /**
     * Lọc ra những sách theo tác giả.
     * @param author
     * @return
     */
    public MyList filterBooksOfAuthor(String author) {
        MyList newList = new MyArrayList();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookAt(i).getAuthor().equals(author)) {
                newList.append(bookList.get(i));
            }
        }
        return newList;
    }

    public static String titleOfBooksToString(MyList bookList) {
        StringBuilder titleOfBooks = new StringBuilder();
        titleOfBooks.append("[\n");
        MyIterator it = bookList.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            titleOfBooks.append(book.getTitle()).append(", ");
        }
        return titleOfBooks.substring(0, titleOfBooks.length() - 2) + "]\n";
    }

    public static void print(MyList bookList) {
        StringBuilder booksString = new StringBuilder();
        booksString.append("[\n");
        MyIterator it = bookList.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            booksString.append(book.toString()).append("\n");
        }
        System.out.print(booksString.toString().trim() + "]\n");
    }
}
