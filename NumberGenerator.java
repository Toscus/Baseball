import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class NumberGenerator {
    private NumberGenerator() {}

    private static final Random random = new Random();

    /**
     * This function generates a random number of numberOfDigits number of digits without repeating any digits. It utilizes the removeElt function
     * to remove an element from the array "list" so that no two digits are the same within the number.
     * @param numberOfDigits this is the number of digits the number will have.
     * @return integer array of the final number
     */
    public static int[] randNumber(int numberOfDigits){

        if (numberOfDigits > 10) {
            numberOfDigits = 10;
        }

        int[] number =  new int[numberOfDigits];
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        for (int i = 0; i < numberOfDigits; i++){
            int position = random.nextInt(list.size());

            number[i]= list.remove(position);
        }

        return number;
    }
}
