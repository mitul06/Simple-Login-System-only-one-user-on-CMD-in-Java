package com.login;

import java.util.Scanner;

public class login {

    private String email;
    private String pass;
    private String name;

    Scanner sc = new Scanner(System.in);

    private void userLogin() {
        System.out.println("Please Choose any an options...");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");

        int userEnterNum = sc.nextInt();

        switch (userEnterNum) {

            case 1:
                System.out.println("First Register with email and password");
                System.out.println("You not Register then type : Reg");
                System.out.println("You Registered then type : Log");

                String user = sc.next().toLowerCase();
                if (user.equals("reg")) {
                    register();
                } else if (user.equals("log")) {
                    userLoginCheck();
                }

                break;

            case 2:
                register();
                break;

            case 3:
                System.out.println("Exit...");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid input");
                break;

        }

    }

    private void register() {
        System.out.print("Enter Name : ");
        name = sc.next().toLowerCase();
        System.out.print("Enter Email : ");
        email = sc.next().toLowerCase();
        System.out.print("Enter Pass: ");
        pass = sc.next().toLowerCase();
        System.out.println("Register successfully");
    }

    private void userLoginCheck() {
        String userEmail;
        String userPass;

        System.out.print("Enter Email : ");
        userEmail = sc.next().toLowerCase();

        System.out.print("Enter Pass : ");
        userPass = sc.next().toLowerCase();

        if (userEmail.equals(email) && userPass.equals(pass)) {
            System.out.println("Logged in Successfully!");
        } else if (userEmail.equals(email) && !userPass.equals(pass)) {
            System.out.println("Please Check password");
            userLogin();
        } else if (!userEmail.equals(email) && userPass.equals(pass)) {
            System.out.println("Please Check Email");
            userLogin();
        } else {
            System.out.println("Please enter valid email and password");
            userLogin();
        }
    }

    private void resetPass() {
        System.out.print("Enter current pass : ");
        String resetp = sc.next().toLowerCase();
        if (resetp.equals(pass)) {
            System.out.print("Enter new pass : ");
            String newP = sc.next().toLowerCase();
            pass = newP;
            System.out.println("Congratulation! Password is reset.");
        } else {
            System.out.println("Something going wrong, Please Enter Current Valid password");
        }
    }

    private void userDisplay() {
        System.out.println("Please Choose any an options...");
        System.out.println("1. Show User");
        System.out.println("2. Reset Password");
        System.out.println("3. Log Out");

        int userDisNum = sc.nextInt();

        switch (userDisNum) {

            case 1:
                System.out.println("Your Name : " +name);
                System.out.println("Email is : " +email);
                break;

            case 2:
                resetPass();
                break;

            case 3:
                System.out.println("Log Out...");
                userLogin();
                break;

            default:
                System.out.println("Invalid input");
                break;
        }

    }

    public static void main(String[] args) {
        login log = new login();
        log.userLogin();
        do {
            log.userDisplay();
        } while (true);
    }

}
