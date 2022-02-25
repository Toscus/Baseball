import java.io.*;
import javax.swing.*;

public class CS160FileUtils
{

   /******************************************************
   * Returns true if fileName exists, other returns false
   ******************************************************/
   public static boolean fileExists (String fileName)
   {
      return (new File(fileName)).exists();
   }

   /******************************************************
   * Displays a dialog control that allows the user to
   * select a file.
   *
   * If a file is selected the filename, including the
   * entire path, is returned. null will be returned if the
   * user selects cancel.
   ******************************************************/
   public static String getOpenFileName()
   {
      JFileChooser fc = new JFileChooser(new File(".").getAbsolutePath());
      //JFileChooser fc = new JFileChooser();  //starts in My Docs

      int returnVal = fc.showOpenDialog(null);
      if (returnVal == JFileChooser.APPROVE_OPTION)
      {
         File file = fc.getSelectedFile();
         return file.getAbsolutePath();
      }
      else
         return null;
   }


   /******************************************************
   * Displays a dialog control that allows the user to
   * select a file.
   *
   * If a file is selected the filename, including the
   * entire path, is returned. null will be returned if the
   * user selects cancel.
   ******************************************************/
   public static String getSaveFileName()
   {
      JFileChooser fc = new JFileChooser(new File(".").getAbsolutePath());
      //JFileChooser fc = new JFileChooser();

      int returnVal = fc.showSaveDialog(null);
      if (returnVal == JFileChooser.APPROVE_OPTION)
      {
         File file = fc.getSelectedFile();
         return file.getAbsolutePath();
      }
      else
         return null;
   }

   /******************************************************
   * Displays a dialog control that allows the user to
   * select a file. The user must enter the name of a file
   * that does not currently exist or confirm that they wish
   * to overwrite an existing file.
   *
   * If a file is selected the filename, including the
   * entire path if returned. null will be returned if the
   * user selects cancel.
   ******************************************************/
   public static String getNewSaveFileName()
   {
      JFileChooser fc = new JFileChooser(new File(".").getAbsolutePath());
      //JFileChooser fc = new JFileChooser();
      boolean foundFile = false;
      do
      {
         int returnVal = fc.showSaveDialog(null);
         if (returnVal == JFileChooser.APPROVE_OPTION)
         {
            File file = fc.getSelectedFile();
            if (file.exists ())
            {
               int response = JOptionPane.showConfirmDialog (null,
                  "Overwrite existing file?","Confirm Overwrite",
                  JOptionPane.OK_CANCEL_OPTION,
                  JOptionPane.QUESTION_MESSAGE);
               if (response != JOptionPane.CANCEL_OPTION)
                  return file.getAbsolutePath();
                    }
                    else
               return file.getAbsolutePath();
         }
         else
            return null;
          } while (true);
   }


}
