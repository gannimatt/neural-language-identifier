import java.util.Arrays;

public class TextProcessing {
    public static double[] textToVector(String text) {
        double[] vector = new double[128];
        text = text.toLowerCase();
        int totalValidChars = 0;

        for (char c : text.toCharArray()) {
            if (c >= 0 && c < 128 && c != ' ') {
                vector[c]++;
                totalValidChars++;
            }
        }
//        int total = text.length();
        for (int i = 0; i < vector.length; i++) {
            vector[i] /= totalValidChars;
        }
        return vector;
    }
}

