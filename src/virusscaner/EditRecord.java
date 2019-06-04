/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusscaner;

import java.io.IOException;
import static virusscaner.User.username;

/**
 *
 * @author thomasbriggs
 */
public class EditRecord {
    
    static String Id;
    static String fullname;
    static String dob;
    static String department;
    static int access;
    static int selectedIndex;
    static String userAddedId;
    static String date;
    static String time;
    static String dir;
    
     public static void setUser(int id, int index) throws IOException{
        Search se = new Search();
        FileIO io = new FileIO();
        //Reads the databse file as a 2d array to be manipulated
        String[][] users = io.read2dArray("Users.txt", io.rowAmount("Users.txt"), 5);
        //Searches through the database to give the row of the given Id
        int row = se.idSearch(String.valueOf(id), "Users.txt");
        
        //Sets the variables from the databse
        Id = users[row][0];
        fullname = users[row][1];
        dob = users[row][2];
        department = users[row][3];
        access = Integer.parseInt(users[row][4]);
        selectedIndex = index;
    }
     
    public static void setLog(int id, int index) throws IOException{
        Search se = new Search();
        FileIO io = new FileIO();
        String[][] logs = io.read2dArray("log.txt", io.rowAmount("log.txt"), 4);
        int row = se.idSearch(String.valueOf(id), "log.txt");
        
        Id = logs[row][0];
        String[] dateandtime = logs[row][1].split(" ");
        date = dateandtime[0];
        time = dateandtime[1];
        dir = logs[row][2];
        userAddedId = logs[row][3];
    }
}
