import java.util.*;

class Book {
    private String id;
    private String title;
    private String author;
    private String genre;
    private String status;

    public Book(String id, String title, String author, String genre, String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Status: " + status;
    }
}

class Library {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        if (books.containsKey(book.getId())) {
            System.out.println("Book ID already exists!");
            return;
        }
        books.put(book.getId(), book);
        System.out.println("Book added successfully.");
    }

    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        books.values().forEach(System.out::println);
    }

    public void searchBook(String query) {
        for (Book book : books.values()) {
            if (book.getId().equalsIgnoreCase(query) || book.getTitle().equalsIgnoreCase(query)) {
                System.out.println(book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void updateBook(String id, String title, String author, String status) {
        Book book = books.get(id);
        if (book != null) {
            book.setTitle(title);
            book.setAuthor(author);
            book.setStatus(status);
            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void deleteBook(String id) {
        if (books.remove(id) != null) {
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter Status (Available/Checked Out): ");
                    String status = scanner.nextLine();
                    library.addBook(new Book(id, title, author, genre, status));
                    break;
                case 2:
                    library.viewAllBooks();
                    break;
                case 3:
                    System.out.print("Enter Book ID or Title: ");
                    String query = scanner.nextLine();
                    library.searchBook(query);
                    break;
                case 4:
                    System.out.print("Enter Book ID to Update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter New Title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter New Author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter New Status (Available/Checked Out): ");
                    String newStatus = scanner.nextLine();
                    library.updateBook(updateId, newTitle, newAuthor, newStatus);
                    break;
                case 5:
                    System.out.print("Enter Book ID to Delete: ");
                    String deleteId = scanner.nextLine();
                    library.deleteBook(deleteId);
                    break;
                case 6:
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
