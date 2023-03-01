import java.util.*;

public class Main {

    // Returns a HashSet of four random numbers: 0-9
    public static HashSet<Integer> randomnumbergenerator() {
        HashSet<Integer> mySet = new HashSet<>();
        Random r = new Random();
        while(mySet.size() < 4) {
            mySet.add(r.nextInt(0, 10));
        }
        return mySet;
    }

    public static HashSet<Integer> randomnumbergenerator(int maxNum) {
        HashSet<Integer> mySet = new HashSet<>();
        Random r = new Random();
        while(mySet.size() < 4) {
            mySet.add(r.nextInt(0, maxNum));
        }
        return mySet;
    }


    public static String setToStringConverter(HashSet<Integer> sourceSet) {
        String targetString = "";
        HashSet<Integer> indexSet = randomnumbergenerator(sourceSet.size());
        Integer[] numsAsArray = sourceSet.toArray(new Integer[0]);
        for (int num: indexSet
             ) {
            targetString += (numsAsArray[num]);
        }
        return targetString;
    }

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
                System.out.println("Not a number. Moving on to Bonus.......");
                gameOn = false;
            }
        }

        // Bonus 1-4
        HashSet<Integer> secretnumber = randomnumbergenerator();
        String stringnumber =  setToStringConverter(secretnumber);
        System.out.println(stringnumber);
        feedback(stringnumber);


    }

    /*
     Deze methode is voor de bonus opdracht.
     */
    public static void feedback(String stringnumber) {
        boolean keepGuessing = true;
        while(keepGuessing) {
            Scanner scanner = new Scanner(System.in);
            StringBuilder feedback = new StringBuilder();
            System.out.println("take a guess");
            String guess = scanner.nextLine();
            if(guess.length() != 4) {
                System.out.println("Guess should contain 4 digits only. Try again");
                continue;
            }
            if (Objects.equals(guess, stringnumber)) {
                System.out.println("gefeliciteerd je hebt het goed");
                keepGuessing = false;
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
}
