package com.company.Homework;

public class InvalidCredentialsException extends RuntimeException {

    private String username;
    private String password;

    public InvalidCredentialsException() {
    }

    public InvalidCredentialsException(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "InvalidCredentialsException{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}