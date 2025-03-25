package testing;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;

public class toascii {
    private static final Map<Character, Character> TURKISH_ASCII_MAP = createMap();

    private static Map<Character, Character> createMap() {
        Map<Character, Character> map = new HashMap<>();
        map.put('ğ', 'g');
        map.put('ü', 'u');
        map.put('ş', 's');
        map.put('ı', 'i');
        map.put('ö', 'o');
        map.put('ç', 'c');
        map.put('ą', 'a');
        map.put('ć', 'c');
        map.put('ę', 'e');
        map.put('ł', 'l');
        map.put('ń', 'n');
        map.put('ó', 'o');
        map.put('ś', 's');
        map.put('ź', 'z');
        map.put('ż', 'z');
        return map;
    }

    public static String convertToAscii(String text) {
        StringBuilder sb = new StringBuilder();
        text = text.toLowerCase();
        for (char c : text.toCharArray()) {
            sb.append(TURKISH_ASCII_MAP.getOrDefault(c, c));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the text:");
        String text = scanner.nextLine();

        String asciiText = convertToAscii(text);

        try (FileWriter writer = new FileWriter("src\\testing\\to_ascii_test.txt")) {
            writer.write(asciiText);
            System.out.println("The text has been written");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        scanner.close();
    }
}
