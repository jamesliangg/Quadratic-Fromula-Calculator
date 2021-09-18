import javax.swing.JOptionPane;

class Main
{
    public static void main(String[] args)
    {
        double b;
        double a;
        double c;
        double x1;
        double x2;
        int repeat = 0;

        JOptionPane.showMessageDialog(null, "Quadratic Formula", "Calculator", JOptionPane.INFORMATION_MESSAGE);

        while (repeat == 0)
        {
            a = Double.parseDouble(JOptionPane.showInputDialog("What is the value of a?"));
            b = Double.parseDouble(JOptionPane.showInputDialog("What is the value of b?"));
            c = Double.parseDouble(JOptionPane.showInputDialog("What is the value of c?"));

            if ((Math.pow(b,2) - 4 * a * c) < 0)
            {
                JOptionPane.showMessageDialog(null, "No answer", "Solution", JOptionPane.INFORMATION_MESSAGE);
                repeat = JOptionPane.showConfirmDialog(null,"Repeat?","Repetition", JOptionPane.YES_NO_OPTION);
                if (repeat != 0)
                {
                    break;
                }
            }

            else if ((Math.pow(b,2) - 4 * a * c) == 0)
            {
                x1 = (Math.round((-b+Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a)*10000.0)/1000.0);
                JOptionPane.showMessageDialog(null, "One solution\n" + x1, "Solution", JOptionPane.INFORMATION_MESSAGE);
                repeat = JOptionPane.showConfirmDialog(null,"Repeat?","Repetition", JOptionPane.YES_NO_OPTION);
                if (repeat != 0)
                {
                    break;
                }
            }

            else
            {
                x1 = (Math.round((-b+Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a)*10000.0)/1000.0);
                x2 = (Math.round((-b-Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a)*10000.0)/1000.0);
                JOptionPane.showMessageDialog(null, "Two solutions\n" + x1 + "\n" + x2, "Solution", JOptionPane.INFORMATION_MESSAGE);
                repeat = JOptionPane.showConfirmDialog(null,"Repeat?","Repetition", JOptionPane.YES_NO_OPTION);
                if (repeat != 0)
                {
                    break;
                }
            }
        }
        System.exit(0);
    }
}
