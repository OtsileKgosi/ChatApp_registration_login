/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.chatapp_registration_login;

import java.util.Scanner;
/**
 *
 * @author Student
 */
public class ChatApp_MainPart2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        //create login and message objects
        ChatApp_registration_login login = new ChatApp_registration_login();
        MessagePart2 message = new MessagePart2();
        
        System.out.println("Welcome to QuickChat.");
        System.out.println();
        
        //registration section
        System.out.println("Please register your account.");
        System.out.println();
        
        System.out.println("Frist name:");
        String firstName = scanner.nextLine();
        
        System.out.println("Last name:");
        String lastName = scanner.nextLine();
        
        System.out.println("Username (max 5 characters, must contain underscore):");
        String username = scanner.nextLine();
        
        System.out.println("Password (min 8 characters, must have capital, number and special charcter):");
        String password = scanner.nextLine();
        
        System.out.println("Cell number (example +27831234567:");
        String cellNumber = scanner.nextLine();
        
        //register and print the result
        String registrationResult = login.registerUser(firstName, lastName, username, password, cellNumber);
        System.out.println();
        System.out.println(registrationResult);
        System.out.println();
        
        //login section
        System.out.println("Please log in to your account.");
        System.out.println();
        
        System.out.println("Username:");
        String enterUsername = scanner.nextLine();
        
        System.out.println("Password:");
        String enterPassword = scanner.nextLine();
        
        //check login and print result
        boolean loggedIn = login.loginUser(enterUsername, enterPassword);
        String loginStatus = login.returnLoginStatus(enterUsername, enterPassword);
        System.out.println();
        System.out.println(loginStatus);
        System.out.println();
        
        //stop here if login failed
        if (loggedIn == false){
            System.out.println("Login failed. Exiting the application");
            scanner.close();
            return;
        }
        
        //ask how many messages the user wants to send
        System.out.println("How many messages do you want to send?");
        int totalMessages = Integer.parseInt(scanner.nextLine());
        System.out.println();
        
        //counters keep track of sent messages
        int messageSent = 0;
        int messageCount = 0;
        
        //arrays to store details of sent messages
        String[] sentMessageIDs = new String[totalMessages];
        String[] sentMessageHashes = new String[totalMessages];
        String[] sentMessageRecipients = new String[totalMessages];
        String[] sentMessageTexts = new String[totalMessages];
        
        //array to store messages saved for later
        String[] storeMessages = new String[totalMessages];
        int storedCount = 0;
        
        //main menu loop, keeps running until user picks quit
        boolean running = true;
        while (running == true){
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent");
            System.out.println("3) Quit");
            System.out.println("Choose an option:");
            
            int choice = Integer.parseInt(scanner.nextLine());
            //option 2 - send a message
            if (choice == 1){
                
                //check if the user has reached their message limit
                if(messageSent >= totalMessages){
                    System.out.println("You have already sent all your messages.");
                    System.out.println();
                }else{
                    String messageID = message.generateMessageID();
                    System.out.println("Message ID generated:" + messageID);
                    System.out.println();
                    
                    //get recipient number
                    System.out.println("Enter recipient cell number:");
                    String recipient = scanner.nextLine();
                    
                    //check if recipient number is valid
                    String recipientCheck = message.checkRecipientCell(recipient);
                    System.out.println(recipientCheck);
                    System.out.println();
                    
                    //only continue if recipeint is valid
                    if (recipientCheck.equals("Cell phone number is successfully captured.")== false){
                        System.out.println("Message cancelled. Reciepient number is not valid.");
                        System.out.println();
                    }else{
                        //get the message text
                        System.out.println("Enter your message (max 250 characters):");
                        String messageText = scanner.nextLine();
                        
                        //check message length
                        String lengthCheck = message.checkMessageLength(messageText);
                        
                        //stop if message is too long
                        if (lengthCheck.equals("Message ready to send.")== false){
                        System.out.println(lengthCheck);
                        System.out.println("Message cancelled.");
                            System.out.println("");
                    }else{
                            //increase the message count
                            messageCount = messageCount + 1;
                            
                            //build the message hash
                            String hash = message.createMessageHash(messageID, messageCount, messageText);
                            
                            //show the send options to the user
                            System.out.println("What do you want to do with this message?");
                            System.out.println("1)Send Message");
                            System.out.println("2)Disregard Message");
                            System.out.println("3)Store Message to send later");
                            System.out.println("Choose:");
                            int sendChoice = Integer.parseInt(scanner.nextLine());
                            System.out.println();
                            
                            //send the message
                            if(sendChoice == 1){
                                
                                //save details in the sent arrays
                                sentMessageIDs[messageSent] = messageID;
                                sentMessageHashes[messageSent] = hash;
                                sentMessageRecipients[messageSent] = recipient;
                                sentMessageTexts[messageSent] = messageText;
                                
                                //increase sent count
                                messageSent = messageSent + 1;
                                
                                System.out.println("Message successfully sent.");
                                System.out.println();
                                
                                //print full message details
                                System.out.println("Message ID:" + messageID);
                                System.out.println("Message Hash:" + hash);
                                System.out.println("Recipient:" + recipient);
                                System.out.println("Message:" + messageText);
                                System.out.println();
                                
                              //disregard the message  
                            }else if (sendChoice == 2){
                                System.out.println("Press 0 to delete the message.");
                                scanner.nextLine();
                                System.out.println();
                            }else if (sendChoice == 3){
                                storeMessages[storedCount] = messageText;
                                storedCount = storedCount + 1;
                                System.out.println("Message successfully stored.");
                                System.out.println();
                            }
                        }
                    }
                    
                }
                //option 2 - show recent messages
            }else if (choice == 2){
                System.out.println("Coming soon.");
                System.out.println();
                
                //option 3 - quit the app
            }else if (choice == 3){
            running = false;
        }else{
                System.out.println("Please choose 1, 2 or 3.");
                System.out.println();
            }
        }
        
        //show total messages sent when app closes
        System.out.println("Total message sent:" + message.returnTotalMessages(messageSent));
        System.out.println();
        
        //print all sent messages
        if(messageSent > 0){
            System.out.println("All sent messages:");
            System.out.println(message.printMessages(sentMessageIDs, sentMessageHashes, sentMessageRecipients, sentMessageTexts, messageSent));
        }
        
        scanner.close();
    }

  
    }
    

