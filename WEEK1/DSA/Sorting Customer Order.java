/*Understanding Sorting Algorithms
-Bubble Sort:
Repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. This process is repeated until the list is sorted.
-Insertion Sort:
Builds the final sorted array one item at a time, inserting each new element into the correct position relative to already sorted elements.
-Quick Sort:
 Divides the array into sub-arrays by selecting a pivot element and partitions the other elements into two groups: less than or equal to the pivot and greater than the pivot. Recursively sorts the sub-arrays.
-Merge Sort:
 Divides the array into halves, recursively sorts them, and then merges the sorted halves.*/

import java.util.Arrays;

public class SortingOrders {

    
    static class Order {
        private int orderId;
        private String customerName;
        private double totalPrice;

        public Order(int orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        public int getOrderId() {
            return orderId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        @Override
        public String toString() {
            return "Order{" +
                   "orderId=" + orderId +
                   ", customerName='" + customerName + '\'' +
                   ", totalPrice=" + totalPrice +
                   '}';
        }
    }

    
    static class BubbleSort {
        public static void bubbleSort(Order[] orders) {
            int n = orders.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                        
                        Order temp = orders[j];
                        orders[j] = orders[j + 1];
                        orders[j + 1] = temp;
                    }
                }
            }
        }
    }

    
    static class QuickSort {
        public static void quickSort(Order[] orders, int low, int high) {
            if (low < high) {
                int pi = partition(orders, low, high);

                quickSort(orders, low, pi - 1); 
                quickSort(orders, pi + 1, high); 
            }
        }

        private static int partition(Order[] orders, int low, int high) {
            double pivot = orders[high].getTotalPrice();
            int i = (low - 1); 

            for (int j = low; j < high; j++) {
                if (orders[j].getTotalPrice() <= pivot) {
                    i++;

                    
                    Order temp = orders[i];
                    orders[i] = orders[j];
                    orders[j] = temp;
                }
            }

            
            Order temp = orders[i + 1];
            orders[i + 1] = orders[high];
            orders[high] = temp;

            return i + 1;
        }
    }

    public static void main(String[] args) {
        
        Order[] orders = {
            new Order(1, "Siddharth k. Choudhary", 259),
            new Order(2, "Sanjona B", 157),
            new Order(3, "Sampurna Ghosal", 378),
            new Order(4, "Nirmal Singh", 108)
        };

        
        System.out.println("Original Orders:");
        for (Order order : orders) {
            System.out.println(order);
        }

        
        Order[] bubbleSortedOrders = orders.clone();
        BubbleSort.bubbleSort(bubbleSortedOrders);
        System.out.println("\nBubble Sort Results:");
        for (Order order : bubbleSortedOrders) {
            System.out.println(order);
        }

        
        Order[] quickSortedOrders = orders.clone();
        QuickSort.quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);
        System.out.println("\nQuick Sort Results:");
        for (Order order : quickSortedOrders) {
            System.out.println(order);
        }
    }
}


/*-Bubble Sort:
Time Complexity: O(n²) for all cases.

-Quick Sort:
Time Complexity: O(n log n) on average, but can degrade to O(n²) in the worst case if the pivot is poorly chosen.


Quick Sort is generally preferred over Bubble Sort due to its superior average-case performance, especially for larger datasets.*/
