/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp_registration_login;

import java.util.Scanner;
/**
 *
 * @author Student
 */
public class ChatApp_Main {
    public static void main(String[] args){
    
    Scanner scanner = new Scanner(System.in);
    ChatApp_registration_login login = new ChatApp_registration_login();
        System.out.println("Welcome to Quickchat");
        System.out.println();
        
        System.out.println("Register below");
        System.out.println();
        
        System.out.println("First name:");
        String firstName = scanner.nextLine();
        
        System.out.println("Last name:");
        String lastName = scanner.nextLine();
        
        System.out.println("Username (max 5 characters,must inlcude an underscore):");
        String username = scanner.nextLine();
        
        System.out.println("Password(min 8 characters, needs a capital letter, a"
                + "number and a special character):");
        String password = scanner.nextLine();
        
        System.out.println("Cell number(include international code,example +27831234567):");
        String cellNumber = scanner.nextLine();
        
        String registrationResult = login.registerUser(firstName,lastName,username,password,cellNumber);
        System.out.println();
        System.out.println(registrationResult);
        System.out.println();
        
        System.out.println("Login below:");
        System.out.println();
        
        System.out.println("Username:");
        String enterUsername = scanner.nextLine();
        
        System.out.println("Password");
        String enterPassword = scanner.nextLine();
        
        String loginResult = login.returnLoginStatus(enterUsername,enterPassword);
        System.out.println();
        System.out.println(loginResult);
        
        scanner.close();
        
    }
}
        
    

