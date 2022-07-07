public class Validator {


    private static void dataVerification(UserData userData) throws WrongLoginException, WrongPasswordException {
        if (!userData.getLogin().matches("[a-zA-Z0-9_]+") ||  userData.getLogin().length() > 20) {
            throw new WrongLoginException();
        }
        if (!userData.getPassword().matches("[a-zA-Z0-9_]+") || userData.getPassword().length() > 20) {
            throw new WrongPasswordException();
        }
        if (!userData.getConfirmPassword().equals(userData.getPassword())) {
            throw new WrongPasswordException();
        }
    }


    public static boolean checkUser(UserData userData) {
        try {
            dataVerification(userData);
        } catch (WrongLoginException e) {
            return false;
        } catch (WrongPasswordException e) {
            return false;
        }
        return true;
    }
}
