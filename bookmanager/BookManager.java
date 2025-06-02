package bookmanager;

import java.util.*;

public class BookManager {
    // Singleton pattern
    private static volatile BookManager instance;

    private List<Book> bookList;

    private BookManager() {
        bookList = new LinkedList<>();
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

    public List<Book> getBookList() {
        return this.bookList;
    }

    /**
     * Thêm book vào cuối danh sách.
     * @param book
     */
    public void append(Book book) {
        if (book == null) {
            return;
        }
        bookList.add(book);
    }

    /**
     * Thêm book vào danh sách ở vị trí index.
     * @param book
     * @param index
     */
    public void add(Book book, int index) {
        if (book == null) {
            return;
        }
        //We don't have to check the index because List does it for us
        bookList.add(index, book);
    }

    /**
     * Xóa book ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        //We don't have to check the index because List does it for us
        bookList.remove(index);
    }

    /**
     * Bỏ book như tham số truyền vào.
     * @param book
     */
    public void remove(Book book) {
        bookList.remove(book);
    }

    /**
     * Lấy ra book ở vị trí index
     * @param index
     * @return
     */
    public Book bookAt(int index) {
        //We don't have to check the index because List does it for us
        return bookList.get(index);
    }

    /**
     * Sắp xếp danh sách book theo thứ tự số trang tăng dần.
     * @return
     */
    public List<Book> sortPagesIncreasing() {
        List<Book> newList = new LinkedList<>(this.bookList);
        Collections.sort(newList, new Comparator<Book>() {
            @Override
            public int compare(Book left, Book right) {
                return left.getPages() - right.getPages();
            }
        });
        return newList;
    }

    /**
     * Sắp xếp book theo thứ tự số trang giảm dần.
     * @return
     */
    public List<Book> sortPagesDecreasing() {
        List<Book> newList = new LinkedList<>(this.bookList);
        Collections.sort(newList, new Comparator<Book>() {
            @Override
            public int compare(Book left, Book right) {
                return right.getPages() - left.getPages();
            }
        });
        return newList;
    }

    /**
     * Sắp xếp sách theo thứ tự giá tăng dần.
     * @return
     */
    public List<Book> sortPriceIncreasing() {
        List<Book> newList = new LinkedList<>(this.bookList);
        Collections.sort(newList, new Comparator<Book>() {
            @Override
            public int compare(Book left, Book right) {
                if (left.getPrice() > right.getPrice()) {
                    return 1;
                } else if (left.getPrice() < right.getPrice()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        return newList;
    }

    /**
     * Sắp xếp sách theo thứ tự giá giảm dần.
     * @return
     */
    public List<Book> sortPriceDecreasing() {
        List<Book> newList = new LinkedList<>(this.bookList);
        Collections.sort(newList, new Comparator<Book>() {
            @Override
            public int compare(Book left, Book right) {
                if (right.getPrice() > left.getPrice()) {
                    return 1;
                } else if (right.getPrice() < left.getPrice()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        return newList;
    }

    /**
     * Lọc ra howMany sách có số trang lớn nhất.
     * @param howMany
     * @return
     */
    public List<Book> filterHighestPages(int howMany) {
        List<Book> result = sortPagesDecreasing();
        return result.subList(0, howMany);
    }

    /**
     * Lọc ra những sách có số trang cao hơn lowerBound.
     * @param lowerBound
     * @return
     */
    public List<Book> filterBooksPagesHigherThan(double lowerBound) {
        List<Book> result = new ArrayList<>();
        List<Book> pagesDecreasingList = sortPagesDecreasing();
        for (Book book: pagesDecreasingList) {
            if (book.getPages() > lowerBound) {
                result.add(book);
            }
            else {
                break;
            }
        }
        return result;
    }

    /**
     * Lọc ra howMany sách có số trang nhỏ nhất.
     * @param howMany
     * @return
     */
    public List<Book> filterBookLowestPages(int howMany) {
        List<Book> result = sortPagesIncreasing();
        return result.subList(0, howMany);
    }

    /**
     * Lọc ra howMany sách có số trang nhỏ hơn upperBound.
     * @param upperBound
     * @return
     */
    public List<Book> filterBooksPagesLowerThan(double upperBound) {
        List<Book> result = new ArrayList<>();
        List<Book> pagesDecreasingList = sortPagesIncreasing();
        for (Book book: pagesDecreasingList) {
            if (book.getPages() < upperBound) {
                result.add(book);
            }
            else {
                break;
            }
        }
        return result;
    }

    /**
     * Lọc ra howMany sách có giá cao nhất.
     * @param howMany
     * @return
     */
    public List<Book> filterBooksHighestPrice(int howMany) {
        List<Book> result = sortPriceDecreasing();
        return result.subList(0, howMany);
    }

    /**
     * Lọc ra howMany sách có giá cao hơn lowerBound.
     * @param lowerBound
     * @return
     */
    public List<Book> filterBooksPriceHigherThan(int lowerBound) {
        List<Book> result = new ArrayList<>();
        List<Book> priceDecreasing = sortPriceDecreasing();
        for (Book book: priceDecreasing) {
            if (book.getPrice() > lowerBound) {
                result.add(book);
            }
            else {
                break;
            }
        }
        return result;
    }

    /**
     * Lọc ra howMany sách có giá thấp nhất.
     * @param howMany
     * @return
     */
    public List<Book> filterBooksLowestPrice(int howMany) {
        List<Book> result = sortPriceIncreasing();
        return result.subList(0, howMany);
    }

    /**
     * Lọc ra howMany sách có giá thấp hơn upperBound.
     * @param upperBound
     * @return
     */
    public List<Book> filterBooksPriceLowerThan(double upperBound) {
        List<Book> result = new ArrayList<>();
        List<Book> priceIncreasing = sortPriceIncreasing();
        for (Book book: priceIncreasing) {
            if (book.getPrice() < upperBound) {
                result.add(book);
            }
            else {
                break;
            }
        }
        return result;
    }

    /**
     * Lọc ra những sách theo nhà xuất bản.
     * @param publisher
     * @return
     */
    public List<Book> filterBooksOfPublisher(String publisher) {
        List<Book> result = new ArrayList<>();
        for (Book book: bookList) {
            if (book.getPublisher().equals(publisher)) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Lọc ra những sách theo thể loại.
     * @param genre
     * @return
     */
    public List<Book> filterBooksOfGenre(String genre) {
        List<Book> result = new ArrayList<>();
        for (Book book: bookList) {
            if (book.getGenre().equals(genre)) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Lọc ra những sách theo tác giả.
     * @param author
     * @return
     */
    public List<Book> filterBooksOfAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book: bookList) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public static String titleOfBooksToString(List<Book> bookList) {
        StringBuilder titleOfBooks = new StringBuilder();
        titleOfBooks.append("[\n");
        for (Book book : bookList) {
            titleOfBooks.append(book.getTitle()).append(",");
        }
        return titleOfBooks.substring(0, titleOfBooks.length() - 1).trim() + "]\n";
    }

    public static void print(List<Book> bookList) {
        StringBuilder booksString = new StringBuilder();
        booksString.append("[\n");
        for (Book book : bookList) {
            booksString.append(book.toString()).append("\n");
        }
        System.out.print(booksString.toString().trim() + "\n]");
    }
}
