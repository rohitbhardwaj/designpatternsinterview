package solidprinciples.interfacea;
 

/**
 * A CoffeeMachine class implementing Machine interface.
 */
public class CoffeeMachine implements Machine {
    @Override
    public void start() {
        System.out.println("Coffee machine starting...");
    }

    @Override
    public void stop() {
        System.out.println("Coffee machine stopping...");
    }

    @Override
    public void print(String document) {
        // Coffee machines cannot print documents, leading to an unnecessary implementation
        throw new UnsupportedOperationException("Coffee machine cannot print documents.");
    } 

/**
 * Why It Violates ISP
Unnecessary Methods:
The CoffeeMachine class is forced to implement the print method, which is irrelevant to its functionality.
Fragile Code:
Adding or modifying printing-specific methods in the Machine interface affects all implementing classes, even if they don’t need them.
*/

}
