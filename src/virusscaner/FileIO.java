/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusscaner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Thomas Briggs
 */
public class FileIO {
    
    /**
     *
     * @param filename String of the file name
     * @return Return the integer amount of rows used in the file
     * @throws FileNotFoundException
     * @throws IOException
     */
    public int rowAmount(String filename) throws FileNotFoundException, IOException{
        String lineRead = null;
        //Creating reader and buffer for the file
        FileReader reader = new FileReader(filename);
        BufferedReader buffer = new BufferedReader(reader);
        //Init the rows to 0
        int rows = 0;
        //While the lineRead is not empty read next line
        while ((lineRead = buffer.readLine()) != null){
            //For every row in the file +1 to the row count
            rows++;
        }
        
        //Close buffer and reader
        buffer.close();
        reader.close();
        
        return rows;
    }
    
    /**
     *
     * @param filename String of the file name
     * @return Return a String array of the content in the file
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String[] read(String filename) throws FileNotFoundException, IOException{
        String lineRead = null;
        FileReader reader = new FileReader(filename);
        BufferedReader buffer = new BufferedReader(reader);
        //Initalise a empty array of size the amount of rows in the file
        String[] output = new String[rowAmount(filename)];
        int n = 0;
        while ((lineRead = buffer.readLine()) != null){
            //For every line in the file set the element to the line data
            output[n] = lineRead;
            //Increment n to write next line to next element
            n++;
        }
        
        buffer.close();
        reader.close();
        
        return output; 
    }
    
    /**
     *
     * @param filename String of the file name
     * @param row
     * @param col
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String[][] read2dArray(String filename, int row, int col) throws FileNotFoundException, IOException{
        String lineRead = null;
        FileReader reader = new FileReader(filename);
        BufferedReader buffer = new BufferedReader(reader);
        
        String[][] array2d = new String[row][col];
        String[] rowData = new String[row];
        
        for(int i = 0; i < row;i++){
            rowData = (buffer.readLine()).split(",");
            for(int j = 0; j < col;j++){
                array2d[i][j] = (rowData[j]);
            }
        }
        return array2d;
    }
    
    /**
     *
     * @param filename String of the file name
     * @param col
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String[][] read2dArray(String filename, int col) throws FileNotFoundException, IOException{
        int row = rowAmount(filename);
        String lineRead = null;
        FileReader reader = new FileReader(filename);
        BufferedReader buffer = new BufferedReader(reader);
        
        String[][] array2d = new String[row][col];
        String[] rowData = new String[row];
        
        for(int i = 0; i < row;i++){
            rowData = (buffer.readLine()).split(",");
            for(int j = 0; j < col;j++){
                array2d[i][j] = (rowData[j]);
            }
        }
        return array2d;
    }
    
    /**
     *
     * @param filename String of the file name
     * @param saveData
     * @param append
     * @throws IOException
     */
    public void saveLine(String filename, String saveData, boolean append) throws IOException{
        FileWriter writer = new FileWriter(filename, append);
        writer.write(saveData);
        writer.write("\n");
        writer.close();
    }
    
    /**
     *
     * @param filename String of the file name
     * @param saveData
     * @throws IOException
     */
    public void saveArray(String filename, String[] saveData) throws IOException{
        int length = saveData.length;
        saveLine(filename, saveData[0], false);
        for (int i = 1; i < length; i++){
            saveLine(filename, saveData[i], true);
        }
    }
    
    /**
     *
     * @param filename String of the file name
     * @param saveData
     * @param row
     * @throws IOException
     */
    public void save2dArray(String filename, String[][] saveData,int row) throws IOException{
        FileIO io = new FileIO();
        String test[] = new String[row];
        for(int i = 0; i < row; i++){
            test[i] = String.join(",", saveData[i]);
        }
        io.saveArray(filename, test);
    }
    
    /**
     *
     * @param filename String of the file name
     * @param saveData
     * @throws IOException
     */
    public void save2dArray(String filename, String[][] saveData) throws IOException{
        int row = rowAmount(filename);
        FileIO io = new FileIO();
        String test[] = new String[row];
        for(int i = 0; i < row; i++){
            test[i] = String.join(",", saveData[i]);
        }
        io.saveArray(filename, test);
    }
    
    /**
     *
     * @param dataArray String of the file name
     * @param index
     * @param fileName
     * @throws IOException
     */
    public void delRecord(String[] dataArray, int index, String fileName) throws IOException{
        int length = dataArray.length;
        dataArray[index] = dataArray[dataArray.length-1];
        String[] newdataArray = new String[length-1];
        for(int i = 0; i < length-1;i++){
            newdataArray[i] = dataArray[i];
        }
        saveArray(fileName, newdataArray);
    }
}
    
