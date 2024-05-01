import java.util.*;

public class AntiDifferencing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of x: ");
        double valueOfX = scanner.nextDouble();

        // Loop through values of m from 0 to 20
        for (int m = 0; m <= 20; m++) {
            double result = antiDifferencing(valueOfX, m);
            System.out.println("Anti-difference of x^(-" + m + "): " + result);
        }
        scanner.close();
    }
    // Anti-Differencing Formula
    public static double antiDifferencing(double x, int m) {
        return Math.pow(x, -(m + 1)) / -(m + 1);
    }
}