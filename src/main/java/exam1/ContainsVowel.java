package exam1;

public class ContainsVowel {
    public static boolean containsVowel(String str) {
        if (str == null) return false;
        return str.toLowerCase().matches(".*[aeiou].*");
    }
}
