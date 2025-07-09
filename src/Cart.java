import java.time.LocalDate;
import java.util.ArrayList;

public class Cart {
    private ArrayList<CartItem> items;
    private float shippingCost = 100;


    public Cart() {
        items = new ArrayList<>();
    }

    public boolean addProduct(Product product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Quantity must be at least 1.");
            return false;
        }

        if (quantity > product.getQuantity()) {
            System.out.println("Not enough stock for product: " + product.getProduct_name());
            return false;
        }

        items.add(new CartItem(product, quantity));
        product.reduceQuantity(quantity);
        System.out.println("Added " + quantity + " of " + product.getProduct_name()+ " to cart.");
        return true;
    }

    public boolean checkout(Customer customer, Product product,CartItem item) {
        if(items.size() == 0){
            System.out.println("Cart is empty\n");
            return false;
        }
        float subtotal = 0;
        for (CartItem i : items) {
            subtotal += item.getTotalPrice();
        }
        float totalAmount = subtotal + shippingCost;
        if (customer.getCurrent_balanced() < totalAmount) {
            System.out.println("Not enough balance to checkout.");
            return false;
        }
        return true;
    }

    public void showCart() {
        float totalWeight = 0;
        float subtotal = 0;

        System.out.println("** Shipment notice **");
        for (CartItem item : items) {
            String name = item.getProduct().getProduct_name();
            float weightPerItem = item.getProduct().getWeight() * 1000; // grams
            System.out.printf("%dx %s %.0fg\n", item.getQuantity(), name, weightPerItem);
            totalWeight += item.getTotalWeight();
        }
        System.out.printf("Total package weight %.1fkg\n", totalWeight);

        System.out.println("** Checkout receipt **");
        for (CartItem item : items) {
            System.out.printf("%dx %s %.0f\n", item.getQuantity(), item.getProduct().getProduct_name(), item.getTotalPrice());
            subtotal += item.getTotalPrice();
        }

        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f\n", subtotal);
        System.out.printf("Shipping %.0f\n", shippingCost);
        System.out.printf("Amount %.0f\n", subtotal + shippingCost);
    }
}
