package PagesUrls;

public class PagesUrls {

    public static String mainPage = baseUrl();

    public static String baseUrl() {
//        String base = System.getenv("TEST_HOST_JOWI");
//        return "https://" + base;
        return "https://app.jowi.online";
    }

    public static String authSignUp() {
        return mainPage + "/auth/sign-up";
    }

    public static String companies() {
        return mainPage + "/companies";
    }
}
