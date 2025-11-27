package ud4.methods;

public class Collatz {
    public static int f(int n){
        if (n % 2 == 0)
            return n / 2;
        else
            return 3*n + 1;
    }

    public static int collatz(int n){
        if (n <= 0)
            return -1;

        int steps = 0;
        while (n != 1) {
            n = f(n);
            steps++;
        }
        return steps;
    }
}
