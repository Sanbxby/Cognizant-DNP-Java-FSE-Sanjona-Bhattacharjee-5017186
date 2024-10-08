/*Efficiency: They enable quick access, update, and management of large inventories, reducing time complexity.
Scalability: Proper data structures and algorithms handle growth efficiently, ensuring the system scales with inventory size.
Data Integrity: They help maintain consistent and accurate data, minimizing redundancy.

Suitable datastructres are HashMap,ArrayList*/




import java.util.ArrayList;
import java.util.List;

class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Inventory {
    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        for (Product p : products) {
            if (p.getProductId() == product.getProductId()) {
                System.out.println("Product already exists.");
                return;
            }
        }
        products.add(product);
        System.out.println("Product " + product.getProductName() + " added");
    }

    public void updateProduct(int productId, Integer quantity, Double price) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                if (quantity != null) {
                    product.setQuantity(quantity);
                }
                if (price != null) {
                    product.setPrice(price);
                }
                System.out.println("Product " + product.getProductName() + " updated");
                return;
            }
        }
        System.out.println("Product not found");
    }

    public void deleteProduct(int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                products.remove(product);
                System.out.println("Product deleted");
                return;
            }
        }
        System.out.println("Product not found");
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Product product1 = new Product(1, "Dress", 16, 1500);
        Product product2 = new Product(2, "Shoes", 22, 800);

        inventory.addProduct(product1);
        inventory.addProduct(product2);

        inventory.updateProduct(1, 15, null);
        inventory.deleteProduct(2);
    }
}




/*-Time Complexity Analysis
Add Product: O(n) in the worst case because it checks for duplicates by iterating through the entire list.
Update Product: O(n) because it may need to search through the entire list to find the product.
Delete Product: O(n) for the same reason as updating it must find the product in the list.

-Optimization Discussion
Hashmap will be the better choice for optimization of bigger data.*/
