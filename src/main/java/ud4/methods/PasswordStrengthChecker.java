package ud4.methods;

public class PasswordStrengthChecker
{
    public enum PasswordStrength {
        INVALID,
        WEAK,
        MEDIUM,
        STRONG
    }

    public static PasswordStrength checkStrength(String password) {
        if (password == null || password.length() < 8) {
            return PasswordStrength.INVALID;
        }

        boolean hasLowercase = password.matches(".*[a-z].*");
        boolean hasUppercase = password.matches(".*[A-Z].*");
        boolean hasSymbol = password.matches(".*[^a-zA-Z0-9].*");

        int typeCount = 0;
        if (hasLowercase) typeCount++;
        if (hasUppercase) typeCount++;
        if (hasSymbol) typeCount++;

        return switch (typeCount) {
            case 1 -> PasswordStrength.WEAK;
            case 2 -> PasswordStrength.MEDIUM;
            case 3 -> PasswordStrength.STRONG;
            default -> PasswordStrength.INVALID;
        };
    }
}
