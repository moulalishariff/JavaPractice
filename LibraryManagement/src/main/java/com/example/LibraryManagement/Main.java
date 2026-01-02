package com.example.LibraryManagement;

import com.example.entity.Book;
import com.example.entity.User;
import com.example.repository.*;
import com.example.service.*;
import java.util.Scanner;

public class Main {
    private static BookService bookService;
    private static UserService userService;
    private static Scanner scanner;

    public static void main(String[] args) {
        // Initialize repositories
        BookRepository bookRepository = new BookRepositoryImpl();
        UserRepository userRepository = new UserRepositoryImpl();

        // Initialize services
        bookService = new BookServiceImpl(bookRepository);
        userService = new UserServiceImpl(userRepository);

        scanner = new Scanner(System.in);

        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    handleBookMenu();
                    break;
                case 2:
                    handleUserMenu();
                    break;
                case 99:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 99);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n=== Library Management System ===");
        System.out.println("1. Book Management");
        System.out.println("2. User Management");
        System.out.println("99. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void handleBookMenu() {
        System.out.println("\n=== Book Management ===");
        System.out.println("1. Add Book");
        System.out.println("2. Update Book Details");
        System.out.println("3. Delete Book By Id");
        System.out.println("4. Delete Book By Name");
        System.out.println("5. Search Book By Id");
        System.out.println("6. Search Book By Title");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                updateBook();
                break;
            case 3:
                deleteBookById();
                break;
            case 4:
                deleteBookByTitle();
                break;
            case 5:
                searchBookById();
                break;
            case 6:
                searchBookByTitle();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void addBook() {
        System.out.println("\n--- Add Book ---");
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        Book book = new Book(0, title, description, price, author, publisher, quantity);
        Book addedBook = bookService.addBook(book);
        System.out.println("Book added successfully: " + addedBook);
    }

    private static void updateBook() {
        System.out.println("\n--- Update Book ---");
        System.out.print("Enter book ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Book existingBook = bookService.searchBookById(id);
        if (existingBook == null) {
            System.out.println("Book not found!");
            return;
        }

        System.out.print("Enter new title (current: " + existingBook.getTitle() + "): ");
        String title = scanner.nextLine();
        System.out.print("Enter new description (current: " + existingBook.getDescription() + "): ");
        String description = scanner.nextLine();
        System.out.print("Enter new price (current: " + existingBook.getPrice() + "): ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter new author (current: " + existingBook.getAuthor() + "): ");
        String author = scanner.nextLine();
        System.out.print("Enter new publisher (current: " + existingBook.getPublisher() + "): ");
        String publisher = scanner.nextLine();
        System.out.print("Enter new quantity (current: " + existingBook.getQuantity() + "): ");
        int quantity = scanner.nextInt();

        Book updatedBook = new Book(id, title, description, price, author, publisher, quantity);
        bookService.updateBook(updatedBook);
        System.out.println("Book updated successfully!");
    }

    private static void deleteBookById() {
        System.out.print("Enter book ID to delete: ");
        int id = scanner.nextInt();
        if (bookService.deleteBook(id)) {
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }

    private static void deleteBookByTitle() {
        System.out.print("Enter book title to delete: ");
        String title = scanner.nextLine();
        if (bookService.deleteBookByTitle(title)) {
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }

    private static void searchBookById() {
        System.out.print("Enter book ID to search: ");
        int id = scanner.nextInt();
        Book book = bookService.searchBookById(id);
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book not found!");
        }
    }

    private static void searchBookByTitle() {
        System.out.print("Enter book title to search: ");
        String title = scanner.nextLine();
        Book book = bookService.searchBookByTitle(title);
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book not found!");
        }
    }

    private static void handleUserMenu() {
        System.out.println("\n=== User Management ===");
        System.out.println("1. Add User");
        System.out.println("2. Update User Details");
        System.out.println("3. Delete User By Id");
        System.out.println("4. Delete User By Name");
        System.out.println("5. Search User By Name");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                addUser();
                break;
            case 2:
                updateUser();
                break;
            case 3:
                deleteUserById();
                break;
            case 4:
                deleteUserByName();
                break;
            case 5:
                searchUserByName();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void addUser() {
        System.out.println("\n--- Add User ---");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter contact number: ");
        String contactNo = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter role: ");
        String role = scanner.nextLine();
        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine();

        User user = new User(0, username, fullName, contactNo, email, password, role, dob);
        User addedUser = userService.addUser(user);
        System.out.println("User added successfully: " + addedUser);
    }

    private static void updateUser() {
        System.out.println("\n--- Update User ---");
        System.out.print("Enter user ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        User existingUser = userService.searchUserById(id);
        if (existingUser == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.print("Enter new username: ");
        String username = scanner.nextLine();
        System.out.print("Enter new full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter new contact number: ");
        String contactNo = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        System.out.print("Enter new password: ");
        String password = scanner.nextLine();
        System.out.print("Enter new role: ");
        String role = scanner.nextLine();
        System.out.print("Enter new date of birth: ");
        String dob = scanner.nextLine();

        User updatedUser = new User(id, username, fullName, contactNo, email, password, role, dob);
        userService.updateUser(updatedUser);
        System.out.println("User updated successfully!");
    }

    private static void deleteUserById() {
        System.out.print("Enter user ID to delete: ");
        int id = scanner.nextInt();
        if (userService.deleteUser(id)) {
            System.out.println("User deleted successfully!");
        } else {
            System.out.println("User not found!");
        }
    }

    private static void deleteUserByName() {
        System.out.print("Enter username to delete: ");
        String username = scanner.nextLine();
        if (userService.deleteUserByName(username)) {
            System.out.println("User deleted successfully!");
        } else {
            System.out.println("User not found!");
        }
    }

    private static void searchUserByName() {
        System.out.print("Enter username to search: ");
        String username = scanner.nextLine();
        User user = userService.searchUserByName(username);
        if (user != null) {
            System.out.println("User found: " + user);
        } else {
            System.out.println("User not found!");
        }
    }

    



}
