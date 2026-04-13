/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp_registration_login;

import java.util.Scanner;


/**
 *
 * @author Student
 */
public class ChatApp_registration_login {
    Scanner input = new Scanner(System.in);
    
    //creating variables
    String username = "";
    String password = "";
    String cellPhoneNumber = "";
    String firstName = "";
    String lastName = "";


    ChatApp_registration_login() {
       
    }
    
    //creating methods
    public boolean checkUserName(String username){
        boolean hasUnderscore = false;
        boolean correctLength = false;
        
        if (username.contains("_")){
            hasUnderscore = true;
        }
        
        if (username.length()<=5){
            correctLength = true;
        }
        
        if (hasUnderscore == true && correctLength == true){
            return true;
        }else{
           return false;
        }     
        }
    public boolean checkPasswordComplexity(String password){
        boolean longEnough = false;
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        
        if (password.length()>=8){
            longEnough = true;
        }
        
        for(int i = 0; i <password.length(); i++){
            char c = password.charAt(i);
            
            if (Character.isUpperCase(c)){
        }
            
            if (Character.isDigit(c)){
            }
            
            if (!Character.isLetterOrDigit(c)){
                hasSpecial = true;
            }
        }
        
        if (longEnough == true && hasCapital == true && hasNumber == true && hasSpecial
                == true){
            return true;
        }else{
            return false;
        }

    }
    
    //regex from:https://stackoverflow.com/questions/24853480  
    boolean checkCellPhoneNumber(String cellPhoneNumber){
        
        if (cellPhoneNumber.matches("^\\+27[0-9]{9}$")){
            return true;
        }else{
            return false;
        }
    }
    
    public String registerUser(String firstName,String lastName,String username,String password,String cellPhoneNumber){
        
        String usernameMessage;
        String passwordMessage;
        String cellMessage;
        
        if (checkUserName(username) == true){
            usernameMessage = "Username successfully captured.";
            this.username = username;
    }else{
        usernameMessage = "Username is not correctly formatted; please ensure"
                + "that your username contains an underscore and is no more than "
                + "five characters in length.";
        }
        
        if (checkPasswordComplexity(password) == true){
            passwordMessage = "Password is successfully captured";
            this.password = password;
        }else{
            passwordMessage = "Password is not correctly formatted; please ensure"
                    + "that the password contains at least eight cahracters, a"
                    + "capital letter, a number, and a special character.";
        }
        
        if (checkCellPhoneNumber(cellPhoneNumber) == true){
            cellMessage = "Cell phone number successfully added.";
            this.cellPhoneNumber = cellPhoneNumber;
            this.firstName = firstName;
            this.lastName = lastName;
        }else{
            cellMessage = "cell phone number incorrectly formatted or does not"
                    + "contain international code.";
        }
        
        return usernameMessage + "\n" + passwordMessage + "\n" + cellMessage;
    }
    
    boolean loginUser(String username,String password){
        if (this.username.equals(username) && this.password.equals(password)){
            return true;
        }else{
            return false;
        }
        
    }
    
    public String returnLoginStatus(String username,String password){
        if (loginUser(username,password) == true){
            return "welcome" + firstName + ","+ lastName + "it is great to see you again.";
        }else{
            return "Username or password incorrect, please try again";
        }
    }

    String registerUser(String kyl_1, String chsecke99, String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
}
