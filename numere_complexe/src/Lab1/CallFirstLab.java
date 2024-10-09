package Lab1;

import Lab1.complexop.ComplexExpression;
import Lab1.expparser.ExpressionParser;

import java.util.Scanner;

public class CallFirstLab {

    public static void run() {
        String input = "-2--3*i / -1+2*i";  // Sample input
        String input1 = "4+6*i + 2+2*i + -2+3*i";  // Sample input

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a complex expression:");
        String textInput = scanner.nextLine();  // Get user input
        ExpressionParser exprParser = new ExpressionParser(textInput);  // Parse the input
        try {
            ComplexExpression exp = exprParser.getComplexExpression();  // Create complex expression object
            System.out.println(exp.execute());  // Execute the expression and print the result
        } catch (Exception e) {
            System.out.println(e);  // Print exception if any error occurs
        }
    }
}
