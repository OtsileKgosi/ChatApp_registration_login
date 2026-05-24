/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.chatapp_registration_login;

import java.util.Random;

/**
 *
 * @author Student
 */
public class MessagePart2 { //variables to hold message details
    String messageID = "";
    String recipient = "";
    String messageText = "";
    String messageHash = "";
    int messageCount = 0;
    
    //checks the message ID is not longer than 10 characters
    public boolean checkMessageID(String messageID){
        if (messageID.length() <=10){
            return true;
        }else{
            return false;
        }
    }
    
    //checks the recipient number starts with +27 and has the right length
    public String checkRecipientCell(String recipient){
        if (recipient.matches("^\\+27[0-9]{9}$")){
            return "Cell phone number successfully captured";
        }else{
            return "Cell phone number is incorrectly formatted or does not contain"
                    + "international code. Please correct the number and try again.";
        }
    }
    
    //builds the message hash from the ID, count and first and last words
    public String createMessageHash(String messageID, int messageCount, String messageText){
        //get first two characters of the message ID
        String firstTwo = messageID.substring(0, 2);
        
        //split the message into words
        String[] words = messageText.trim().split(" ");
        
        //get the first and last word
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        
        //remove any punctuation from the last word
        lastWord = lastWord.replaceAll("[^a-zA-Z0-9]", "");
        
        //put it all together and make it uppercase
        String hash = firstTwo + ":" + messageCount + ":" + firstWord + lastWord;
        hash = hash.toUpperCase();
        
        return hash;
        
        
    }
    
    //generates a random 10 digit message ID
    public String generateMessageID(){
        Random random = new Random();
        String id = "";
        
        for (int i = 0; i < 10; i++){
        id = id + random.nextInt(10);
    }
        return id;
    }
    
   //checks the message is notvlonger than 250 characters
    public String checkMessageLength(String messageText){
        if (messageText.length() <= 250){
            return "Message ready to send.";
        }else{
            int over = messageText.length() - 250; 
            return "Message exceeds 250 characters by" + over + ";please reduce the size.";
        }
        
    }
    
    //stores all sent messages and returns them as a singlr string
    public String printMessages(String[] sentIDs, String[] sentHashes, String[] sentRecipients, String[] sentTexts, int totalSent){
        String result = "";
        
        for (int i = 0; i < totalSent; i++){
            result = result + "Message ID: " + sentIDs[i]+ "\n";
            result = result + "Hash:" + sentHashes[i] + "\n";
            result = result + "Recipient:" + sentRecipients[i] + "\n";
            result = result + "Message;" + sentTexts[i] + "\n";
            result = result + "\n";
        }
        return result;
    }
    
    //returns the total number of messages of messages sent
    public int returnTotalMessages(int totalSent){
        return totalSent;
    }
    
}




    
    

