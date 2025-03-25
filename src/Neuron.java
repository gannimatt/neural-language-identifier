public class Neuron {
    private double[] weights;

    public Neuron(int inputSize) {
        weights = new double[inputSize];
        for (int i = 0; i < inputSize; i++) {
            weights[i] = Math.random(); //random weights
        }
    }


    public double computeOutput(double[] inputs) {
        double net = 0;
        for (int i = 0; i < weights.length; i++) {
            net += weights[i] * inputs[i]; //dot product
        }
        return net;
    }

    public void updateWeights(double[] inputs, double learningRate, double error) {
        for (int i = 0; i < weights.length; i++) {
            weights[i] += learningRate * error * inputs[i]; //delta rule
        }
        normalizeWeights();
    }

    private void normalizeWeights() {
        double norm = 0; //Euclidean norm
        for (double w : weights) {
            norm += w * w;
        }
        norm = Math.sqrt(norm);
        for (int i = 0; i < weights.length; i++) {
            weights[i] /= norm;
        }
    }
}
