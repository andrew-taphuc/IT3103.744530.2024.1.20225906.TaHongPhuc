package lab01;
import javax.swing.JOptionPane;
public class Calculate {
    public static void main(String[] args) {
        String strNum1, strNum2;
        strNum1 = JOptionPane.showInputDialog(null, "Enter first number:");
        strNum2 = JOptionPane.showInputDialog(null, "Enter second number:");

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        while (num2 == 0) {
            strNum2 = JOptionPane.showInputDialog(null,
            "Second number must not equal 0, renter second number:");
            num2 = Double.parseDouble(strNum2);
        }
        double sumNum = num1 + num2;
        double subNum = Math.abs(num1 - num2);
        double product = num1 * num2;
        double div = num1 / num2;

        JOptionPane.showMessageDialog(null,
        "From 2 entered number, this is the result:\nSum: "+sumNum+"\nDifference: "+subNum+"\nProduct: "+product+"\nQuotient: "+div);
    }
}



