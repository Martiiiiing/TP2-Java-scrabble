import java.util.Arrays;
import java.util.Scanner;

public class ScrabbleConsole {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Welcome to the Scrabble assistant");
        Dictionary dictionary = new Dictionary("fr_FR_utf8.dico");
        System.out.println(dictionary.size+ " words loaded");
        System.out.println("Please enter a word:");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        System.out.println(dictionary.isValidWord(word));
        System.out.println("Please enter a letter list:");
        char[] letters = new char[7];
        for (int i = 0; i < 7; i++) {
            letters[i] = sc.next().charAt(0);
        }
        System.out.println(letters);
        if (dictionary.mayBeComposed(word, letters)) {
            System.out.println(word+ " may be composed with letters: "+ Arrays.toString(letters));
        } else {
            System.out.println(word+ " may be composed with letters: "+ Arrays.toString(letters));
        }
    }

    
}
