import java.util.ArrayList;
import java.util.Scanner;

// Abstraction
abstract class Item {

    private String title;

    Item(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    abstract void display();
}


// Inheritance
class Book extends Item {

    private String author;
    private double price;

    Book(String title, String author, double price) {

        super(title);

        this.author = author;
        this.price = price;
    }

    // Polymorphism
    void display() {

        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + author);
        System.out.println("Price: Rs. " + price);
    }
}


// Main class
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Book> books = new ArrayList<>();

        int choice;
        do{

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();


            // Add Book
            if (choice == 1) {

                System.out.print("Enter book title: ");
                String title = input.nextLine();

                System.out.print("Enter author: ");
                String author = input.nextLine();

                System.out.print("Enter price: ");
                double price = input.nextDouble();
                input.nextLine();

                Book book = new Book(title, author, price);

                books.add(book);

                System.out.println("Book added successfully!");
            }


            // View Books
            else if (choice == 2) {

                System.out.println("\n===== BOOKS =====");

                for (Book book : books) {

                    book.display();

                    System.out.println("----------------");
                }
            }


            // Search Book
            else if (choice == 3) {

                System.out.print("Enter title to search: ");
                String title = input.nextLine();

                for (Book book : books) {

                    if (book.getTitle().equalsIgnoreCase(title)) {

                        System.out.println("\nBook Found!");
                        book.display();
                    }
                }
            }


            // Delete Book
            else if (choice == 4) {

                System.out.print("Enter title to delete: ");
                String title = input.nextLine();

                for (int i = 0; i < books.size(); i++) {

                    if (books.get(i).getTitle()
                            .equalsIgnoreCase(title)) {

                        books.remove(i);

                        System.out.println("Book deleted successfully!");

                        break;
                    }
                }
            }


            // Exit
            else if (choice == 5) {

                System.out.println("Thank you for using Library Management System!");

            }

            else {

                System.out.println("Invalid choice!");

            }

        } while (choice != 5);

        input.close();
    }
}