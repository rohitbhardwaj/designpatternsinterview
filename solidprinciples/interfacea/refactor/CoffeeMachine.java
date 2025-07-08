package solidprinciples.interfacea.refactor;


/**
 * CoffeeMachine class implementing only BasicMachine.
 */
public class CoffeeMachine implements BasicMachine {
    @Override
    public void start() {
        System.out.println("Coffee machine starting...");
    }

    @Override
    public void stop() {
        System.out.println("Coffee machine stopping...");
    }
}
