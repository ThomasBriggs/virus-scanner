/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusscaner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author bri16827755
 */
public class Hash {
    
    static String getFileChecksum(MessageDigest digest, File file) throws IOException{
        //Get file input stream for reading the file content
        FileInputStream inputStream = new FileInputStream(file);

        //Create byte array to read data in chunks
        byte[] byteArray = new byte[2048];
        int bytesCount = 0;
        while ((bytesCount = inputStream.read(byteArray)) != -1){
            digest.update(byteArray, 0, bytesCount);
        };

        inputStream.close();

        //Get the hash's bytes
        byte[] bytes = digest.digest();

        //This bytes[] has bytes in decimal format;
        //Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        
        //return complete hash
        return sb.toString();
    }
    
    static MessageDigest md5() throws NoSuchAlgorithmException{
        //Create an instance of the md5 hash to use in the getFileChecksum function
        return MessageDigest.getInstance("MD5");
    }
    
}
