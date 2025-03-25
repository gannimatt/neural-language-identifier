# Multilingual Text Language Detector (Java)

## Overview

This Java project implements a simple neural network to detect the **language** of a given text input using **character frequency analysis**. It supports English (`en`), Turkish (`tr`), and Polish (`pl`) and is trained using labeled text files. It includes:

- A feedforward neural network with one output neuron per language
- Preprocessing of text to normalize characters to ASCII
- Command-line interface for training and prediction

## Features

- Detects language from user-input text
- Supports training with labeled datasets
- Character frequency-based input vectorization
- Normalization of non-ASCII characters (e.g., `ğ`, `ł`, `ż`) for better consistency

## Project Structure

- `Main.java`: Loads data, trains the network, and interacts with the user
- `NeuralNetwork.java`: Neural model with training and prediction logic
- `Neuron.java`: Represents individual neurons
- `TextProcessing.java`: Converts input text to ASCII-based vector
- `testing/toascii.java`: Utility to normalize text with non-ASCII characters and save output

## Dataset Format

The `data/` directory contains **three subdirectories**: one for each language. Inside each of these folders are **multiple text files**, each containing text in the respective language:

```
data/
  ├── en/
  │   ├── en1.txt
  │   ├── en2.txt
  │   └── ...
  ├── tr/
  │   ├── tr1.txt
  │   ├── tr2.txt
  │   └── ...
  └── pl/
      ├── pl1.txt
      ├── pl2.txt
      └── ...
```

Each file contains a sample of text written in the corresponding language. These are used as training data for the neural network to learn the language patterns.

## How to Run

1. **Prepare the dataset** as shown above in the `data/` folder.

2. **Compile the project:**
   ```bash
   javac Main.java NeuralNetwork.java Neuron.java TextProcessing.java
   ```

3. **Run the application:**
   ```bash
   java Main
   ```

4. **Follow the prompt to input text** for language detection:
   ```
   Enter text for language detection (or 'exit' to quit):
   this is a sample sentence
   Detected Language: en
   ```

## Text Normalization (Optional)

To preprocess text with non-ASCII characters:

```bash
javac src/testing/toascii.java
java testing.toascii
```

It will output an ASCII-normalized version of the text to `src/testing/to_ascii_test.txt`.

## License

This project is licensed under the [MIT License](LICENSE).

## Contributing

Contributions are welcome! Feel free to fork this repository and submit pull requests for new languages, features, or optimizations.
