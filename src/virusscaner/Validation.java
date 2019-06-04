/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusscaner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class of methods for validation inputs on a form and will return true if the
 * condition is met and false if it is not.
 * 
 * @author Thomas Briggs
 */
public class Validation {
    
    /**
     * Presence Check
     * 
     * @param check Input string that the program will preform a check on
     * @return True or false
     */
    public boolean pCheck(String check){
        //Precense check
        
        //Checks is length is 0
        if (check.length() == 0){
            //If lengths is equal to 0 then no string is present so returns false
            return false;
        }else {
            //If lenths is anything else apart from 0 a string is present so returns true
            return true;
        }
    }
    
    /**
     * Range check
     * 
     * @param check String that is going to be checked
     * @param min The minimum value in the range
     * @param max The maximum value in the range
     * @return True or false
     */
    public boolean rangeCheck(String check, int min, int max){
        //Turns string into int to do calculation on
        int intCheck = Integer.parseInt(check);
        
        //Checks if int is bigger than or equal to min and smaller than or equal to max
        if (intCheck >= min && intCheck <= max){
            return true;
        }else {
            return false;
        }
    }
    
    /**
     * Will check if a string is within a maximum value
     * 
     * @param check Inr to be checked
     * @param max Maximum value of the integer
     * @return True or false
     */
    public boolean maxRangeCheck(int check, int max){
        if (check <= max){
            return true;
        }else {
            return false;
        }
    }
    
    /**
     * Checks if Int is over a minimum value
     * 
     * @param check Int to be checked
     * @param min Minimum value of the integer
     * @return True or false
     */
    public boolean minRangeCheck(int check, int min){
        if (check >= min){
            return true;
        }else {
            return false;
        }
    }
    
    /**
     * Checks if a strings length is within a given range
     * 
     * @param check String to be checked
     * @param minLength Minimum length of the string
     * @param maxLength Maximum length of the string
     * @return True or false
     */
    public boolean lengthCheck(String check, int minLength, int maxLength){
        if (check.length() >= minLength && check.length() <= maxLength){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Checks if a string is over a minimum length
     * 
     * @param check String to be checked
     * @param length minimum length of the string
     * @return True or false
     */
    public boolean minLegnthCheck(String check, int length){
        if (check.length() >= length){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Checks if a string is within a maximum length
     * 
     * @param check String to be checked
     * @param length Maximum lengths of the string
     * @return True or False
     */
    public boolean maxLengthCheck(String check, int length){
        if (check.length() <= length){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     *  Checks if string is an integer
     * 
     * @param check String to be checked
     * @return True or False
     */
    public boolean intCheck(String check){
        //Try to convert the string to an int
        try{
            Integer.parseInt(check);
            //If it is able to convert the string to an int then the string only contained integers
            return true;
        }catch(NumberFormatException e){
            //If it failed then string did not only contain integers
            return false;
        }
    }
    
    /**
     * Checks of a string is in a date format (dd/mm/yy)
     * 
     * @param check String to be checked
     * @return True or false
     */
    public boolean dateFormatCheck(String check) {
        //Date Format check = dd/mm/yy

        //Initialising a return variable to return at the end
        boolean valid = false;

        //Sets a pattern to see if the input string matches it
        if(check.matches("([0-9]{2})/([0-9]{2})/([0-9]{2})")){
            //If patterns matches sets the return variable to true
            valid = true;
        }
        else{
            //If pattern does not much sets the return variable to false
            valid = false;
        }

        return valid;
    } 
    
    public boolean dateFormatCheckv2(String check) {
        //Date Format check = yyyy/mm/dd

        //Initialising a return variable to return at the end
        boolean valid = false;

        //Sets a pattern to see if the input string matches it
        if(check.matches("([0-9]{4})/([0-9]{2})/([0-9]{2})")){
            //If patterns matches sets the return variable to true
            valid = true;
        }
        else{
            //If pattern does not much sets the return variable to false
            valid = false;
        }

        return valid;
    }
    
    public boolean timeFormatCheck(String check) {
        //Time format check = hh:mm:ss
        
        //Initialising a return variable to return at the end
        boolean valid = false;
        
        //Sets a pattern to see if the input string matches it
        if(check.matches("([0-2]{1})([0-9]{1}):([0-6]{1})([0-9]{1}):([0-6]{1})([0-9]{1})")){
            //If patterns matches sets the return variable to true
            valid = true;
        }
        else{
            //If pattern does not much sets the return variable to false
            valid = false;
        }

        return valid;    
        
    }
    
}
