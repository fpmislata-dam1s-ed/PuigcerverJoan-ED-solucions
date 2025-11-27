package exam1;

public class ContainsVowel {
    public static boolean containsVowel(String str) {
        return str.toLowerCase().matches(".*[aeiou].*");
    }
}
