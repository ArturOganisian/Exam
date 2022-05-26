package com.company;

import java.util.Scanner;

public class Main {

        public static int userCount = 0;
        public static int postCount = 0;
        public static User[] users = new User[10];

        public static String[] userPosts = new String[100];

    public static void main(String[] args) {
        boolean isFinished = false;

        while (!isFinished) {
            logMenu();
            Scanner scn = new Scanner(System.in);
            int choose = scn.nextInt();
            switch (choose) {
                case 1:
                    User user = new User();
                    System.out.println("Please enter Username:");
                    String inputUserName = scn.next();
                    System.out.println("Please enter Password:");
                    String inputPass = scn.next();
                    registerUser(user, inputUserName, inputPass);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Enter username");
                    String log = scn.next();

                    System.out.println("Enter password");
                    String pas = scn.next();


                    if(userChecker(log,pas) == false){
                        System.out.println("Wrong UserName or Password");
                        break;
                    }
                    else {
                        System.out.println("You logged inn to the system");
                        loggedUser();
                    }
                    break;
                case 3:
                    isFinished = true;
                    System.out.println("Thank you for using our system!");
                    System.out.println();
                    break;
                default:
                    System.out.println("Error while input");
            }

        }
    }
    public static void logMenu(){
        System.out.println("Type 1 to Register User");
        System.out.println("Type 2 to LogIn to the System");
        System.out.println("Type 3 to Exit application");
    }
    public static void registerUser(User user, String log, String pas) {
        if(userCount == users.length){
            System.out.println("No more space for new Users");
        }
        else {
            for (int i = 0; i < users.length; ++i) {
                if (users[i] == null) {
                    users[i] = user;
                    user.setUsername(log);
                    user.setPassword(pas);

                    userCount++;
                    return;
                }
            }
        }
    }
    public static boolean userChecker(String username, String password){
        boolean check = false;
        for (int i = 0; i < users.length; i++) {
            String nam = users[i].getUsername();
            String pas = users[i].getPassword();
            if(nam.equals(username) && pas.equals(password)){
                check = true;
                break;
            }
        }
        return check;
    }
    public static void loggedUser() {
        boolean isFinish = false;
        while (!isFinish) {
            loggedUserMenu();

            Scanner scn = new Scanner(System.in);
            int type = scn.nextInt();

            switch (type) {
                case 1:
                    System.out.println("How many posts you want to add?");
                    int postc = scn.nextInt();
                    for (int i = 0; i < postc; i++) {
                        System.out.println("Type your post:");
                        String post = scn.next();
                        userPosts[postCount] = post;
                        postCount++;
                    }
                    break;
                case 2:
                    System.out.println("All user's Posts are:");
                    for (int i = 0; i < userPosts.length; i++) {
                        if(userPosts[i] != null){
                            System.out.println(i + ". " + userPosts[i]);
                        }
                    }
                    break;
                case 3:
                    isFinish = true;
                    System.out.println("User Successfully logged out");
                    System.out.println();
                    break;
                default:
                    System.out.println("Error while input");
            }
        }

    }
    public static void loggedUserMenu(){
        System.out.println("Type 1 to post:");
        System.out.println("Type 2 to see All posts:");
        System.out.println("Type 3 to logout");
    }

}