/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solace.library;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *
 * @author sachith
 */
public class encryption {
    
    public static String MD5(String input){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while(hashtext.length()<32){
                hashtext = "0"+hashtext;
            }
            return hashtext;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static String SHA1(String input){
        try {
            MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++){
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
            }
         return sb.toString();
               
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        }
    
    
    public static String SHA512(String input){
        
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] data = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for(byte b : data){
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
