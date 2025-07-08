package solidprinciples.singleresponsibility.refactor1;

import java.util.List;
import java.time.LocalDate;

public class Order {
    private int orderId;
    private LocalDate orderDate;
    private String customerName;
    private List<OrderItem> items;
    private String status; // e.g., "Pending", "Shipped", "Delivered"
    private double totalAmount;

    // Constructor
    public Order(int orderId, LocalDate orderDate, String customerName, List<OrderItem> items, String status) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.items = items;
        this.status = status;
        this.totalAmount = calculateTotalAmount();
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
        this.totalAmount = calculateTotalAmount(); // Recalculate total when items change
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    // Calculate the total amount of the order
    private double calculateTotalAmount() {
        return 0;
        /*
         * items.stream()
         * .mapToDouble(item -> item.getPrice() * item.getQuantity())
         * .sum();
         */
    }

    // Optional toString method for debugging
    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", customerName='" + customerName + '\'' +
                ", items=" + items +
                ", status='" + status + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
