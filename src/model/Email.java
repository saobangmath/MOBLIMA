package model;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * validate whether an input matched email format
 * @author Phung Minh Khanh
 */
public class Email{
    /**
     * check a String whether  matched an email format
     * @param email
     * @return a boolean
     */
    public static boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}