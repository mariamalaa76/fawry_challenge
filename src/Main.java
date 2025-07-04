import java.util.Calendar;
import java.util.Date;
public class Main {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2028, Calendar.DECEMBER, 1);  // Month is 0-based
        Date expireDate = calendar.getTime();
        Product milk = new Product("Milk", 10, 5,15,expireDate);
        Product tv = new Product("TV", 6000, 2,5000);

        Cart cart = new Cart();

        cart.addProduct(milk, 3);
        cart.addProduct(tv, 1);

        cart.showCart();
    }
}