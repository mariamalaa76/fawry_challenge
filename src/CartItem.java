public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }

    public float getTotalPrice() {
        return product.getPrice() * quantity;
    }

    public float getTotalWeight() {
        return product.getWeight() * quantity;
    }
}

