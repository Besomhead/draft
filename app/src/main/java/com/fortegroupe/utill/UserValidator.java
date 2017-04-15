package com.fortegroupe.utill;

import com.fortegroupe.model.User;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validator for {@link com.fortegroupe.model.User} class,
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

public class UserValidator {

    private static final Pattern emailPtrn = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    private static final Pattern passwordPtrn = Pattern.compile("^[a-z0-9]+.{6,}$");

    public static boolean validatePassword(String password){
        Matcher matcher = passwordPtrn.matcher(password);
        return matcher.matches();
    }

    public static boolean validateEmail(String email){
        Matcher matcher = emailPtrn.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String password = "1234t6";
        Matcher matcher = passwordPtrn.matcher(password);
        System.out.println(matcher.matches());
    }
}
