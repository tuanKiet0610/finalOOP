package bookmanagers;

public class BookManager {
    private static volatile BookManager instance;
    private MyList bookList;

    private BookManager() {
        this.bookList = new MyLinkedList();
    }

    public static BookManager getInstance() {
        //Singleton Design Pattern. The main purpose is to only create one instance of the class, thus ensuring thread
        //safety
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
        return this.bookList;
    }

    /**
     * Thêm book vào đầu danh sách.
     * @param book
     */
    public void insertAtStart(Book book) {
        if (book == null) {
            return;
        }
        bookList.insertAtStart(book);
    }

    /**
     * Thêm book vào cuối danh sách.
     * @param book
     */
    public void insertAtEnd(Book book) {
        if (book == null) {
            return;
        }
        bookList.insertAtEnd(book);
    }

    /**
     * Thêm book vào danh sách ở vị trí index.
     * @param book
     * @param index
     */
    public void insertAPosition(Book book, int index) {
        if (book == null) {
            return;
        }
        //The index will be checked by bookList function
        bookList.insertAtPosition(book, index);
    }

    /**
     * Xóa book ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        bookList.remove(index);
    }

    /**
     * Lấy ra book ở vị trí index
     * @param index
     * @return
     */
    public Book bookAt(int index) {
        return (Book) bookList.get(index);
    }

    /**
     * Lấy ra sách có giá cao nhất.
     * @return
     */
    public Book highestPriceBook() {
        Book maxBook = (Book) bookList.get(0);
        MyIterator myIterator = bookList.iterator();
        while (myIterator.hasNext()) {
            Book currentBook = (Book) myIterator.next();
            if (currentBook.getPrice() > maxBook.getPrice()) {
                maxBook = currentBook;
            }
        }
        return maxBook;
    }

    /**
     * Lấy ra sách có giá thấp nhất.
     * @return
     */
    public Book lowestPriceBook() {
        Book minBook = (Book) bookList.get(0);
        MyIterator myIterator = bookList.iterator();
        while (myIterator.hasNext()) {
            Book currentBook = (Book) myIterator.next();
            if (currentBook.getPrice() < minBook.getPrice()) {
                minBook = currentBook;
            }
        }
        return minBook;
    }

    /**
     * Lấy ra sách có số trang cao nhất.
     * @return
     */
    public Book highestNumberOfPagesBook() {
        Book maxBook = (Book) bookList.get(0);
        MyIterator myIterator = bookList.iterator();
        while (myIterator.hasNext()) {
            Book currentBook = (Book) myIterator.next();
            if (currentBook.getPages() > maxBook.getPages()) {
                maxBook = currentBook;
            }
        }
        return maxBook;
    }

    /**
     * Lấy ra sách có số trang thấp nhất.
     * @return
     */
    public Book lowestNumberOfPagesBook() {
        Book minBook = (Book) bookList.get(0);
        MyIterator myIterator = bookList.iterator();
        while (myIterator.hasNext()) {
            Book currentBook = (Book) myIterator.next();
            if (currentBook.getPages() < minBook.getPages()) {
                minBook = currentBook;
            }
        }
        return minBook;
    }

    /**
     * Lọc ra những book theo nhà xuất bản.
     * @param publisher
     * @return
     */
    public MyList filterBooksOfPublisher(String publisher) {
        MyList newList = new MyLinkedList();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookAt(i).getPublisher().equals(publisher)) {
                newList.insertAtEnd(bookList.get(i));
            }
        }
        return newList;
    }

    /**
     * Lọc ra những book theo thể loại.
     * @param genre
     * @return
     */
    public MyList filterBooksOfGenre(String genre) {
        MyList newList = new MyLinkedList();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookAt(i).getGenre().equals(genre)) {
                newList.insertAtEnd(bookList.get(i));
            }
        }
        return newList;
    }

    /**
     * Lọc ra những book theo tác giả.
     * @param author
     * @return
     */
    public MyList filterBooksOfAuthor(String author) {
        MyList newList = new MyLinkedList();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookAt(i).getAuthor().equals(author)) {
                newList.insertAtEnd(bookList.get(i));
            }
        }
        return newList;
    }
    public static String titleOfBooksToString(MyList bookList) {
        StringBuilder titleOfBooks = new StringBuilder();
        titleOfBooks.append("[");
        MyIterator it = bookList.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            titleOfBooks.append(book.getTitle()).append(", ");
        }
        return titleOfBooks.substring(0, titleOfBooks.length() - 2) + "]\n";
    }
}
