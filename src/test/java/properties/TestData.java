package properties;

import java.util.Random;

public class TestData {

    public static String login = "login";
    public static String password = "password";

    public static String getRandomEmail(){
        return getSaltString() + "@gmail.com";
    }
    public static String getRandomLogin(){
        return getSaltString();
    }

    public static String getRandomTesterLogin(){
        return "Tester" + getSaltString("0123456789", 6);
    }

    private static String getSaltString() {
        return getSaltString("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890", 12);
    }

    private static String getSaltString(String saltChars, int len){
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < len) { // length of the random string.
            int index = (int) (rnd.nextFloat() * saltChars.length());
            salt.append(saltChars.charAt(index));
        }
        return salt.toString();
    }
}
