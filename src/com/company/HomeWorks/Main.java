package com.company.HomeWorks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.company.HomeWorks.FileService.readFromFile;

public class Main {

    public static boolean isLoggedIn = false;
    public static String currentUserName;
    public static Scanner scn = new Scanner(System.in);
    public static boolean isFinished = false;
    public static ArrayList<String> data = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        readAllUsers();
        while (!isFinished) {
            if (isLoggedIn) {
                handleLogedinFlow();
            } else {
                handleLogedoutFlow();
            }
        }
    }

    private static void readAllUsers() {
        ArrayList<String> userStrings = readFromFile();
        for (String userString : userStrings) {
            User user = new User();
            List<String> split = Arrays.asList(userString.trim().split(" "));
            user.setUsername(split.get(0));
            user.setPassword(split.get(1));

            split.remove(0);
            split.remove(0);

            user.setPosts(split);
            UserService.addUser(user);
        }
    }

    private static void writeAllUsers() {
        List<String> userStrings = new ArrayList<>();
        for (User user : UserService.getAllUsers()) {
            StringBuilder userPost = new StringBuilder();
            for (String userPosts : user.getPosts()) {
                userPost.append(userPosts);
                userPost.append(" ");
            }

            String userString = user.getUsername() +
                    " " +
                    user.getPassword() +
                    " " +
                    userPost;
            userStrings.add(userString);
        }
        FileService.writeToFile(userStrings);
    }


    private static void handleLogedoutFlow() {
        printLogedOutMenu();
        int choice = scn.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Type Username");
                String uName = scn.next();
                System.out.println("Type password");
                String pass = scn.next();
                registerUser(uName,pass);
                break;
            case 2:
                System.out.println("Type Username");
                String username = scn.next();
                System.out.println("Type password");
                String password = scn.next();
                loginUser(username,password);
                break;
            case 3:
                exitProgram();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static void exitProgram() {
        writeAllUsers();
        isFinished = true;
    }

    static void loginUser(String uName, String pass) {
        boolean isValid = UserService.validateUser(uName, pass);
        if (isValid) {
            currentUserName = uName;
            isLoggedIn = true;
        } else {
            System.out.println("invalid credentials");
        }

    }

    static User registerUser(String username, String password) {
        User user = new User(username, password);
        boolean isAdded = UserService.addUser(user);
        if (isAdded) {
            System.out.println("you have registered successfully");
            return user;
        } else {
            System.out.println("something went wrong, try again");
            return null;
        }
    }


    private static void handleLogedinFlow() throws IOException {
        printLogedInMenu();
        switch (scn.nextInt()) {
            case 1:
                System.out.println("Write post");
                String post = scn.next();
                writePost(post);

                break;
            case 2:
                showAllPosts();
                readFromFile();
                break;
            case 3:
                logout();
                break;
            case 4:
                exitProgram();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    static void logout() {
        isLoggedIn = false;
        currentUserName = null;
    }
    static void printDataArr(){
        for (int i = 0; i < data.size(); i++) {
                System.out.println(data.get(i));
        }
    }

    static void showAllPosts() {
        List<User> allUsers = UserService.getAllUsers();
        for (User user : allUsers) {
            if (user != null) {
                for (String post : user.getPosts()) {
                    if (post != null) {
                        System.out.println(user.getUsername() + " : " + post);
                    }
                }
            }
        }
    }

    static void writePost(String pst) {
        boolean isAdded = UserService.addPostToUser(currentUserName, pst);
        data.add(currentUserName + " : " + pst);
        if (isAdded) System.out.println("Your post have been added successfully");
    }

    private static void printLogedInMenu() {
        System.out.println("1 for write post");
        System.out.println("2 for read all posts");
        System.out.println("3 for logout");
        System.out.println("4 for exit");
    }

    private static void printLogedOutMenu() {
        System.out.println("1 for reg");
        System.out.println("2 for login");
        System.out.println("3 for exit");
    }
}