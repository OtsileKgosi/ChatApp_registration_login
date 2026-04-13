/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp_registration_login;

import com.mycompany.chatapp_registration_login.ChatApp_registration_login;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Student
 */
public class LoginTest {
    
    ChatApp_registration_login login;
    
    @Before
    public void setup(){
        login = new ChatApp_registration_login ();
        login.firstName = " ";
        login.lastName = " ";
    }
    
    @Test
    public void testUsernameCorrect(){
        String result = login.registerUser("kyl_1", "ch&&sec@ke99!", "+27699863685");
        
        assertTrue(result.contains("Username successfully captured"));  
    }
    
    @Test
    public void testUsernameIncorrect(){
        String result = login.registerUser("kyl_1!!!!!!!!","Ch&&sec@ke99!","+27699863685");
        
        assertTrue(result.contains("Username is not correctly formatted;please ensure that"
                + "your username contains an underscore and is no more than 5 characters in length"));
    }
    
    @Test
    public void testPasswordCorrect(){
        String result = login.registerUser("kyl_1","ch&&sec@ke99!", "+27699863685");
        
        assertTrue(result.contains("Password is successfully captured"));
    }
    
    @Test
    public void testPasswordIncorrect(){
        String result = login.registerUser("ots_1","As&&tro@ig99!", "+27699863685");
        
        assertTrue(result.contains("Password is not correctly formatted;please ensure that"
                + "the password contains at least 8 characters,capital letter,a number, and a"
                + "specail character"));
    }
    
    @Test
    public void testUsernameValidFalse(){
        assertFalse(login.checkUserName("ots_1!!!!!!!!"));          
    }
    
    @Test
    public void testPasswordValidTrue(){
        assertTrue(login.checkPasswordComplexity("As&&tro@ig99!"));
        
    }
    
    @Test
    public void testPasswordValidFalse(){
        assertFalse(login.checkPasswordComplexity("password"));
    }
    
    @Test
    public void testCellValidTrue(){
        assertTrue(login.checkCellPhoneNumber("+27699863685"));     
    }
    
    @Test
    public void testCellvalidFalse(){
        assertFalse(login.checkCellPhoneNumber("0699863685"));
    }
    
    
    
    
    
}
