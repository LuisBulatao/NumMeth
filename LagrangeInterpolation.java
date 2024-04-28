import java.text.DecimalFormat;
import java.util.*;
public class LagrangeInterpolation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean stopper = false;
        do {

            System.out.println("Select what Method you want to use ");
            System.out.println("1. First Order Interpolation ");
            System.out.println("2. Second Order Interpolation ");
            System.out.println("3  Nth-Order Interpolation ");
            System.out.println("4. Name of the programmer ");

            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You choose the Lagrange First Order Interpolation");
                    LagrangeFirstOrderInterpolation();
                    break;
                case 2:
                    System.out.println("You choose the Lagrange Second Order Interpolation");
                    SecondOrderInterpolatin();
                    break;
                case 3:
                    System.out.println("You choose the Lagrange Nth-Order Interpolation");
                    NthOrderInterpolatin();
                    break;
                case 4:
                    System.out.println("Programmed By: Luis Joshua D. Bulatai " +
                                       "2BSCS-1");
                    stopper = true;
            }
        }
        while (!stopper);
        scanner.close();
    }
    public static void LagrangeFirstOrderInterpolation() {
        DecimalFormat df = new DecimalFormat("#.####");

        Scanner scan = new Scanner(System.in);
        // Input data points
        System.out.println("\nEnter data points");

        System.out.print("Enter x0: ");
        double x0point = scan.nextDouble();
        System.out.print("Enter y0: ");
        double y0point = scan.nextDouble();
        System.out.print("Enter x1: ");
        double x1point = scan.nextDouble();
        System.out.print("Enter y1: ");
        double y1point = scan.nextDouble();

        System.out.println("x0 " + (int) x0point + " x1 " + (int) x1point +
                "\ny0 " + (int) y0point + " y1 " + (int) y1point);

        // Point for interpolation
        System.out.print("Enter the value of x for interpolation: ");
        double theGivenX = scan.nextDouble();

        // Lagrange First Order Interpolation formula
        double FiristOrderFormula = y0point + ((theGivenX - x0point) * (y1point - y0point)) / (x1point - x0point);

        //Output
        System.out.println("Interpolated value at theGivenX =  " + "f" + "(" + (int)theGivenX + ")" + " = " + df.format(FiristOrderFormula));
    }


    public static void SecondOrderInterpolatin() {
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.####");


        System.out.println("\nEnter data points");
        System.out.print("Enter x0: ");
        double x0point = scan.nextDouble();
        System.out.print("Enter y0: ");
        double y0point = scan.nextDouble();
        System.out.print("Enter x1: ");
        double x1point = scan.nextDouble();
        System.out.print("Enter y1: ");
        double y1point = scan.nextDouble();
        System.out.print("Enter x2: ");
        double x2point = scan.nextDouble();
        System.out.print("Enter y2: ");
        double y2point = scan.nextDouble();


        System.out.println("x0 " + (int) x0point + " x1 " + (int) x1point + " x2 " + (int) x2point +
                "\ny0 " + (int) y0point + " y1 " + (int) y1point + " y2 " + (int) y2point);

        // Point for interpolation
        System.out.print("Enter the value of x for interpolation: ");
        double theGivenX = scan.nextDouble();

        // Lagrange Second Order Interpolation formula
        double SecondOrderFormula = ((theGivenX - x1point) * (theGivenX - x2point)) / ((x0point - x1point) * (x0point - x2point)) * y0point +
                                    ((theGivenX - x0point) * (theGivenX - x2point)) / ((x1point - x0point) * (x1point - x2point)) * y1point +
                                    ((theGivenX - x0point) * (theGivenX - x1point)) / ((x2point - x0point) * (x2point - x1point)) * y2point;

        System.out.println("Interpolated value at theGivenX =  " + "f" + "(" + (int)theGivenX + ")" + " = " + df.format(SecondOrderFormula));
    }

    public static void NthOrderInterpolatin() {
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.####");

        System.out.print("\nEnter data points: ");
        double dataPoint = scan.nextInt();


        double[] xdataPointValues = new double[(int) dataPoint];
        for (int i = 0; i < dataPoint; i++) {
            System.out.print("Enter x" + i + " ");
            xdataPointValues[i] = scan.nextDouble();
        }

        double[] ydataPointValues = new double[(int) dataPoint];
        for (int i = 0; i < dataPoint; i++) {
            System.out.print("Enter y" + i + " ");
            ydataPointValues[i] = scan.nextDouble();
        }

        // Print entered data points
        System.out.print("Entered data points:");
        for (int i = 0; i < dataPoint; i++) {
            System.out.println(" (" + (int)xdataPointValues[i] + ", " + (int)ydataPointValues[i] + ")");
        }


        // Point for interpolation
        System.out.print("Enter the value of x for interpolation: ");
        double theGivenX = scan.nextDouble();

        // Lagrange Nth-Order Interpolation formula
        double nthOrderFormulaResult = 0;
        for (int i = 0; i < xdataPointValues.length; i++) {
            double EnteredDataPoint = ydataPointValues[i];
            for (int j = 0; j < xdataPointValues.length; j++) {
                if (j != i) {
                    EnteredDataPoint *= (theGivenX - xdataPointValues[j]) / (xdataPointValues[i] - xdataPointValues[j]);
                }
            }
            nthOrderFormulaResult += EnteredDataPoint;
        }
        System.out.println("Interpolated value at theGivenX =  " + "f" + "(" + (int)theGivenX + ")" + " = " + df.format(nthOrderFormulaResult));
    }
}