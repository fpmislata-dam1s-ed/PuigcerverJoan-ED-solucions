package ud4.methods;

public class FilterVowels {
    public static String filterVowels(String string){
        String filteredString = string.replaceAll("[aeiou]", "");

        return filteredString;
    }
}
