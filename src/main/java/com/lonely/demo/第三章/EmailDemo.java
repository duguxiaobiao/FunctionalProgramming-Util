package com.lonely.demo.第三章;

import java.util.regex.Pattern;

/**
 * @author EDZ
 * @description: TODO
 * @date 2021/1/4 18:00
 */
public class EmailDemo {


    final Pattern emailPattern = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");


    void testEmail(String email) {
        if (emailPattern.matcher(email).matches()) {
            sendEmail(email);
        } else {
            logError("email " + email + " 无效地址");
        }
    }


    void sendEmail(String s) {
        System.out.println("send email : " + s);
    }


    private static void logError(String s) {
        System.out.println("logger error: " + s);
    }
}
