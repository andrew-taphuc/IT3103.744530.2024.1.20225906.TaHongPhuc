package lab01;
//Example 3
import javax.swing.JOptionPane;
public class HelloNameDialog{
    public static void main(String[] args) {
        String result;
        result = JOptionPane.showInputDialog("Please enter your name:");
        JOptionPane.showMessageDialog(null, 
        "Hi, my name is Hong Phuc.\n" + result + " , nice to meet you!");
        System.exit(0);
    }
}

