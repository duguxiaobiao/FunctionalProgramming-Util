package com.lonely.demo.第三章;

import com.lonely.lang.funcs.Function;

import java.util.regex.Pattern;

/**
 * @author EDZ
 * @description: TODO
 * @date 2021/1/4 18:00
 */
public class EmailDemo2 {


    final Pattern emailPattern = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

    /**
     * email验证工具
     */
    final Function<String,Boolean> emailChecker = email -> emailPattern.matcher(email).matches();


    void testEmail(String email) {
        if (emailChecker.apply(email)) {
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
