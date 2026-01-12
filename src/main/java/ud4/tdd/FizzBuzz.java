package ud4.tdd;

public class FizzBuzz {
    public String transform(int n){
        if (n % 15 == 0) return "FizzBuzz";
        if (n % 3 == 0) return "Fizz";
        if (n % 5 == 0) return "Buzz";
        return Integer.toString(n);
    }

    public String transform2(int n) {
        StringBuilder result = new StringBuilder();
        if (n % 3 == 0) result.append("Fizz");
        if (n % 5 == 0) result.append("Buzz");
        if (n % 7 == 0) result.append("Tozz");
        if (result.isEmpty()) result.append(n);
        return result.toString();
    }
}