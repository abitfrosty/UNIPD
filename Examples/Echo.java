import javax.swing.JOptionPane;

public class Echo
{
  public static void main(String[] args)
  {
    String s = JOptionPane.showInputDialog("Input your text below");
    JOptionPane.showMessageDialog(null, s);
    System.out.println(s);
    System.exit(0);
  }
}
