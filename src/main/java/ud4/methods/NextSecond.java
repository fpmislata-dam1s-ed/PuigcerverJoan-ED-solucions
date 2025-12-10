package ud4.methods;

public class NextSecond {
    public static String nextSecond(int hours, int minutes, int seconds){
        seconds += 1;

        if (seconds >= 60){
            minutes += seconds / 60;
            seconds %= 60;
        }
        if (minutes >= 60){
            hours += minutes / 60;
            minutes %= 60;
        }
        hours %= 24;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
