/*-Understanding Recursive Algorithms
 A recursive algorithm solves a problem by solving smaller instances of the same problem. It involves a base case to end recursion and a recursive case to reduce the problem size.
 Recursion can simplify complex problems, such as computing sequences or traversing data structures, by breaking them into more manageable sub-problems.*/

public class FinancialForecasting {

   
    public static double computeFutureValue(double initialAmount, double annualRate, int years) {
        
        if (years == 0) {
            return initialAmount;
        }
        
        return computeFutureValue(initialAmount * (1 + annualRate), annualRate, years - 1);
    }

    public static void main(String[] args) {
        double initialAmount = 1000.0; 
        double annualRate = 0.05;      
        int years = 10;              

        double futureValue = computeFutureValue(initialAmount, annualRate, years);
        System.out.println("The future value of the investment is: Rs" + String.format("%.2f", futureValue));
    }
}

/*-Analysis
Time Complexity:
 O(n), where n is the number of periods.

Optimization:
 Store in-process results to avoid redundant calculations
 For large datasets or many periods, an iterative approach  may be preferred.*/

