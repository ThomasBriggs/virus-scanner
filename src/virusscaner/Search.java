/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusscaner;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Thomas Briggs
 */
public class Search {
    
    /**
     * Return if an integer is in an array
     * 
     * @param list The name of the integer array to search
     * @param item The integer to find in the array
     * @return
     */
    public boolean intSearch(int[] list, int item){
        //Sets a flag variable
        boolean itemFound = false; 
        //For loop to go through every element in the array
        for (int i = 0; i < list.length; i++){
            //If the item in the array is equal to the item
            if (list[i] == item){
                //Set flag variable to true
                itemFound = true;
                break;
            }
        }
        //return flag variable
        return itemFound;
    }
    
    /**
     * Return if an integer is in an array in a binary way to increase efficency
     * 
     * @param list The name of the integer array to search
     * @param item The integer to find in the array
     * @return
     */
    public boolean binarySearch(int[] list, int item){
        
        //Initialise the first and last variables to be the start, end of the array
        int first = 0;
        int last = list.length-1;
        //Init the mid variable to be set later
        int mid;
        //Flag variable
        boolean found = false;
        
        do{
           
           //Sets the mid of the array to the first + last / 2
           mid = (first + last) / 2;
           
           //If the mid is equal to the item then it was in the array
           if(list[mid] == item){
               //sets flag to true
               found = true;
           }
           //If item is smaller than the middle of the array
           if (item < list[mid] ){
               //Sets the new end of the array to the mid - 1
               last = (mid-1);
               
           //Else than the item is bigger than the middle   
           }else{
               //Sets the new start of the array to the mid + 1
               first = (mid +1);
           }
        
        //If the pointers cross then the item was not in the array
        }while(found == false && last > mid);
        
        return found;
        
    }
    
    /**
     *
     * @param id The string of the id to search for
     * @param filename The string name of the file to be searched
     * @return Will return an integer of the row the id was on
     * @throws IOException
     */
    public int idSearch(String id, String filename) throws IOException{
        FileIO io = new FileIO();
        int number = -1;
        
        //Reads the file into a 1d array
        String[] dataArray = io.read(filename);
        int length = dataArray.length;
        for(int i=0; i < length; i++){
            //Slipts the array to just get the id
            String[] checkArray = dataArray[i].split(",");
            String check = checkArray[0];
            //If the id is equal to the search id
            if(check.equals(id)){
                //Set number to the row
                number = i;
                break;
            }
        }
        //Returns the row of the id was found at
        return number;
    }
    
    /**
     *
     * @param list
     * @param item
     * @return
     */
    public static ArrayList<Integer> stringWildSearchList(String[] list, String item){
        ArrayList<Integer> values = new ArrayList<>();
        boolean itemFound = false; 
        for (int i = 0; i < list.length; i++){
            if (list[i].equals(item) || list[i].contains(item)){
                itemFound = true;
                values.add(i);
            }
        }
        return values;            
    }
    
}
