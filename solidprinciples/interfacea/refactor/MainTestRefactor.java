package solidprinciples.interfacea.refactor;

public class MainTestRefactor {
    public static void main(String[] args) {
        // Using a printer
        Printer printer = new Printer();
        printer.start();
        printer.print("ISP Design Document");
        printer.stop();

        // Using a coffee machine
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.start();
        coffeeMachine.stop();

        // Notice: No unnecessary methods implemented or used
    }
}
