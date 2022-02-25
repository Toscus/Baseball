import java.io.*;

public class CS160FileOutput
{
   private PrintWriter outputStream = null;
   private String message = "";
   private boolean currentStatus = true;

   @SuppressWarnings("unused")
private CS160FileOutput()
   {
      try
      {
         outputStream = new PrintWriter(System.out);
         currentStatus = true;
      }
      catch (Exception e)
      {
         message = e.getMessage();
         currentStatus = false;
      }
   }

   /******************************************************
   * Creates an output file.  Requires an argument of a
   * filename.  The filename may include a path.  If the
   * file currently exists it will be overwritten.  If
   * the file doesn't currently exist it will be created.
   *
   * If a valid filehandle is returned statusOK will return
   * true, otherwise statusOK will return false.
   ******************************************************/
   public CS160FileOutput(String fileName)
   {
      try
      {
         outputStream = new PrintWriter(new FileOutputStream(fileName));
         currentStatus = true;
      }
      catch (Exception e)
      {
         message = e.getMessage();
         currentStatus = false;
      }
   }

   private void displayMessage()
   {
      System.out.println (message);
   }


   /******************************************************
   * Returns true if the previous call of CS160FileOutput, close,
   * print or println finished correctly.  Returns false if the
   * call to any of those methods failed.  the getMessage()
   * method will provide more details regarding the problem.
   ******************************************************/
   public boolean statusOK()
   {
      return currentStatus;
   }


   /******************************************************
   * Returns a brief message describing the error condition
   * if the previous call of CS160FileOutput, close,
   * print or println failed.  Returns an empty string if
   * the call to any of those methods finished correctly.
   ******************************************************/
   public String getMessage()
   {
      return message;
   }


   /******************************************************
   * Closes the file refered to by the calling object.  If the
   * file closes properly the statusOK method returns true,
   * otherwise the statusOK method returns false.
   ******************************************************/
   public void close()
   {
      outputStream.close();
   }

   /* Prints a String */
   public void print   (String inValue)  {outputStream.print (inValue);}
   /* Prints a String and then terminates the line */
   public void println (String inValue)  {outputStream.println (inValue);}

   /* Prints a byte value */
   public void print   (byte inValue)    {outputStream.print (inValue);}
   /* Prints a byte value and then terminates the line */
   public void println (byte inValue)    {outputStream.println (inValue);}

   /* Prints a short value */
   public void print   (short inValue)   {outputStream.print (inValue);}
   /* Prints a short value and then terminates the line */
   public void println (short inValue)   {outputStream.println (inValue);}

   /* Prints an int value*/
   public void print   (int inValue)     {outputStream.print (inValue);}
   /* Prints an int value and then terminates the line */
   public void println (int inValue)     {outputStream.println (inValue);}

   /* Prints a long value */
   public void print   (long inValue)    {outputStream.print (inValue);}
   /* Prints a long value and then terminates the line */
   public void println (long inValue)    {outputStream.println (inValue);}

   /* Prints a boolean value */
   public void print   (boolean inValue) {outputStream.print (inValue);}
   /* Prints a boolean value and then terminates the line */
   public void println (boolean inValue) {outputStream.println (inValue);}

   /* Prints a char value */
   public void print   (char inValue)    {outputStream.print (inValue);}
   /* Prints a char value and then terminates the line */
   public void println (char inValue)    {outputStream.println (inValue);}

   /* Prints a float value */
   public void print   (float inValue)   {outputStream.print (inValue);}
   /* Prints a float value and then terminates the line */
   public void println (float inValue)   {outputStream.println (inValue);}

   /* Prints a double value */
   public void print   (double inValue)  {outputStream.print (inValue);}
   /* Prints a double value and then terminates the line */
   public void println (double inValue)  {outputStream.println (inValue);}

}