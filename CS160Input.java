import java.io.*;

public class CS160Input
{

   private static String myReadLine() throws Exception
   {
      BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));

      String originalText = inData.readLine();
      return originalText.trim();
   }


   /*********************************************************
   * Returns a boolean value based upon the text entered by
   * the user.  The entered text must be followed by a
   * carriage return.  There may be white space before and/or
   * after the entered text.  If the entered text starts with
   * a t(rue) or y(es) the returned value will be true.  If
   * the entered text starts with f(alse) or n(o) the
   * returned value will be false.  If any other leading
   * character is entered the user will prompted to reenter
   * the text.  Any characters entered after the initial
   * character will be ignored.
   ********************************************************/
   public static boolean readBoolean()
   {
      String originalText = "";
      boolean dataValid = false, result = true;

      do
      {
         dataValid = true;

         originalText = readString();
         originalText = originalText.toUpperCase().substring(1, 2);

         if ((originalText.equals ("Y") ) || (originalText.equals("T") ))
            result = true;
         else if ((originalText.equals ("N") ) || (originalText.equals("F") ))
            result = false;
         else
            dataValid = false;

      } while (!dataValid);
      return result;

   }


   /*********************************************************
   * Displays a prompt and then returns a boolean value based
   * upon the text entered by the user.  The entered text
   * must be followed by a carriage return.  There may be
   * white space before and/or after the entered text.  If
   * the entered text starts with a t(rue) or y(es) the
   * returned value will be true.  If the entered text starts
   * with f(alse) or n(o) the returned value will be false.
   * If any other leading character is entered the user will
   * prompted to reenter the text.  Any characters entered
   * after the initial character will be ignored.
   ********************************************************/
   public static boolean readBoolean(String prompt)
   {
      System.out.print(prompt);
      return readBoolean();
   }


   /*********************************************************
   * Returns a char entered by the user.  The entered character
   * must be followed by a carriage return.  Any white space
   * before and/or after the character will be retained.
   ********************************************************/
   public static char readChar()
   {
      String originalText = "";
      originalText = readString();
      while (originalText.length() == 0)
      {
         System.out.println ("Please enter at least one character followed by a carriage return");
         originalText = readString();
      }
      return originalText.charAt(0);
   }


   /*********************************************************
   * Displays a prompt and then returns a character entered by
   * the user.  The entered character must be followed by a
   * carriage return.  Any white space before and/or after
   * the text will be retained.
   ********************************************************/
   public static char readChar(String prompt)
   {
      System.out.print(prompt);
      return readChar();
   }


   /*********************************************************
   * Returns a char entered by the user.  The entered character
   * must be followed by a carriage return.  Any white space
   * before and/or after the character will be removed.
   ********************************************************/
   public static char readCharNoWS()
   {
      String originalText = "";
      originalText = readString();
      originalText = originalText.trim();
      while (originalText.length() == 0)
      {
         System.out.println ("Please enter at least one character followed by a carriage return");
         originalText = readString();
         originalText = originalText.trim();
      }
      return originalText.charAt(0);
   }


   /*********************************************************
   * Displays a prompt and then returns a character entered by
   * the user.  The entered character must be followed by a
   * carriage return.  Any white space before and/or after
   * the text will be removed.
   ********************************************************/
   public static char readCharNoWS(String prompt)
   {
      System.out.print(prompt);
      return readCharNoWS();
   }


   /*********************************************************
   * Returns a String entered by the user.  The entered text
   * must be followed by a carriage return.  Any white space
   * before and/or after the text will be retained.
   ********************************************************/
   public static String readString()
   {
      String originalText = "";
      boolean dataValid;

      do
      {
         try
         {
            originalText = myReadLine();
            dataValid = true;
         }

         catch(Exception e)
         {
            System.out.println ("Invalid characters for a String; please re-enter");
            dataValid = false;
         }
      } while (!dataValid);

      return originalText;
   }


   /*********************************************************
   * Displays a prompt and then returns a String entered by
   * the user.  The entered text must be followed by a
   * carriage return.  Any white space before and/or after
   * the text will be retained.
   ********************************************************/
   public static String readString(String prompt)
   {
      System.out.print(prompt);
      return readString();
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
      String originalText = "";
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
            System.out.println ("Invalid characters for an int; please re-enter");
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
      System.out.print(prompt);
      return readInt();
   }

   /*********************************************************
   * Returns a byte value from the text entered by the
   * user.  The entered text must be followed by a carriage
   * return.  There may be white space before and/or after
   * the number.  Any extra text entered after the number is
   * ignored.  If the number is not entered correctly or a
   * blank line is entered the user will be asked to reenter
   * the input.
   ********************************************************/
   public static byte readByte()
   {
      boolean dataValid;
      byte tempByte = 0;

      do
      {
         try
         {
            tempByte = Byte.parseByte(myReadLine());
            dataValid = true;
         }
         catch(Exception e)
         {
            System.out.println ("Invalid characters for a byte value; please re-enter");
            dataValid = false;
         }
      } while (!dataValid);
      return tempByte;
   }

   /*********************************************************
   * Displays a prompt and then returns a byte value from
   * the text entered by the user.  The entered text must be
   * followed by a carriage return.  There may be white space
   * before and/or after the number.  Any extra text entered
   * after the number is ignored.  If the number is not
   * entered correctly or a blank line is entered the user
   * will be asked to reenter the input.
   ********************************************************/
   public static int readByte(String prompt)
   {
      System.out.print(prompt);
      return readByte();
   }

   /*********************************************************
   * Returns a short value from the text entered by the
   * user.  The entered text must be followed by a carriage
   * return.  There may be white space before and/or after
   * the number.  Any extra text entered after the number is
   * ignored.  If the number is not entered correctly or a
   * blank line is entered the user will be asked to reenter
   * the input.
   ********************************************************/
   public static short readShort()
   {
      short tempShort = 0;
      boolean dataValid;

      do
      {
         try
         {
            tempShort = Short.parseShort(myReadLine());
            dataValid = true;
         }

         catch(Exception e)
         {
            System.out.println ("Invalid characters for a short value; please re-enter");
            dataValid = false;
         }
      } while (!dataValid);
      return tempShort;
   }


   /*********************************************************
   * Displays a prompt and then returns a short value from
   * the text entered by the user.  The entered text must be
   * followed by a carriage return.  There may be white space
   * before and/or after the number.  Any extra text entered
   * after the number is ignored.  If the number is not
   * entered correctly or a blank line is entered the user
   * will be asked to reenter the input.
   ********************************************************/
   public static short readShort(String prompt)
   {
      System.out.print(prompt);
      return readShort();
   }

   /*********************************************************
   * Returns a long value from the text entered by the
   * user.  The entered text must be followed by a carriage
   * return.  There may be white space before and/or after
   * the number.  Any extra text entered after the number is
   * ignored.  If the number is not entered correctly or a
   * blank line is entered the user will be asked to reenter
   * the input.
   ********************************************************/
   public static long readLong()
   {
      long tempLong = 0;
      boolean dataValid;

      do
      {
         try
         {
            tempLong = Long.parseLong(myReadLine());
            dataValid = true;
         }

         catch(Exception e)
         {
            System.out.println ("Invalid characters for a long value; please re-enter");
            dataValid = false;
         }
      } while (!dataValid);

      return tempLong;
   }


   /*********************************************************
   * Displays a prompt and then returns a long value from
   * the text entered by the user.  The entered text must be
   * followed by a carriage return.  There may be white space
   * before and/or after the number.  Any extra text entered
   * after the number is ignored.  If the number is not
   * entered correctly or a blank line is entered the user
   * will be asked to reenter the input.
   ********************************************************/
   public static long readLong(String prompt)
   {
      System.out.print(prompt);
      return readLong();
   }

   /*********************************************************
   * Returns a double value from the text entered by the
   * user.  The entered text must be followed by a carriage
   * return.  There may be white space before and/or after
   * the number.  The double value may or may not have a
   * single decimal point.  The double value may also be
   * entered in exponential notation.  Any extra text entered
   * after the number is ignored.  If the number is not
   * entered correctly or a blank line is entered the user
   * will be asked to reenter the input.
   ********************************************************/
   public static double readDouble()
   {
      double tempDouble = 0;
      boolean dataValid;

      do
      {
         try
         {
            tempDouble = Double.parseDouble(myReadLine());
            dataValid = true;
         }

         catch(Exception e)
         {
            System.out.println ("Invalid characters for a double value; please re-enter");
            dataValid = false;
         }
      } while (!dataValid);

      return tempDouble;
   }

   /*********************************************************
   * Displays a prompt and then returns a double value from
   * the text entered by the user.  The entered text must be
   * followed by a carriage return.  There may be white space
   * before and/or after the number.  The double value may or
   * may not have a single decimal point.  The double value
   * may also be entered in exponential notation.  Any extra
   * text entered after the number is ignored.  If the number
   * is not entered correctly or a blank line is entered the
   * user will be asked to reenter the input.
   ********************************************************/
   public static double readDouble(String prompt)
   {
      System.out.print(prompt);
      return readDouble();
   }

   /*********************************************************
   * Returns a float value from the text entered by the
   * user.  The entered text must be followed by a carriage
   * return.  There may be white space before and/or after
   * the number.  The float value may or may not have a
   * single decimal point.  The float value may also be
   * entered in exponential notation.  Any extra text entered
   * after the number is ignored.  If the number is not
   * entered correctly or a blank line is entered the user
   * will be asked to reenter the input.
   ********************************************************/
   public static float readFloat()
   {
      float tempFloat = 0;
      boolean dataValid;

      do
      {
         dataValid = true;
         try
         {
            tempFloat = Float.parseFloat(myReadLine());
         }

         catch(Exception e)
         {
            dataValid = false;
            System.out.println ("Invalid characters for a float value; please re-enter");
         }
      } while (!dataValid);

      return tempFloat;
   }

   /*********************************************************
   * Displays a prompt and then returns a float value from
   * the text entered by the user.  The entered text must be
   * followed by a carriage return.  There may be white space
   * before and/or after the number.  The float value may or
   * may not have a single decimal point.  The float value
   * may also be entered in exponential notation.  Any extra
   * text entered after the number is ignored.  If the number
   * is not entered correctly or a blank line is entered the
   * user will be asked to reenter the input.
   ********************************************************/
   public static float readFloat (String prompt)
   {
      System.out.print(prompt);
      return readFloat();
   }


}
