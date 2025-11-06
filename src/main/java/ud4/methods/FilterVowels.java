package ud4.methods;

public class FilterVowels {
    public static String filterVowels(String string){
        return string.replaceAll("[aeiouAEIOUáàÁÀ]", "");
    }
}
