import java.util.Date;

public class Product {
    String product_name;
    float price;
    int product_quantity;
    float weight;
    Date product_expire_date = new Date();

    public Product(String productName, float price, int quantity,float weight, Date expireDate) {
        this.product_name = productName;
        this.price = price;
        this.product_quantity = quantity;
        this.weight = weight;
        this.product_expire_date = expireDate;
    }

    // Overloaded constructor with default value
    public Product(String productName, float price, int quantity,float weight) {
        this(productName, price, quantity,weight, null);
    }

    //Getter
    public String getProduct_name() { return product_name; }
    public float getPrice() { return price; }
    public int getQuantity() {return product_quantity;}
    public Date getExpire_date() {return product_expire_date;}
    public float getWeight() {return weight;}

    //Setter
    public void setProduct_name(String name) {this.product_name = name;}
    public void setPrice(float price) {this.price = price;}
    public void setQuantity(int quantity) {this.product_quantity = quantity;}
    public void setExpire_date(Date date) {this.product_expire_date = date;}
    public void setWeight(float weight) {this.weight = weight;}

    //print all details
    void printAll(){
        System.out.println("Product Name is:\n"+product_name);
        System.out.println("Product Price is:\n"+price);
        System.out.println("Product quantity is:\n"+product_quantity);
        System.out.println("Product Expire data is:\n"+product_expire_date);
    }

    public void reduceQuantity(int amount) {
        this.product_quantity -= amount;
    }



}
