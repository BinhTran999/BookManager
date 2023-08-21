package com.cc.bookmanager.validate;

import com.cc.bookmanager.exception.InvalidEmailFormatException;
import com.cc.bookmanager.exception.InvalidPasswordFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassValidator {

    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    public static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public static boolean isValidPassword(String password){
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean isValidEmail(String email){
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void check(String password, String email){
        if (!isValidEmail(email)){
            throw new InvalidEmailFormatException("Email không đúng định dạng. Vui lòng nhập lại");
        }
        else if (!isValidPassword(password)){
            throw new InvalidPasswordFormatException("Mật khẩu cần có kí tự chữ hoa, chữ thường, chữ số và không có kí tự đặc biệt. Vui lòng nhập lại");
        }
    }

    public String convertToAsterisks(String pasword) {
        int length = pasword.length();
        StringBuilder asterisks = new StringBuilder();

        for (int i = 0; i < length; i++) {
            asterisks.append("*");
        }

        return asterisks.toString();
    }
}
