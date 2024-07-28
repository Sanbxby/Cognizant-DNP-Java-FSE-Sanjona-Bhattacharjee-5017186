/*Understanding the problem
-Big O Notation:

Describes the upper bound of an algorithm's time or space complexity in the worst-case scenario.


-Best, Average, and Worst-Case Scenarios:

Best Case: The minimum time required for an algorithm to complete.
Average Case: The expected time for an algorithm over all possible inputs.
Worst Case: The maximum time an algorithm can take.*/


import java.util.Arrays;
import java.util.Comparator;

public class Main {

    
    static class Product {
        private int productId;
        private String productName;
        private String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public int getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public String getCategory() {
            return category;
        }
    }

    
    static class LinearSearch {
        public static int linearSearch(Product[] products, String targetName) {
            for (int i = 0; i < products.length; i++) {
                if (products[i].getProductName().equalsIgnoreCase(targetName)) {
                    return i; 
                }
            }
            return -1; 
        }
    }

    
    static class BinarySearch {
        public static int binarySearch(Product[] products, String targetName) {
            int left = 0;
            int right = products.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int comparison = products[mid].getProductName().compareToIgnoreCase(targetName);

                if (comparison == 0) {
                    return mid; 
                } else if (comparison < 0) {
                    left = mid + 1; 
                } else {
                    right = mid - 1; 
                }
            }
            return -1; 
        }
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "macbook", "Electronics"),
            new Product(2, "iphone", "Electronics"),
            new Product(3, "boots", "Fashion"),
            new Product(4, "tempest", "Education")
        };

        
        int linearResult = LinearSearch.linearSearch(products, "tempest");
        if (linearResult != -1) {
            System.out.println("Linear Search: Product found at index " + linearResult);
        } else {
            System.out.println("Linear Search: Product not found");
        }

        
        Arrays.sort(products, Comparator.comparing(Product::getProductName, String.CASE_INSENSITIVE_ORDER));

        int binaryResult = BinarySearch.binarySearch(products, "tempest");
        if (binaryResult != -1) {
            System.out.println("Binary Search: Product found at index " + binaryResult);
        } else {
            System.out.println("Binary Search: Product not found");
        }
    }
}


/*-Analysis
Linear Search:

-Time Complexity: O(n)
Use Case: Suitable for unsorted data or small datasets.
Binary Search:

-Time Complexity: O(log n)
Use Case: Requires sorted data suitable for large datasets.


for e-commerce platform binary search is more suitable.*/
