import java.util.*;
public class NewtonsDifferentiation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean stopper = false;

        do {
            System.out.println("\nSelect what method you want to use: ");
            System.out.println("1. Forward Difference ");
            System.out.println("2. Backward Difference ");
            System.out.println("3. Central Difference ");
            System.out.println("4. Programmer Name ");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You Choose Forward Difference Method");
                    System.out.print("\nEnter the value of x: ");
                    double xF = scanner.nextDouble();

                    System.out.print("Enter the step size: ");
                    double stepSize = scanner.nextDouble();

                    // Call ForwardDifference method and output the result
                    double derivative_approx = ForwardDifference(xF, stepSize);
                    System.out.println("\nApproximate derivative at x = " + xF + " is: " + derivative_approx);
                    break;

                case 2:
                    System.out.println("You Choose Backward Difference Method");
                    System.out.print("\nEnter the value of x: ");
                    double xB = scanner.nextDouble();

                    System.out.print("Enter the step size: ");
                    stepSize = scanner.nextDouble();

                    // Call BackwardDifference method and output the result
                    derivative_approx = BackwardDifference(xB, stepSize);
                    System.out.println("\nApproximate derivative at x = " + xB + " is: " + derivative_approx);
                    break;

                case 3:
                    System.out.println("You Choose Central Difference Method");
                    System.out.print("\nEnter the value of x: ");
                    double xC = scanner.nextDouble();

                    System.out.print("Enter the step size: ");
                    stepSize = scanner.nextDouble();

                    // Call CentralDifference method and output the result
                    derivative_approx = CentralDifference(xC, stepSize);
                    System.out.println("\nApproximate derivative at x = " + xC + " is: " + derivative_approx);
                    break;

                case 4:
                    System.out.println("Programmed By: Luis Joshua D. Bulatao " +
                            "2BSCS-1");
                    stopper = true;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (!stopper);
        scanner.close();
    }

    private static double ForwardDifference(double x, double stepSize) {
        // Calculate f(x) = x^2 + 2x
        double f_x = x * x + 2 * x;
        System.out.println("\nf(x) = " + f_x);

        // Calculate f(x1 + 1 )
        double f_x_plus_h = (x + 1) * (x + 1) + 2 * (x + 1);
        System.out.println("f(xi + 1) = " + f_x_plus_h);

        // Calculate f(x1 - 1 )
        double f_x_minus_h = (x - 1) * (x - 1) + 2 * (x - 1);
        System.out.println("f(xi - 1) = " + f_x_minus_h);

        // Apply the forward difference formula
        return (f_x_plus_h - f_x) / stepSize;
    }

    private static double BackwardDifference(double x, double stepSize) {
        // Calculate f(x) = x^2 + 2x
        double f_x = x * x + 2 * x;
        System.out.println("\nf(x) = " + f_x);

        // Calculate f(x1 - 1 )
        double f_x_plus_h = (x - 1) * (x - 1) + 2 * (x - 1);
        System.out.println("f(xi + 1) = " + f_x_plus_h);

        // Calculate f(x1 - 1 )
        double f_x_minus_h = (x - 1) * (x - 1) + 2 * (x - 1);
        System.out.println("f(xi - 1) = " + f_x_minus_h);

        // Apply the forward difference formula
        return (f_x - f_x_minus_h) / stepSize;
    }

    private static double CentralDifference(double x, double stepSize) {
        // Calculate f(x) = x^2 + 2x
        double f_x = x * x + 2 * x;
        System.out.println("\nf(x) = " + f_x);

        // Calculate f(x1 + 1 )
        double f_x_plus_h = (x + 1) * (x + 1) + 2 * (x + 1);
        System.out.println("f(xi + 1) = " + f_x_plus_h);

        // Calculate f(x1 - 1 )
        double f_x_minus_h = (x - 1) * (x - 1) + 2 * (x - 1);
        System.out.println("f(xi - 1) = " + f_x_minus_h);

        // Apply the forward difference formula
        return (f_x_plus_h - f_x_minus_h) / (2 * stepSize);
    }
}


