import java.util.Arrays;
import java.util.HashMap;

public class Translator {

    private HashMap<Integer, String> numMap = new HashMap<>();

    public Translator(int[] numbers, String[] numAsStrings) {
        for (int i = 0; i < numbers.length; i++) {
            this.numMap.put(numbers[i], numAsStrings[i]);
        }
    }

    public HashMap<Integer, String> getNumMap() {
        return numMap;
    }

//    public void setNumMap(HashMap<Integer, String> numMap) {
//        this.numMap = numMap;
//    }

    public String translate(int number) {
        return getNumMap().get(number);
    }
}
