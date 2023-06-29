import java.util.*;

class Book {
    String title;
    String author;
    int publicationYear;
    int numberOfPages;
    boolean isAvailable;
    Date issueDate;

    Book(String title, String author, int publicationYear, int numberOfPages, boolean isAvailable, Date issueDate) {
        if (title == null || title.trim().isEmpty() || author == null || author.trim().isEmpty() || publicationYear <= 0 || numberOfPages <= 0) {
            throw new IllegalArgumentException("Invalid book information");
        }
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.numberOfPages = numberOfPages;
        this.isAvailable = isAvailable;
        this.issueDate = issueDate;
    }
}
class Library {
    List<Book> books;

    Library() {
        this.books = new ArrayList<>();
    }

    void addBook(Book book) {
        this.books.add(book);
    }

    void printAvailableBooks() {
        System.out.println("Available Books:");
        System.out.printf("%-20s %-20s %-15s %-10s\n", "Title", "Author", "Year", "Pages");
        for (Book book : this.books) {
            if (book.isAvailable) {
                System.out.printf("%-20s %-20s %-15s %-10s\n", book.title, book.author, book.publicationYear, book.numberOfPages);
            }
        }
    }

    void printIssuedBooks() {
        System.out.println("Books in use:");
        System.out.printf("%-20s %-20s %-15s %-10s %-20s\n", "Title", "Author", "Year", "Pages", "Issue Date");
        for (Book book : this.books) {
            if (!book.isAvailable) {
                System.out.printf("%-20s %-20s %-15s %-10s %-20s\n", book.title, book.author, book.publicationYear, book.numberOfPages, book.issueDate);
            }
        }
    }

    void searchBooksByYear(int year) {
        System.out.println("Books Published in " + year + ":");
        System.out.printf("%-20s %-20s %-15s %-10s %-10s\n", "Title", "Author", "Year", "Pages", "Available");
        for (Book book : this.books) {
            if (book.publicationYear == year) {
                System.out.printf("%-20s %-20s %-15s %-10s %-10s\n", book.title, book.author, book.publicationYear, book.numberOfPages, book.isAvailable ? "Yes" : "No");
            }
        }
    }
}

class ex4 {
    public static void main(String[] args) {
        Library library = new Library();
        // Додавання книг до бібліотеки
        library.addBook(new Book("Title1", "Author1", 1995, 400, true, null));
        library.addBook(new Book("Title2", "Author2", 2001, 430, false, new Date(122, Calendar.JANUARY,21)));
        library.addBook(new Book("Title3", "Author3", 1995, 321, true, null));
        library.addBook(new Book("Title4", "Author4", 1895, 715, true, new Date()));
        library.addBook(new Book("Title5", "Author5", 1992, 264, true, null));
        library.addBook(new Book("Title6", "Author6", 2000, 521, false, new Date(123, Calendar.JUNE, 5)));
        library.addBook(new Book("Title7", "Author7", 1975, 944, true, null));
        library.addBook(new Book("Title8", "Author8", 1987, 221, false, new Date(115, Calendar.NOVEMBER, 15)));
        library.addBook(new Book("Title9", "Author9", 2001, 512, true, null));
        library.addBook(new Book("Title10", "Author10", 2004, 301, false, new Date(123, Calendar.MARCH, 8)));


        library.printAvailableBooks();
        library.printIssuedBooks();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть рік видання: ");
        int year = scanner.nextInt();
        scanner.nextLine(); 

        library.searchBooksByYear(year);
    }
}

