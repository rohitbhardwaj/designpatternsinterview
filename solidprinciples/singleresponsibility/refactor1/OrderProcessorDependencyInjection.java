package solidprinciples.singleresponsibility.refactor1;

public class OrderProcessorDependencyInjection {
  private final OrderValidator validator;
  private final OrderRepository repository;
  private final CustomerNotifier notifier;

  public OrderProcessorDependencyInjection(OrderValidator validator, OrderRepository repository,
      CustomerNotifier notifier) {
    this.validator = validator;
    this.repository = repository;
    this.notifier = notifier;
  }

  public void processOrder(Order order) {
    validator.validate(order);
    repository.save(order);
    notifier.notify(order);
  }

  /*
   * Approach 3: Modularize Large Methods
   * Break down long methods into smaller, focused methods.
   * 
   * Before Refactoring:
   */
  public void generateInvoice(Order order) {
    // Calculate totals
    // Apply discounts
    // Format invoice
    // Save invoice to database
  }

  public void generateInvoiceModularize(Order order) {
    double total = calculateTotals(order);
    double discountedTotal = applyDiscounts(total);
    String formattedInvoice = formatInvoice(order, discountedTotal);
    saveInvoiceToDatabase(formattedInvoice);
  }

  private void saveInvoiceToDatabase(String formattedInvoice) {
  }

  private String formatInvoice(Order order, double discountedTotal) {
    return null;
  }

  private double applyDiscounts(double total) {
    return 0;
  }

  private double calculateTotals(Order order) {
    return 0;
  }

}
