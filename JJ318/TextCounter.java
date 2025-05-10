/*Christian dave gesim*/
/*Activity 2*/

import java.util.Scanner;

public class TextCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vowels = 0, consonants = 0;
        System.out.println("Please enter a text: ");

        String text = scanner.nextLine().toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            if (letter >= 'a' && letter <= 'z') {
                if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.printf("The number of vowels in (%s) is: %d%n", text, vowels);
        System.out.printf("The number of consonants in (%s) is: %d%n", text, consonants);
    }
}
