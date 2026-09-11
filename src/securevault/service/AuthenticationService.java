package securevault.service;

import securevault.model.User;
import securevault.security.PasswordSecurity;
import java.util.ArrayList;
import java.io.*;

public class AuthenticationService {

    private ArrayList<User> users;
    private static final String USER_FILE = "users.txt";

    public AuthenticationService() {
        users = new ArrayList<>();
        loadUsers();
    }

    public boolean register(String username, String password) {

        if (username == null || username.isEmpty()) {
            System.out.println("Username cannot be empty.");
            return false;
        }

        if (password == null || password.length() < 4) {
            System.out.println("Password must contain at least 4 characters.");
            return false;
        }

        for (User user : users) {

            if (user.getUsername().equals(username)) {
                System.out.println("Username already exists.");
                return false;
            }
        }

        String hashedPassword = PasswordSecurity.hashPassword(password);

        User newUser = new User(username, hashedPassword);
        users.add(newUser);

        saveUsers();

        System.out.println("Registration successful!");
        return true;
    }

    public User login(String username, String password) {

        for (User user : users) {

            if (user.getUsername().equals(username)
                    && PasswordSecurity.verifyPassword(
                            password,
                            user.getPassword())) {

                System.out.println("Login successful!");
                return user;
            }
        }

        System.out.println("Invalid username or password.");
        return null;
    }

    private void saveUsers() {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(USER_FILE))) {

            for (User user : users) {

                writer.write(
                        user.getUsername()
                                + ":"
                                + user.getPassword()
                );

                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving user data.");
        }
    }

    private void loadUsers() {

        File file = new File(USER_FILE);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(":", 2);

                if (parts.length == 2) {

                    User user =
                            new User(parts[0], parts[1]);

                    users.add(user);
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading user data.");
        }
    }
}