package usermanagement;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserManagementApp {
    private Map<Integer, User> users = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void startApp() throws NoSuchAlgorithmException {
        addDummyUsers();
        displayMenu();
    }

    private void addDummyUsers() {
        try {
            String hashedPassword1 = hashPassword("password1");
            String hashedPassword2 = hashPassword("password2");

            User user1 = new User(1, "Mikayil Shah", "mikayil", hashedPassword1);
            User user2 = new User(2, "Durna Suleymanova", "durna", hashedPassword2);

            this.users.put(user1.getId(), user1);
            this.users.put(user2.getId(), user2);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Failed to hash passwords. Exiting the program.");
            System.exit(1);
        }
    }

    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    private void displayMenu() throws NoSuchAlgorithmException {
        System.out.println("Welcome to User Management App!");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                performLogin();
                break;
            case 2:
                performRegistration();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                displayMenu();
                break;
        }
    }

    private void performLogin() throws NoSuchAlgorithmException {
        System.out.print("Enter your login: ");
        String login = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        for (User user : users.values()) {
            if (user.getLogin().equals(login) && user.isPasswordMatch(hashPassword(password))) {
                System.out.println("Login successful!");
                System.out.println("User Details: " + user);
                System.exit(0);
            }
        }

        System.out.println("Invalid login or password.");
        displayMenu();
    }

    private void performRegistration() throws NoSuchAlgorithmException {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your login: ");
        String login = scanner.nextLine();

        if (isLoginTaken(login)) {
            System.out.println("The login is already taken.");
            System.out.print("1. Try again\n2. Exit\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    performRegistration();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Exiting the program.");
                    System.exit(0);
                    break;
            }
        }

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        password = hashPassword(password);
        int userId = users.size() + 1;
        User user = new User(userId, name, login, password);
        users.put(userId, user);
        System.out.println("Registration successful!");
        System.out.println("User Details: " + user);
        System.exit(0);
    }

    private boolean isLoginTaken(String login) {
        for (User user : users.values()) {
            if (user.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }
}