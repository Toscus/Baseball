/** Baseball is played by trying to guess a three digit number.
 * Each digit is unique within the number. The digits must be guessed in the correct order.
 * A whiff is when the guesser hasn't guessed a single digit within the 3 digit number.
 * A ball is when the guesser has guessed a digit, but it's in the wrong position.
 * A strike is when the guesser has guessed a digit correctly, and it's in the right position.
 * Therefore a guess can result in a whiff, a ball, a strike, a strike and a ball, a strike and 2 balls, and so on.
 */
public class Baseball {

    public static void main(String[] args) {
        //TODO implement a separate window pop up so this isn't all done in the console? Could also have the guesses and results of those guesses as a list for reference for the player.

    	int digits = 3;
        int wins = 0;
        boolean playAgain = true;

        while(playAgain){
            digits = askForDigits();
            int[] number = NumberGenerator.randNumber(digits);

//			  for (int i:number){ System.out.print(i); }

            System.out.println();
            int strikes = 0;
            int tries = 0;
            while(strikes != digits){
                int[] attempt = guess(digits);
                strikes = evaluateGuess(attempt, number);
                tries++;
            }
            System.out.println("Congratulations! You have won! It took you " + tries + " guess(es)!");
            playAgain = false;
            playAgain = askPlayAgain();
            wins++;
        }
        System.out.println("Thanks for playing! You won " + wins + " time(s)!");
    }
    /**
     * To ask for guess
     * @param digits previous guess
     * @return current guess
     */
    public static int[] guess(int digits){

        String g = CS160Input.readString("What is your guess? \n");
        String[] numberStr = g.split("");
        int[] numbers = new int[numberStr.length];

        for (int i = 0; i < numberStr.length; i++){
            numbers[i] = Integer.parseInt(numberStr[i]);
        }

        while(digits != numbers.length){
            g = CS160Input.readString("What is your guess? It must be " + digits + " digits long as that is what you choose upon initialization. ");
            numberStr = g.split("");
            numbers = new int[numberStr.length];
        }
        for (int i = 0; i < numberStr.length; i++){
            numbers[i] = Integer.parseInt(numberStr[i]);
        }

        return numbers;
    }
    /**
     * To compare the player's guess versus the generated answer
     * @param g is an integer array containing the digits of the player's guess
     * @param a is an integer array containing the answer digits
     * @return the number of strikes in the current guess
     */
    public static int evaluateGuess(int[] g, int[] a){
        int[] record = new int[a.length];

        for(int i = 0; i < a.length; i++){
            if(g[i] == a[i]){
                record[i] = 2;
                //System.out.println("record " + i + " is a strike.");
            }

        }
        int balls = 0;
        int strikes = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length; j++){
                if(g[i] == a[j] && record[i] == 2){
                    record[i] = 2;
                    //System.out.println("Digit " + (i+1) + " is a strike!");
                    strikes++;
                    break;
                } else if (g[i] == a[j]){
                    record[i] = 1;
                    //System.out.println("Digit " + (i+1) + " is a ball!");
                    balls++;
                    break;
                }
            }
        }

        if (balls == 0 && strikes == 0) {
        	System.out.println("That was a whiff!");
        } else if (strikes == a.length){

        } else {
        	System.out.println("That is " + balls + " balls and " + strikes + " strikes!");
        }
        return strikes;
    }
    /**
     * Asks the user how many digits to play with
     * @return the number of digits the user specifies
     */
    public static int askForDigits(){
        int digits = CS160Input.readInt("How many digits would you like to play with? Standard is 3 and difficulty increases with more digits: ");
        while (digits > 9 || digits < 3) {
        	digits = CS160Input.readInt("Please select between 3 and 9 digits: ");
        }
        return digits;
    }
    /**
     *
     * @return
     */
    public static boolean askPlayAgain(){
        boolean play = false;
        boolean fin = true;
        String again = CS160Input.readString("Would you like to play another round? (Yes/No)");
        do {
	        if (again.equalsIgnoreCase("yes") || again.equalsIgnoreCase("y") || again.equalsIgnoreCase("ye")){
	            play = true;
	            fin = false;
	        } else if (again.equalsIgnoreCase("no") || again.equalsIgnoreCase("n")){
	            play = false;
	            fin = false;
	        } else {
	        	again = CS160Input.readString("Please type a valid response: ");
	        }
        } while (fin);
        return play;
    }
}
