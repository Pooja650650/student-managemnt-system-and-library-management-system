import java.util.Scanner;

class Book {

    int bookId;
    String title;
    boolean issued;
    int studentId;

    Book(int bookId, String title) {
        this.bookId = bookId;
        this.title = title;
        this.issued = false;
        this.studentId = 0;
    }

    void display() {

        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);

        if (issued) {
            System.out.println("Issued to Student ID: " + studentId);
        } else {
            System.out.println("Status: Available");
        }

        System.out.println("----------------------");
    }
}

class Library {

    Book books[] = new Book[100];
    int count = 0;

    void addBook(int id, String title) {

        books[count] = new Book(id, title);
        count++;

        System.out.println("Book Added Successfully");
    }

    void showBooks() {

        if (count == 0) {
            System.out.println("No Books Available");
            return;
        }

        for (int i = 0; i < count; i++) {
            books[i].display();
        }
    }

    void issueBook(int bookId, int studentId) {

        for (int i = 0; i < count; i++) {

            if (books[i].bookId == bookId) {

                if (!books[i].issued) {

                    books[i].issued = true;
                    books[i].studentId = studentId;

                    System.out.println("Book Issued Successfully");

                } else {

                    System.out.println("Book Already Issued");
                }

                return;
            }
        }

        System.out.println("Book Not Found");
    }

    void returnBook(int bookId) {

        for (int i = 0; i < count; i++) {

            if (books[i].bookId == bookId) {

                if (books[i].issued) {

                    books[i].issued = false;
                    books[i].studentId = 0;

                    System.out.println("Book Returned Successfully");

                } else {

                    System.out.println("Book Was Not Issued");
                }

                return;
            }
        }

        System.out.println("Book Not Found");
    }
}

public class lms {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        Library lib = new Library();

        int choice;

        do {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Show Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    lib.addBook(id, title);

                    break;

                case 2:

                    lib.showBooks();

                    break;

                case 3:

                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();

                    System.out.print("Enter Student ID: ");
                    int studentId = sc.nextInt();

                    lib.issueBook(bookId, studentId);

                    break;

                case 4:

                    System.out.print("Enter Book ID: ");
                    int returnId = sc.nextInt();

                    lib.returnBook(returnId);

                    break;

                case 5:

                    System.out.println("Exiting Program");

                    break;

                default:

                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);

    }
}