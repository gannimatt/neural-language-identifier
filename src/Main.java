import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Set<String> languages = new HashSet<>(Arrays.asList("en", "tr", "pl"));
        NeuralNetwork network = new NeuralNetwork(languages);
        List<TrainingData> trainingData = new ArrayList<>();

        for (String language : languages) {
            File dir = new File("data/" + language);
            for (File file : Objects.requireNonNull(dir.listFiles())) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append(" ");
                }
                trainingData.add(new TrainingData(content.toString(), language));
                reader.close();
            }
        }

        network.train(trainingData, 1000, 0.01);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter text for language detection (or 'exit' to quit): ");
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) break;
            System.out.println("Detected Language: " + network.predict(input));

        }
        scanner.close();
    }
}

class TrainingData {
    String text;
    String language;

    TrainingData(String text, String language) {
        this.text = text;
        this.language = language;
    }
}
