package ru.job4j.early;

public class PasswordValidator {
    private static final String[] FORBIDDEN = {"qwerty", "12345", "password", "admin", "user"};

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (!containsUpperCase(password)) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }

        if (!containsLowerCase(password)) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }

        if (!containsDigit(password)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }

        if (!containsSpecialSymbol(password)) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }

        if (containsForbiddenSubstrings(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }

        return password;
    }

    private static boolean containsUpperCase(String password) {
        for (char symbol : password.toCharArray()) {
            if (Character.isUpperCase(symbol)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsLowerCase(String password) {
        for (char symbol : password.toCharArray()) {
            if (Character.isLowerCase(symbol)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsDigit(String password) {
        for (char symbol : password.toCharArray()) {
            if (Character.isDigit(symbol)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsSpecialSymbol(String password) {
        for (char symbol : password.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsForbiddenSubstrings(String password) {
        String passwordLowerCase = password.toLowerCase();
        for (String forbidden : FORBIDDEN) {
            if (passwordLowerCase.contains(forbidden)) {
                return true;
            }
        }
        return false;
    }
}
