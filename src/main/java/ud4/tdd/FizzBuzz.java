package ud4.tdd;

public class FizzBuzz {
    public String transform(int n){
        StringBuilder result = new StringBuilder();
        if(n % 3 == 0) result.append("Fizz");
        if(n % 5 == 0) result.append("Buzz");
        if(n % 7 == 0) result.append("Tozz");
        if(result.isEmpty()) return Integer.toString(n);
        return result.toString();
    }
}
