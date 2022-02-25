import java.io.*;
/*
 * FileInput.java
 *
 * Created on October 28, 2004, 3:08 PM
 */

/**
 *
 * @author  bengelha
 */
public class CS160FileInput
{
    private FileReader fread = null;
    private BufferedReader file = null;
    private String nextLine = null, errorInfo = null, futureErrorInfo = null;
    private boolean endOfFile = false, error = false, fileOpen = false, futureError = false;
    /** Creates a new instance of FileInput
     * @param fileName name of the file
     */
    public CS160FileInput(String fileName)
    {
        try
        {
            fread = new FileReader (fileName);
            file = new BufferedReader (fread);
            endOfFile = false;
            error = false;
            fileOpen = true;
            futureError = false;
        }
        catch (IOException e)
        {
            error = true;
            endOfFile = true;
            fileOpen = false;
            futureError = true;
            errorInfo = "The file could not be found.";
        }
        if (!error)
        {
            try
            {
                nextLine = file.readLine();
                if (nextLine == null)
                {
                    endOfFile = true;
                    file.close();
                    fileOpen = false;
                }
            }
            catch (Exception e)
            {
                futureError = true;
                futureErrorInfo = "There was an error reading this file.";
            }
        }
    }

   /******************************************************
   * Returns true if fileName exists, other returns false
   ******************************************************/
   public static boolean fileExists (String fileName)
   {
      return (new File(fileName)).exists();
   }



    /**
     * reads one line and returns it, reads the next line and checks for end of file.
     * capable of setting endOfFile, fileOpen, Error, and FutureError markers
     * @return String the next line
     */
    private String readLine()
    {
        String line = null;
        if (!futureError)
            line = nextLine;
        else
        {
            error = true;
            errorInfo = futureErrorInfo;
        }
        if (fileOpen && !error)
        {
            try
            {
                nextLine = file.readLine();
                if (nextLine == null)
                {
                    endOfFile = true;
                    file.close();
                    fileOpen = false;
                }
            }
            catch (Exception e)
            {
                futureError = true;
                futureErrorInfo = "There was an error reading this file.";
            }
        }
        else nextLine = null;
        return line;
    }
    public String readString()
    {
        return readLine();
    }
    public char readChar()
    {
        return readLine().charAt(0);
    }
    public boolean readBoolean()
    {
        char one = readLine().charAt(0);
        if ((one == 'Y' || one == 'y')||(one == 'T' || one == 't'))
            return true;
        else if ((one == 'N' || one == 'n')||(one == 'F' || one == 'f'))
            return false;
        else
        {
            error = true;
            errorInfo = "The entered character was not Y,N,T, or F.";
            return false;
        }
    }
    public byte readByte()
    {
        if (endOfFile)
            return 0;
        byte output = 0;
        try
        {
            output = Byte.parseByte(readLine());
            error = false;
        }
        catch (Exception e)
        {
            error = true;
            errorInfo = "The line could not be converted into a byte.";
        }
        return output;
    }
    public short readShort()
    {
        if (endOfFile)
            return 0;
        short output = 0;
        try
        {
            output = Short.parseShort(readLine());
            error = false;
        }
        catch (Exception e)
        {
            error = true;
            errorInfo = "The line could not be converted into a short.";
        }
        return output;
    }
    public int readInt()
    {
        if (endOfFile)
            return 0;
        int output = 0;
        try
        {
            output = Integer.parseInt(readLine());
            error = false;
        }
        catch (Exception e)
        {
            error = true;
            errorInfo = "The line could not be converted into an integer.";
        }
        return output;
    }
    public long readLong()
    {
        if (endOfFile)
            return 0;
        long output = 0;
        try
        {
            output = Long.parseLong(readLine());
            error = false;
        }
        catch (Exception e)
        {
            error = true;
            errorInfo = "The line could not be converted into a long.";
        }
        return output;
    }
    public float readFloat()
    {
        if (endOfFile)
            return 0;
        float output = 0;
        try
        {
            output = Float.parseFloat(readLine());
            error = false;
        }
        catch (Exception e)
        {
            error = true;
            errorInfo = "The line could not be converted into a float.";
        }
        return output;
    }
    public double readDouble()
    {
        if (endOfFile)
            return 0;
        double output = 0;
        try
        {
            output = Double.parseDouble(readLine());
            error = false;
        }
        catch (Exception e)
        {
            error = true;
            errorInfo = "The line could not be converted into a byte.";
        }
        return output;
    }
    public boolean eof()
    {
        return endOfFile;
    }
    public boolean exception()
    {
        return error;
    }
    public String getInfo()
    {
        return errorInfo;
    }

   public void close()
   {
      try
      {
         file.close();
         error = false;
         errorInfo = "";
      }
      catch (Exception e)
      {
         errorInfo = "Unable to close file";
         error = true;
      }
   }

}
