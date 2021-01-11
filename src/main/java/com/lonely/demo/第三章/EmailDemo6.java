package com.lonely.demo.第三章;

import com.lonely.control.ifelse.Case;
import com.lonely.lang.Result;
import com.lonely.lang.funcs.Effect;
import com.lonely.lang.funcs.Function;

import java.util.regex.Pattern;

/**
 * @author EDZ
 * @description: 使用 Case优化 if else
 * @date 2021/1/4 18:00
 */
public class EmailDemo6 {


    final Pattern emailPattern = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

    public static void main(String[] args) {
        EmailDemo6 demo = new EmailDemo6();
        demo.emailChecker.apply("fds").bind(success, failure);
        demo.emailChecker.apply(null).bind(success, failure);
        demo.emailChecker.apply("dsafd@qq.com").bind(success, failure);
    }

    /**
     * email验证工具
     */
    final Function<String, Result<String>> emailChecker = email -> Case.match(Case.defaultCase(() -> Result.failure("email " + email + "is invalid")),
            Case.mcase(() -> email == null, () -> Result.failure("email must not be null")),
            Case.mcase(() -> emailPattern.matcher(email).matches(), () -> Result.success(email)));

    static Effect<String> success = email -> System.out.println("send email : " + email);

    static Effect<String> failure = email -> System.out.println("logger error: " + email);
}
