/*-Understanding Search Algorithms
Linear Search:
 Iterates over each element in a list to find a target value.
 O(n) for both average and worst-case scenarios.
Binary Search:
 Efficiently finds a target value in a sorted list by repeatedly dividing the search interval in half.
 O(log n) for average and worst-case scenarios.*/

import java.util.Arrays;

class Book {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book(ID: " + bookId + ", Title: '" + title + "', Author: '" + author + "')";
    }
}

public class LibraryManagementSystem {

    public static int linearSearch(Book[] books, String title) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equals(title)) {
                return i;
            }
        }
        return -1; 
    }

    public static int binarySearch(Book[] books, String title) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = books[mid].getTitle().compareTo(title);
            
            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        
        Book[] books = {
           new Book(1, "Sherlock Holmes", "Arthur Conan Doyle"),
           new Book(2, "1984", "George Orwell"),
           new Book(3, "A Dance with Dragons", "George R.R. Martin"),
           new Book(4, "Pride and Prejudice", "Jane Austen"),
           new Book(5, "Tempest", "William Shakespeare"),
        };

        
        Arrays.sort(books, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));

        
        String searchTitle = "A Dance with Dragons";

        
        int indexLinear = linearSearch(books, searchTitle);
        if (indexLinear != -1) {
            System.out.println("Linear Search: Found '" + searchTitle + "' at index " + indexLinear + ".");
        } else {
            System.out.println("Linear Search: '" + searchTitle + "' not found.");
        }

        
        int indexBinary = binarySearch(books, searchTitle);
        if (indexBinary != -1) {
            System.out.println("Binary Search: Found '" + searchTitle + "' at index " + indexBinary + ".");
        } else {
            System.out.println("Binary Search: '" + searchTitle + "' not found.");
        }
    }
}


/*-Analysis
Linear Search:
Time Complexity: O(n) 
Binary Search:
Time Complexity: O(log n)

-When to Use Linear Search: Suitable for small or unsorted datasets.
-When to Use Binary Search: Best for large, sorted datasets due to its logarithmic time complexity.*/
