package by.kiryanova.selectioncommittee.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String USERNAME_REGEX = "^(\\w+){3,32}$";
    private static final String PASSWORD_REGEX = "/(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}/g";
    private static final int ZERO = 0;
    private static final int HUNDRED = 100;

    public static boolean validateSignup(String name, String secondName, String surname,
                                         String email, String login, String password, String confirmPassword,
                                         String passportId, String phone,
                                         String firstSubjectName, String secondSubjectName, String thirdSubjectName,
                                         String points1, String points2, String points3, String certificate, String faculty){

        boolean isValid = true;
        if (name.isEmpty() || name == null || secondName.isEmpty() || secondName == null || surname.isEmpty() || surname == null
                || email.isEmpty() || email == null || login.isEmpty() || login == null || password.isEmpty() || password == null
                || passportId.isEmpty() || passportId == null || phone.isEmpty() || phone == null
                || firstSubjectName.isEmpty() || firstSubjectName == null || secondSubjectName.isEmpty() || secondSubjectName == null
                || thirdSubjectName.isEmpty() || thirdSubjectName == null
                || points1.isEmpty() || points1 == null || points2.isEmpty() || points2 == null|| points3.isEmpty() || points3 == null
                || certificate.isEmpty() || certificate == null || faculty.isEmpty() || faculty == null){
            isValid = false;
        }
        return isValid;
    }

    public static boolean validateLogin(String username, String password){
        boolean isValid = true;

        if(username.isEmpty() || username == null || password.isEmpty() || password == null){
            isValid = false;
        }

        return isValid;
    }

    public static boolean validateUsername(String login){
        boolean isValid = true;

        if (login == null || login.isEmpty()){
            isValid = false;
        }
        Pattern loginPattern = Pattern.compile(USERNAME_REGEX);
        Matcher loginMatcher = loginPattern.matcher(login);

        if (!loginMatcher.matches()){
            isValid = false;
        }
        return isValid;
    }

    public static boolean validatePassword(String password){
        boolean isValid = true;
        if ( password == null || password.isEmpty()){
            isValid = false;
        }
        Pattern passwordPattern = Pattern.compile(PASSWORD_REGEX);
        Matcher passwordMatcher = passwordPattern.matcher(password);
        if (!passwordMatcher.matches()){
            isValid = false;
        }
        return isValid;
    }


    public static boolean validatePoints(int points){
        boolean isValid = true;

        if (points < ZERO || points > HUNDRED){
            isValid = false;
        }

        return isValid;
    }

    public static boolean validateEmail(String email){
        boolean isValid = true;

        return isValid;
    }

    public static boolean ifPasswordIsConfirmed(String password, String confirmedPassword){
        boolean isValid = true;

        if(!password.equals(confirmedPassword)){
            isValid = false;
        }

        return isValid;
    }

}
