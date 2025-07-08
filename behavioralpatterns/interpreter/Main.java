package behavioralpatterns.interpreter;

public class Main {
    public static void main(String[] args) {
        // Construct the expression tree for: 5 + 3 - 2
        Expression five = new NumberExpression(5);
        Expression three = new NumberExpression(3);
        Expression two = new NumberExpression(2);

        // 5 + 3
        Expression addition = new AddExpression(five, three);

        // (5 + 3) - 2
        Expression subtraction = new SubtractExpression(addition, two);

        // Interpret the final expression
        int result = subtraction.interpret();

        System.out.println("Result of the expression (5 + 3 - 2): " + result);
    }
}