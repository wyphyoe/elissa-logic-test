package piggybank;

public class Security {

    private static String password;
    private static boolean isClose;

    public static void setPassword(String password) {

        Security.password = password;
        Security.close();
    }

    public static String getPassword() {

        return Security.password;
    }

    public static void close() {

        Security.isClose = true;
    }

    public static boolean isClose() {
        return Security.isClose;
    }

    public static boolean open(String password) {

        if (password.equals(Security.getPassword())) {
            Security.isClose = false;
            return true;
        }
        return false;//Wrong Password
    }
}
