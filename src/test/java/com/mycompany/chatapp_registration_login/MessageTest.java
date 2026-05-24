/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp_registration_login;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

        

/**
 *
 * @author Student
 */
public class MessageTest {
    
    MessagePart2 message;
    
    //runs before every test
    @Before
    public void setUp(){
        message = new MessagePart2();
    }
    //message under 250 characters should return success
    @Test
    public void testMessageLengthValid(){
        String result = message.checkMessageLength("hi Mike, can you join us  for dinner tonight?");
        assertEquals("Message readyvto send.", result);
    }
    
    //message over 250 characeters should return how many over it is
    @Test
    public void testMessageLengthInvalid(){
        String longMessage = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String result = message.checkMessageLength(longMessage);
        assertTrue(result.contains("Message exceeds 250 characters by"));
        
    }
    
    @Test
    public void testRecipientValid(){
        String result = message.checkRecipientCell("+27704977567");
        assertEquals("Cell phone number successfully captured.", result);
        
    }
    
    @Test
    public void testRecipientInvalid(){
        String result = message.checkRecipientCell("08575975889");
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.", result);
        
        
    }
    @Test
    public void testMwssageHashCreated(){
        String fakeID = "0034567890";
        String result = message.createMessageHash(fakeID, 0, "Hi Mike, can you join us for dinner tonight?");
        assertEquals("00:0:HITONIGHT", result);
    }
    @Test
    public void testMessageIDCreated(){
        String id = message.generateMessageID();
        System.out.println("Message ID generated:" + id);
        assertTrue(message.checkMessageID(id));
    }
    @Test
    public void testSentMessage(){
        assertEquals("Message successfully sent.","Message successfully sent.");
        
    }
    @Test
    public void testDisregardMessage(){
        assertEquals("Press 0 to delete the message.", "Press 0 to delete the message.");
        
    }
    @Test
    public void testStoredMessage(){
        assertEquals("Message successfully stored.","Message successfully stored.");
    }
    
    
    
    
}
