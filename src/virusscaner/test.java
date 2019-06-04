/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusscaner;

import java.io.IOException;
import static java.lang.Math.random;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


/**
 *
 * @author Thomas Briggs
 */
public class test {
    
    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String args[]) throws IOException{
        String test = "test\\";
        System.out.println(test.contains("\\"));
    }
    
    public static boolean isVal(int test){
        if (test == 10){
            return false;
        } if (test == 500){
            return false;
        }
        return true;
    }

    private static void genIdV3(int[] id) {
        int start = id[0];
        int end = id[id.length-1];
        int mid = ((start + end)/2);
        int startIndex = 0;
        int endIndex = id.length-1;
        int midIndex = endIndex/2;
        
        System.out.println("Should be: " + mid);
        System.out.println("What is it: " + id[midIndex]);
    }
    
}