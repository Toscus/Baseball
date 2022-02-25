import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Baseball2 {
	static int strikes = 0;
	static int balls = 0;
    static int tries = 0;
    static JTextArea ta = new JTextArea();
    static JTextField tf = new JTextField(10); // accepts up to 10 characters
    
	public static void main(String args[]){
		int digits = 3;
        int wins = 0;
        boolean playAgain = true;
        
		
		JFrame frame = new JFrame("Baseball");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(600, 600);
	    
	    JMenuBar mb = new JMenuBar();
	    JPanel panel = new JPanel(); // the panel is not visible in output
	    JLabel label = new JLabel("Enter Text");
	    JButton send = new JButton("Send");
	    JButton reset = new JButton("Reset");
	    panel.add(label); // Components Added using Flow Layout
	    panel.add(tf);
	    panel.add(send);
	    panel.add(reset);
	    
	    DefaultTableModel MyTablemodel = new DefaultTableModel();
	
	    MyTablemodel.addColumn("Guess");
	    MyTablemodel.addColumn("Strikes");
	    MyTablemodel.addColumn("Balls");
	    // Text Area at the Center
	    
	    JTable hist = new JTable(MyTablemodel);
	    JScrollPane MyScrollPane= new JScrollPane(hist);
	    ta.setEditable(false);
	    TableColumnModel columnModel = hist.getColumnModel();
	    columnModel.getColumn(0).setPreferredWidth(80);
	    columnModel.getColumn(0).setMaxWidth(80);
	    columnModel.getColumn(1).setPreferredWidth(50);
	    columnModel.getColumn(1).setMaxWidth(50);
	    columnModel.getColumn(2).setPreferredWidth(50);
	    columnModel.getColumn(2).setMaxWidth(50);
	    
	    final String newline = "\n";
	    //String content = "";
	
	    //Adding Components to the frame.
	    frame.getContentPane().add(BorderLayout.SOUTH, panel);
	    frame.getContentPane().add(BorderLayout.NORTH, mb);
	    frame.getContentPane().add(BorderLayout.CENTER, ta);
	    //frame.getContentPane().add(BorderLayout.EAST, hist);
	    frame.getContentPane().add(BorderLayout.EAST, MyScrollPane);
	    MyScrollPane.setPreferredSize(new Dimension(180,600));
	    frame.setVisible(true);
	    
	    send.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent ae) {
	    		String getValue = tf.getText();
	    		ta.append(getValue + newline);
	    		MyTablemodel.addRow(new Object[]{getValue, strikes, balls});
	    		//hist.append(getValue + newline);
	    		//content = content + getValue;
	    	}
	    });
	    
	    tf.addActionListener(new ActionListener() {
	    	 public void actionPerformed(ActionEvent e){
	    		String getValue = tf.getText();
	     		ta.append(getValue + newline);
	     		MyTablemodel.addRow(new Object[]{getValue, "Column 2", "Column 3"});
	    	 }
	    });
        
        while(playAgain){
            digits = askForDigits();
            ta.append("How many digits would you like to play with? Standard is 3 and difficulty increases with more digits: ");
            int[] number = randNumber(digits);
			
//			  for (int i:number){ System.out.print(i); }
			 
            System.out.println();
            strikes = 0;
            tries = 0;
            while(strikes != digits){
                int[] attempt = guess(digits);
                strikes = evaluateGuess(attempt, number);
                tries++;
            }
            ta.append("Congratulations! You have won! It took you " + tries + " guess(es)!");
            ta.append("Congratulations! You have won! It took you " + tries + " guess(es)!" + newline);
            playAgain = false;
            playAgain = askPlayAgain();
            wins++;
        }
        ta.append("Thanks for playing! You won " + wins + " time(s)!");
    }
    /**
     * This function generates a random number of x number of digits without repeating any digits. It utilizes the removeElt function
     * to remove an element from the array "list" so that no two digits are the same within the number.
     * @param x this is the number of digits the number will have.
     * @return integer array of the final number
     */
    public static int[] randNumber(int x){
        int[] number =  new int[x];
        int[] list = {0,0,1,2,3,4,5,6,7,8,9};
        int position;
        for (int i = 0; i < x; i++){
            position = (int)(Math.random()*(10-i)+1);
            if(position < 0){
                position = 0;
            }
            number[i]= list[position];
            //ta.append(i);
            removeSelectedNum(list, position);
        }
        
        return number; 
    }
    
    /**
     * This function removes the digit that randNumber selected for each position so that a number can not be randomly selected more than once.
     * @param arr List of digits to be overwritten
     * @param remIndex Position within the array "list" that is to be overwritten.
     * @return The shortened array of digits
     */
    public static int[] removeSelectedNum( int [] arr, int remIndex )
    {
       for ( int i = remIndex ; i < arr.length - 1 ; i++ )
       {
          arr[ i ] = arr[ i + 1 ] ; 
       }
       return arr;
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
                //ta.append("record " + i + " is a strike.");
            }
            
        }
        balls = 0;
        strikes = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length; j++){
                if(g[i] == a[j] && record[i] == 2){
                    record[i] = 2;
                    //ta.append("Digit " + (i+1) + " is a strike!");
                    strikes++;
                    break;
                } else if (g[i] == a[j]){
                    record[i] = 1;
                    //ta.append("Digit " + (i+1) + " is a ball!");
                    balls++;
                    break;
                }
            }
        }
        
        if (balls == 0 && strikes == 0) {
        	ta.append("That was a whiff!");
        } else if (strikes == a.length){
        	
        } else {
        	ta.append("That is " + balls + " balls and " + strikes + " strikes!");
        }
        return strikes;
    }
    /**
     * Asks the user how many digits to play with
     * @return the number of digits the user specifies
     */
    public static int askForDigits(){
        int digits = readInt("How many digits would you like to play with? Standard is 3 and difficulty increases with more digits: ");
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
    
    private static String myReadLine() throws Exception
    {
       String originalText = tf.getText();
       return originalText.trim();
    }
    /*********************************************************
     * Returns an integer value from the text entered by the
     * user.  The entered text must be followed by a carriage
     * return.  There may be white space before and/or after
     * the number.  Any extra text entered after the number is
     * ignored.  If the number is not entered correctly or a
     * blank line is entered the user will be asked to reenter
     * the input.
     ********************************************************/
     public static int readInt()
     {
        int tempInt = 0;
        boolean dataValid;

        do
        {
           try
           {
              tempInt = Integer.parseInt(myReadLine());
              dataValid = true;
           }

           catch(Exception e)
           {
              ta.append ("Invalid characters for an int; please re-enter");
              dataValid = false;
           }
        } while (!dataValid);

        return tempInt;
     }

     /*********************************************************
     * Displays a prompt and then returns an integer value from
     * the text entered by the user.  The entered text must be
     * followed by a carriage return.  There may be white space
     * before and/or after the number.  Any extra text entered
     * after the number is ignored.  If the number is not
     * entered correctly or a blank line is entered the user
     * will be asked to reenter the input.
     ********************************************************/
     public static int readInt(String prompt)
     {
        ta.append(prompt);
        return readInt();
     }
}
