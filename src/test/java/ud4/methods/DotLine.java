package ud4.methods;

public class DotLine {
    public static String dotLine(int length) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < length; i++) {
            line.append(".");
        }
        return line.toString();
    }
}
