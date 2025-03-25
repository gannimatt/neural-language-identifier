import java.util.*;

public class NeuralNetwork {
    private Neuron[] neurons;
    private Map<String, Integer> languageIndex;

    public NeuralNetwork(Set<String> languages) {
        languageIndex = new HashMap<>();
        int index = 0;
        for (String lang : languages) {
            languageIndex.put(lang, index++);
        }
        neurons = new Neuron[languages.size()];
        for (int i = 0; i < neurons.length; i++) {
            neurons[i] = new Neuron(128); // ASCII
        }
    }

    public void train(List<TrainingData> trainingData, int epochs, double learningRate) {
        for (int e = 0; e < epochs; e++) {
            Collections.shuffle(trainingData);
            for (TrainingData data : trainingData) {
                double[] inputs = TextProcessing.textToVector(data.text);
                int actualLanguageIndex = languageIndex.get(data.language);
                double[] outputs = new double[neurons.length];
                for (int i = 0; i < outputs.length; i++) {
                    outputs[i] = neurons[i].computeOutput(inputs);
                }

                for (int i = 0; i < neurons.length; i++) {
                    double error = (i == actualLanguageIndex ? 1 : 0) - outputs[i];
                    neurons[i].updateWeights(inputs, learningRate, error); //delta rule
                }
            }
        }
    }

    private int findMaxIndex(double[] outputs) {
        int index = 0;
        double max = outputs[0];
        for (int i = 1; i < outputs.length; i++) {
            if (outputs[i] > max) {
                max = outputs[i];
                index = i;
            }
        }
        return index;
    }

    public String predict(String text) {
        double[] inputs = TextProcessing.textToVector(text);
        double[] outputs = new double[neurons.length];
        for (int i = 0; i < outputs.length; i++) {
            outputs[i] = neurons[i].computeOutput(inputs); //compute outputs from each neuron
        }
        int predictedIndex = findMaxIndex(outputs);
        for (Map.Entry<String, Integer> entry : languageIndex.entrySet()) {
            if (entry.getValue() == predictedIndex) {
                return entry.getKey();
            }
        }
        return null;
    }
}
