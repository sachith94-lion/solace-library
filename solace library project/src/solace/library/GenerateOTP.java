/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solace.library;

import java.util.Random;

/**
 *
 * @author sachith
 */
public class GenerateOTP {
    
    static char[] sendOTP(int length){
        
        //System.out.println("Your otp for this transaction is: ");
        String numbers="0123456789";
        Random r = new Random();
        char[] otp = new char[length];
        for(int i=0;i<length;i++){
            otp[i]=numbers.charAt(r.nextInt(numbers.length()));
        }
        return otp;
    }
}
