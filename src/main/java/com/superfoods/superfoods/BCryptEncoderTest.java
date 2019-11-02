package com.superfoods.superfoods;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptEncoderTest {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        for(int i = 1; i<10; i++ ){

            String encoderString = encoder.encode("1234!@#$");
            System.out.println(encoderString);
        }
        
    }
}
