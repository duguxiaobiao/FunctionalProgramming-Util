//package com.lonely.demo.第三章;
//
//import com.lonely.lang.Executable;
//import com.lonely.lang.Result;
//import com.lonely.lang.funcs.Function;
//
//import java.util.regex.Pattern;
//
///**
// * @author EDZ
// * @description: TODO
// * @date 2021/1/4 18:00
// */
//public class EmailDemo4 {
//
//
//    final Pattern emailPattern = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");
//
//    public static void main(String[] args) {
//        EmailDemo4 demo = new EmailDemo4();
//        demo.validate("fd").exec();
//        demo.validate(null).exec();
//        demo.validate("dsafd@qq.com").exec();
//    }
//
//    /**
//     * email验证工具
//     */
//    final Function<String, Result> emailChecker = email -> {
//        if (email == null) {
//            return new Result.Failure("email must not be null");
//        } else if (emailPattern.matcher(email).matches()) {
//            return new Result.Success();
//        } else {
//            return new Result.Failure("email " + email + "is invalid");
//        }
//    };
//
//
//    Executable validate(String email) {
//        Result result = emailChecker.apply(email);
//        if (result instanceof Result.Success) {
//            return () -> sendEmail(email);
//        } else {
//            return () -> logError(((Result.Failure) result).getErrorMessage());
//        }
//    }
//
//
//
//    void sendEmail(String s) {
//        System.out.println("send email : " + s);
//    }
//
//
//    private static void logError(String s) {
//        System.out.println("logger error: " + s);
//    }
//}
