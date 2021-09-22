import java.io.File; //file class
import java.io.IOException; //handles errors
import java.io.FileWriter; //file writing
import java.util.Scanner; //to read files
import java.io.FileNotFoundException; //handles errors
import javax.swing.JOptionPane; //fancy GUI

class Main {
  public static void main(String[] args) {
    //variables
    double b;
    double a;
    double c;
    double x1;
    double x2;
    int repeat = 0;
    //creating save file if it doesn't exist
    try
    {
      File myResults = new File("savedresults.txt");
      if (myResults.createNewFile())
      {
        System.out.println("Created save file: " + myResults.getName());
      }
      else
      {
        System.out.println("Save file already exists");
      }
    }
    catch (IOException e)
    {
      System.out.println("An error occured ):");
      e.printStackTrace();
    }

    try
    {
      FileWriter myWriter = new FileWriter("savedresults.txt", true);//appends instead of overwrite
      myWriter.write("\nNew Session");//saves to next line
      myWriter.close();
      System.out.println("Successfully saved to file.");
    }
    catch (IOException e)
    {
      System.out.println("An error occured ):");
      e.printStackTrace();
    }

    //explain what calculator does
    JOptionPane.showMessageDialog(null, "Quadratic Formula", "Calculator", JOptionPane.INFORMATION_MESSAGE);

    //loops as long as repeat is equal to 0
    while (repeat == 0)
    {
      //ask user for values of a, b, and c
      a = Double.parseDouble(JOptionPane.showInputDialog("What is the value of a?"));
      b = Double.parseDouble(JOptionPane.showInputDialog("What is the value of b?"));
      c = Double.parseDouble(JOptionPane.showInputDialog("What is the value of c?"));

      //if the result is less than 0 it'll have no solution
      if ((Math.pow(b,2) - 4 * a * c) < 0)
      {
        //tells user result
        JOptionPane.showMessageDialog(null, "No solution", "Solution", JOptionPane.INFORMATION_MESSAGE);
        try
        {
          FileWriter myWriter = new FileWriter("savedresults.txt", true);//appends instead of overwrite
          myWriter.write("\nNo solution: " + "a=" + a + " b=" + b + " c=" + c);//saves to next line
          myWriter.close();
          System.out.println("Successfully saved result to file.");
        }
        catch (IOException e)
        {
          System.out.println("An error occured ):");
          e.printStackTrace();
        }
        //asks user if they want to repeat
        repeat = JOptionPane.showConfirmDialog(null,"Repeat?","Repetition", JOptionPane.YES_NO_OPTION);
        //if they select anything but "yes", program will break from loops
        if (repeat != 0)
        {
          break;
        }
      }

      //else if the result is 0 it'll have one solution
      else if ((Math.pow(b,2) - 4 * a * c) == 0)
      {
        //rounds answer to four decimals
        x1 = (Math.round((-b+Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a)*10000.0)/10000.0);
        //tells user result
        JOptionPane.showMessageDialog(null, "One solution\n" + x1, "Solution", JOptionPane.INFORMATION_MESSAGE);
        try
        {
          FileWriter myWriter = new FileWriter("savedresults.txt", true);//appends instead of overwrite
          myWriter.write("\nOne solution: " + "a=" + a + " b=" + b + " c=" + c + " x=" + x1);//saves to next line
          myWriter.close();
          System.out.println("Successfully saved result to file.");
        }
        catch (IOException e)
        {
          System.out.println("An error occured ):");
          e.printStackTrace();
        }
        //asks user if they want to repeat
        repeat = JOptionPane.showConfirmDialog(null,"Repeat?","Repetition", JOptionPane.YES_NO_OPTION);
        //if they select anything but "yes", program will break from loops
        if (repeat != 0)
        {
        break;
        }
      }

      //else will run for two solutions
      else
      {
        //rounds answer to four decimals
        x1 = (Math.round((-b+Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a)*10000.0)/10000.0);
        x2 = (Math.round((-b-Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a)*10000.0)/10000.0);
        //tells user result
        JOptionPane.showMessageDialog(null, "Two solutions\n" + x1 + "\n" + x2, "Solution", JOptionPane.INFORMATION_MESSAGE);
        try
        {
          FileWriter myWriter = new FileWriter("savedresults.txt", true);//appends instead of overwrite
          myWriter.write("\nTwo solutions: " + "a=" + a + " b=" + b + " c=" + c + " x=" + x1 + " x=" + x2);//saves to next line
          myWriter.close();
          System.out.println("Successfully saved result to file.");
        }
        catch (IOException e)
        {
          System.out.println("An error occured ):");
          e.printStackTrace();
        }
        //asks user if they want to repeat
        repeat = JOptionPane.showConfirmDialog(null,"Repeat?","Repetition", JOptionPane.YES_NO_OPTION);
        //if they select anything but "yes", program will break from loops
        if (repeat != 0)
          {
            break;
          }
        }
      }
      //program exits with code 0
      System.exit(0);   
  }
}