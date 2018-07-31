package by.kiryanova.selectioncommittee.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String NAME_REGEX = "^[A-ZА-Я][a-zа-я]+";
    private static final String EMAIL_REGEX = "[\\w-\\.]+@[\\w-]+\\.[a-z]{2,3}";
    private static final String LOGIN_REGEX = "^[A-Za-z][A-Za-z0-9_]+";
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z]).{4,}";
    private static final String PASSPORT_ID_REGEX = "[A-Z]{2}[0-9]{7}";
    private static final String PHONE_REGEX = "\\(\\d{3}\\)\\d{3}-?\\d{4}";
    private static final String POINTS_REGEX = "^[1-9]$|^[1-9][0-9]$|^(100)$";

    //private static final String USERNAME_REGEX = "^(\\w+){3,32}$";
    //private static final String PASSWORD_REGEX = "/(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}/g";
    //private static final int ZERO = 0;
    //private static final int HUNDRED = 100;

    private static boolean isDataMatch(String data, String regex) {

        if (data == null || data.isEmpty()) {
            return false;
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);

        return matcher.matches();
    }


    public static boolean validateSigningUp(String surname, String name, String secondName,
                                            String email, String login, String password,
                                            String passportId, String phone,
                                            String points1, String points2, String points3, String certificate){
        boolean isValid;

        isValid = isDataMatch(surname, NAME_REGEX) && isDataMatch(name, NAME_REGEX) && isDataMatch(secondName, NAME_REGEX) &&
                isDataMatch(email, EMAIL_REGEX) && isDataMatch(login, LOGIN_REGEX) && isDataMatch(password, PASSWORD_REGEX) &&
                isDataMatch(passportId, PASSPORT_ID_REGEX) && isDataMatch(phone, PHONE_REGEX) &&
                isDataMatch(points1, POINTS_REGEX) && isDataMatch(points2, POINTS_REGEX) && isDataMatch(points3, POINTS_REGEX) && isDataMatch(certificate, POINTS_REGEX);

        return isValid;
    }

    public static boolean validateChangingInformation(String surname, String name, String secondName, String passportId, String phone){
        boolean isValid;

        isValid = isDataMatch(surname, NAME_REGEX) && isDataMatch(name, NAME_REGEX) && isDataMatch(secondName, NAME_REGEX) &&
                isDataMatch(passportId, PASSPORT_ID_REGEX) && isDataMatch(phone, PHONE_REGEX);

        return isValid;
    }
    public static boolean validateLogin(String username, String password){
        boolean isValid = true;

        if(username.isEmpty() || username == null || password.isEmpty() || password == null){
            isValid = false;
        }

        return isValid;
    }

    //public static boolean validateUsername(String login){
    // boolean isValid = true;

    //if (login == null || login.isEmpty()){
    //    isValid = false;
    // }
    // Pattern loginPattern = Pattern.compile(USERNAME_REGEX);
    // Matcher loginMatcher = loginPattern.matcher(login);

    // if (!loginMatcher.matches()){
    //    isValid = false;
    //  }
    //  return isValid;
    // }

    //  public static boolean validatePassword(String password){
    // boolean isValid = true;
    // if ( password == null || password.isEmpty()){
    //     isValid = false;
    //  }
    //  Pattern passwordPattern = Pattern.compile(PASSWORD_REGEX);
    //   Matcher passwordMatcher = passwordPattern.matcher(password);
    // if (!passwordMatcher.matches()){
    //    isValid = false;
    //   }
    //    return isValid;
    // }


    // public static boolean validatePoints(int points){
    //     boolean isValid = true;

    //    if (points < ZERO || points > HUNDRED){
    //       isValid = false;
    //  }

    // return isValid;
    // }

    //public static boolean validateEmail(String email){
    // boolean isValid = true;

    // return isValid;
    //}

    public static boolean ifPasswordIsConfirmed(String password, String confirmedPassword){
        boolean isValid = true;

        if(!password.equals(confirmedPassword)){
            isValid = false;
        }

        return isValid;
    }

}
