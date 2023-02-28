import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Hier mag je je code scrijven voor de hoofd-opdracht
        int[] numbers =  {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,};
        String[] numAsStrings = {"nul", "een", "twee", "drie", "vier", "vijf" , "zest", "zeven", "acht", "negen"};
        Translator translator = new Translator(numbers, numAsStrings);

        Scanner scanner = new Scanner(System.in);
        boolean gameOn = true;

        while (gameOn) {
            System.out.print("Enter a number between 0-9: ");
            try {
                int num = scanner.nextInt();
                scanner.nextLine();
                if(num <= 9 && num >= 0) {
                    System.out.println("The number is: " + translator.translate(num));
                } else {
                    System.out.println("Not a number between 0-9. Try again");
                }
            } catch (Exception e) {
                System.out.println("Not a number. Ending game.......");
                gameOn = false;
            }
        }


        /* deze regel mag je weg halen voor de bonus opdracht. Onderstaande code is voor de bonus opdracht.
        HashSet<Integer> secretnumber = randomnumbergenerator();
        String stringnumber =  setToStringConverter(secretnumber);
        System.out.println(stringnumber);
        feedback();
         deze regel mag je weg halen voor de bonus opdracht */

    }

    /*
     Deze methode is voor de bonus opdracht.
     */
    public static void feedback(String stringnumber) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder feedback = new StringBuilder();
        System.out.println("take a guess");
        String guess = scanner.nextLine();
        if (Objects.equals(guess, stringnumber)) {
            System.out.println("gefeliciteerd je hebt het goed");
        } else {
            for (int i = 0; i < 4; i++) {
                if (guess.substring(i, i + 1).equals(stringnumber.substring(i, i + 1))) {
                    feedback.append("+");
                } else if (stringnumber.contains(guess.substring(i, i + 1))) {
                    feedback.append("0");
                } else {
                    feedback.append("X");
                }
            }
        }
        System.out.println(feedback.toString());
    }
}
