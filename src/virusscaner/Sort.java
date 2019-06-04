/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusscaner;

import java.io.IOException;
import java.util.Arrays;

/**
 * Class of methods with sorting algorithms for sorting data
 * @author Thomas Briggs
 */
public class Sort {
    
    /**
     * A bubble sort algorithm used to sort a given array used to sort mostly sorted arrays
     * @param input The input integer array to be sorted
     * @param inverse Boolean if you want the sort to be descending
     */
    public void bubbleSort(int[] input, boolean inverse){
        //Initialize a temp variable for swapping values in an array
        int temp;
        
        //For loop to manipulate the array and set the first pointer
        for (int i = 0; i < input.length-1; i++){
            //For loop to manipulate the array and set the second pointer
            for (int j = 0; j < input.length-1-i; j++){
                
                //If the reverse variable was set to true to preforme a descending sort
                if (inverse){
                    //If the first pointer is smaller than the second pointer
                    if (input[j] < input[j+1]){
                        //Swap elements in the array
                        //Set temp to 1 the first element
                        temp = input[j];
                        //Set the first element to the second selement
                        input[j] = input[j+1];
                        //Set the second element to the temp
                        input[j+1] = temp;
                    }
                //If reverse is not set to true prefrom an ascending sort 
                }else{
                    //If the first pointer is larger than the second
                    if (input[j] > input[j+1]){
                        //Swap elements
                        temp = input[j];
                        input[j] = input[j+1];
                        input[j+1] = temp;
                    }   
                }
            }
        }
    }
    
    /**
     * An insertion sort algorithm to sort a mostly unsorted array
     * 
     * @param input The input integer array to be sorted
     */
    public void insertionSort(int [] input){
        //Set n to the length of the array
        int n = input.length;
        //Initialize j outside the loop so its value is not reset
        int j;
        //For loop so the swap knows how many times to happen
        for (int i = 1; i<n; i++){
            j = i;
            //Temp variable for swapping elements in an array
            int temp = input[i];
            //While second pointer is bigger than 0 and bigger than the first pointer
            while (j > 0 && input[j-1] > temp) {
                //Swap elements
                input[j] = input[j-1];
                //Decrement j
                j--;
            }
            //Finish element swap
            input[j] = temp;
                
        }
    }
    
    /**
     *  Quick sort to recursively sort an integer array
     * 
     * @param sortme The input integer array to be sorted
     * @param first The start of the array to be sorted
     * @param last The end of the array to be sorted
     */
    public void quickSort(int[] sortme, int first, int last){
        //To make sure the pointers to not cross eachother
        if (last > first){
            //Set the left pointer to first
            int left = first;
            //Set the right pointer to last
            int right = last;
            //Set the pivot to the middle
            int pivot = sortme[(first + last)/2];
            
            //While the pointers are not at eachother
            while (left >= right){
                //While the value of the element at left is less than th pivot
                while (sortme[left] < pivot){
                    //Increases the left pointer by 1
                    left = left + 1;
                }

                //While the value of the element at right is more than the pivot
                while (sortme[right] > pivot){
                    //Decreases the right pointer by 1
                    right = right - 1;

                }

                //Swaps elements in the array
                int temp = sortme[left];
                sortme[left] = sortme[right];
                sortme[right] = temp;
                
            }
            
            //Recursively calls quickSort to sort the new left and right side
            quickSort(sortme, first, left-1);
            quickSort(sortme, right+1, last);
        }
    }
    
    /**
     * Will bubble sort
     * 
     * @param filename The string name of the file
     * @param index The index of the field to be sorted by
     * @param col The amount of columns in the file
     * @throws IOException
     */
    public void bubbleSort2dArraySave(String filename, int index, int col) throws IOException{
        FileIO io = new FileIO();
        String[][] readArray = io.read2dArray(filename, col);
        String[] temp = null;
        int rows = io.rowAmount(filename);
        for(int i=0; i<rows-1;i++){
            for(int j=0;j<rows-1-i;j++){
                if(Integer.parseInt(readArray[j][index]) > Integer.parseInt(readArray[j+1][index])){
                    temp = readArray[j];
                    readArray[j] = readArray[j+1];
                    readArray[j+1] = temp;  
                }
            }
        }
        io.save2dArray(filename, readArray);
    }
    
    /** 
    * Bubble sort algorithm to sort a 2d database file by a certain field 
    * 
    * @param filename The string name of the file 
    * @param index The integer index of the field to be sorted by 
    * @param col The amount of columns in the file 
    * @return The sorted array so it can be shown
    * @throws IOException
    */
    
    public String[][] bubbleSort2dArray(String filename, int index, int col) throws IOException{
        FileIO io = new FileIO();
        String[][] readArray = io.read2dArray(filename, col);
        String[] temp = null;
        int rows = io.rowAmount(filename);
        for(int i=0; i<rows-1;i++){
            for(int j=0;j<rows-1-i;j++){
                if(Integer.parseInt(readArray[j][index]) > Integer.parseInt(readArray[j+1][index])){
                    temp = readArray[j];
                    readArray[j] = readArray[j+1];
                    readArray[j+1] = temp;  
                }
            }
        }
        return readArray;
    }
    
    /**
     *
     * @param filename The string name of the file 
     * @param index The integer index of the field to be sorted by 
     * @param col The amount of columns in the file 
     * @param reverse Boolean to set if the sort should be in descending order
     * @return The sorted array so it can be shown
     * @throws IOException
     */
    public String[][] bubbleSort2dArray(String filename, int index, int col, boolean reverse) throws IOException{
        FileIO io = new FileIO();
        String[][] readArray = io.read2dArray(filename, col);
        String[] temp = null;
        int rows = io.rowAmount(filename);
        for(int i=0; i<rows-1;i++){
            for(int j=0;j<rows-1-i;j++){
                if(reverse){
                    if(Integer.parseInt(readArray[j][index]) < Integer.parseInt(readArray[j+1][index])){
                        temp = readArray[j];
                        readArray[j] = readArray[j+1];
                        readArray[j+1] = temp;  
                    }
                }else{
                   if(Integer.parseInt(readArray[j][index]) > Integer.parseInt(readArray[j+1][index])){
                        temp = readArray[j];
                        readArray[j] = readArray[j+1];
                        readArray[j+1] = temp;  
                    } 
                }
            }
        }
        return readArray;
    }
    
}
