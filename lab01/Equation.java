package lab01;
import javax.swing.JOptionPane;
public class Equation {
    public static void firstDegreeEquation() {
        double a, b, result;
        
        do {
            String str1 = JOptionPane.showInputDialog(null,
                    "Please input a (a != 0):", "Input equation ax + b = 0", JOptionPane.INFORMATION_MESSAGE);
            a = Double.parseDouble(str1);

            if (a == 0) {
                JOptionPane.showMessageDialog(null, "Invalid input. 'a' cannot be 0. Please try again.");
            }
        } while (a == 0);

        String str2 = JOptionPane.showInputDialog(null,
                "Please input b:", "Input equation ax + b = 0", JOptionPane.INFORMATION_MESSAGE);
        b = Double.parseDouble(str2);

        result = -b / a;
        JOptionPane.showMessageDialog(null, "Solution: x = " + result,
                "Solve equation ax + b = 0", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void systemFirstDegreeEquation() {
        double[] a = new double[2];
        double[] b = new double[2];
        double[] c = new double[2];

        for (int i = 0; i < 2; i++) {
            String str1 = JOptionPane.showInputDialog(null,
                    "Please input a" + (i + 1) + ":", "Input equation a" + (i + 1) + "x + b" + (i + 1) + "y = c" + (i + 1),
                    JOptionPane.INFORMATION_MESSAGE);
            a[i] = Double.parseDouble(str1);

            String str2 = JOptionPane.showInputDialog(null,
                    "Please input b" + (i + 1) + ":", "Input equation a" + (i + 1) + "x + b" + (i + 1) + "y = c" + (i + 1),
                    JOptionPane.INFORMATION_MESSAGE);
            b[i] = Double.parseDouble(str2);

            String str3 = JOptionPane.showInputDialog(null,
                    "Please input c" + (i + 1) + ":", "Input equation a" + (i + 1) + "x + b" + (i + 1) + "y = c" + (i + 1),
                    JOptionPane.INFORMATION_MESSAGE);
            c[i] = Double.parseDouble(str3);
        }

        double D = a[0] * b[1] - a[1] * b[0];
        double Dx = c[0] * b[1] - c[1] * b[0];
        double Dy = a[0] * c[1] - a[1] * c[0];

        if (D != 0) {
            double x = Dx / D;
            double y = Dy / D;
            JOptionPane.showMessageDialog(null, "Solution: (" + x + ", " + y + ").",
                    "Solve system of first-degree equations", JOptionPane.INFORMATION_MESSAGE);
        } else if (Dx == 0 && Dy == 0) {
            JOptionPane.showMessageDialog(null, "The system has infinitely many solutions.",
                    "Solve system of first-degree equations", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "The system has no solution.",
                    "Solve system of first-degree equations", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void secondDegreeEquation() {
        double a, b, c;

        do {
            String str1 = JOptionPane.showInputDialog(null,
                    "Please input a (a != 0):", "Input equation ax^2 + bx + c = 0", JOptionPane.INFORMATION_MESSAGE);
            a = Double.parseDouble(str1);

            if (a == 0) {
                JOptionPane.showMessageDialog(null, "'a' cannot be 0. Please try again.");
            }
        } while (a == 0);

        String str2 = JOptionPane.showInputDialog(null,
                "Please input b:", "Input equation ax^2 + bx + c = 0", JOptionPane.INFORMATION_MESSAGE);
        b = Double.parseDouble(str2);

        String str3 = JOptionPane.showInputDialog(null,
                "Please input c:", "Input equation ax^2 + bx + c = 0", JOptionPane.INFORMATION_MESSAGE);
        c = Double.parseDouble(str3);

        double delta = b * b - 4 * a * c;
        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            JOptionPane.showMessageDialog(null, "Solution: x1 = " + x1 + ", x2 = " + x2,
                    "Solve equation ax^2 + bx + c = 0", JOptionPane.INFORMATION_MESSAGE);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            JOptionPane.showMessageDialog(null, "Solution: x1 = x2 = " + x,
                    "Solve equation ax^2 + bx + c = 0", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "The equation has no solution.",
                    "Solve equation ax^2 + bx + c = 0", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        String option;

        do {
            option = JOptionPane.showInputDialog(null,
                    "Please select a program: \n"
                            + "1. Solve the first-degree equation with one variable\n"
                            + "2. Solve the system of first-degree equations with two variables\n"
                            + "3. Solve the second-degree equation with one variable\n"
                            + "4. Exit\n",
                    "Equation Solver", JOptionPane.INFORMATION_MESSAGE);

            switch (option) {
                case "1":
                    firstDegreeEquation();
                    break;
                case "2":
                    systemFirstDegreeEquation();
                    break;
                case "3":
                    secondDegreeEquation();
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, "Program terminated.");
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option! Please try again.");
            }
        } while (true);
    }
}
