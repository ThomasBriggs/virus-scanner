/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusscaner;

import java.io.IOException;

/**
 * A class to contain the information of the current logged in user
 * 
 * @author ThomasBriggs
 */
public class User {
    
    static String userId;
    static String username;
    static String fullname;
    static String dob;
    static String department;
    static int access;
    
    /**
     * Sets the current logged in user and sets the other variables for the class
     * 
     * @param id The integer id of the current logged in user
     * @param usernameInput The string username of the current logged in user
     * @throws IOException
     */
    public static void set(int id, String usernameInput) throws IOException{
        Search se = new Search();
        FileIO io = new FileIO();
        //Reads the databse file as a 2d array to be manipulated
        String[][] users = io.read2dArray("Users.txt", io.rowAmount("Users.txt"), 5);
        //Searches through the database to give the row of the given Id
        int row = se.idSearch(String.valueOf(id), "Users.txt");
        
        //Sets the variables from the databse
        username = usernameInput;
        userId = users[row][0];
        fullname = users[row][1];
        dob = users[row][2];
        department = users[row][3];
        access = Integer.parseInt(users[row][4]);
        
    }
    
    /**
     * Used for skip button at login
     */
    public static void setAdmin(){
        //sets variables to an admin
        username = "Admin";
        userId = "999";
        fullname = "Admin";
        dob = "01/01/01";
        department = "1";
        access = 5;
        
    }
    
}
