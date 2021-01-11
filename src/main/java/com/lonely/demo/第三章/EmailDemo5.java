package com.lonely.demo.第三章;

import com.lonely.lang.funcs.Effect;
import com.lonely.lang.Result;
import com.lonely.lang.funcs.Function;

import java.util.regex.Pattern;

/**
 * @author EDZ
 * @description: TODO
 * @date 2021/1/4 18:00
 */
public class EmailDemo5 {


    final Pattern emailPattern = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

    public static void main(String[] args) {
        EmailDemo5 demo = new EmailDemo5();
        demo.emailChecker.apply("fds").bind(success, failure);
        demo.emailChecker.apply(null).bind(success, failure);
        demo.emailChecker.apply("dsafd@qq.com").bind(success, failure);
    }

    /**
     * email验证工具
     */
    final Function<String, Result<String>> emailChecker = email -> {
        if (email == null) {
            return Result.failure("email must not be null");
        } else if (emailPattern.matcher(email).matches()) {
            return Result.success(email);
        } else {
            return Result.failure("email " + email + "is invalid");
        }
    };

    static Effect<String> success = email -> System.out.println("send email : " + email);

    static Effect<String> failure = email -> System.out.println("logger error: " + email);
}
