public class Main  {
    public static void main(String[] args) {
        System.out.println(entrance("dd_FDb25d", "dd22222222222_FDb25d", "dd22222222222_FDb25d"));
    }

    public static boolean entrance(String login, String password, String confirmPassword) {
        return isFlagConfirmPassword(password,confirmPassword) && isFlagLogin(login) && isFlagPassword(password);
    }

    private static boolean isFlagLogin(String login) {
        char[] charLogin = login.toLowerCase().toCharArray();
        
        try {
            if (login.length() > 20) throw new WrongLoginException();
        } catch (WrongLoginException e) {
            throw new WrongLoginException();
        }
        return checkValidate(charLogin);
    }

    private static boolean isFlagPassword(String password) {
        char[] charPassword = password.toLowerCase().toCharArray();
        boolean flag = true;

        if(password.length()<=20) {
            checkValidate(charPassword);
        } else {
            flag = false;
        }
        return flag;
    }

    private static boolean isFlagConfirmPassword(String password,String confirmPassword){
        try {
            if (!password.equals(confirmPassword)) throw new WrongPasswordException();
        } catch (WrongPasswordException e) {
           throw new WrongPasswordException();
        }
        return true;
    }

    private static boolean checkValidate(char[] ch){
        boolean flag = true;
        for (char c : ch)
            if (!(c > 96 && c < 123 || Character.isDigit(c) || c == '_')) {
                flag = false;
                break;
            }
        return flag;
    }
}
