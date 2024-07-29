*/-Understanding Array Representation
Arrays are contiguous blocks of memory where each element is stored at a fixed offset from the start. This allows for fast access to elements using an index.
Advantages:
Fast Access
Efficiency:*/

public class EmployeeManagementSystem {

    
    static class Employee {
        private int employeeId;
        private String name;
        private String position;
        private double salary;

        public Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        public int getEmployeeId() {
            return employeeId;
        }

        public String getName() {
            return name;
        }

        public String getPosition() {
            return position;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                   "employeeId=" + employeeId +
                   ", name='" + name + '\'' +
                   ", position='" + position + '\'' +
                   ", salary=" + salary +
                   '}';
        }
    }

    
    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

  
    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
        } else {
            System.out.println("Error: Cannot add more employees. Array is full.");
        }
    }

  
    public Employee searchEmployeeById(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

  
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

  
    public void deleteEmployeeById(int employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee not found.");
            return;
        }

        for (int i = index; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[size - 1] = null; // Clear the last element
        size--;
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);

        
        ems.addEmployee(new Employee(1, "Nirmal", "Manager", 80000));
        ems.addEmployee(new Employee(2, "Siddharth", "Developer", 60000));
        ems.addEmployee(new Employee(3, "Raj", "Analyst", 55000));
        ems.addEmployee(new Employee(4, "Priya", "HR", 50000));
        ems.addEmployee(new Employee(5, "Srija", "Consultant", 65000));
        ems.addEmployee(new Employee(6, "Shalini", "GM", 40000));

      
        System.out.println("All Employees:");
        ems.traverseEmployees();

        
        Employee e = ems.searchEmployeeById(1);
        System.out.println("\nSearch Result:");
        if (e != null) {
            System.out.println(e);
        } else {
            System.out.println("Employee not found.");
        }

        
        ems.deleteEmployeeById(4);
        System.out.println("\nEmployees after deletion:");
        ems.traverseEmployees();
    }
}

/*-Analysis
Add Employee:
Time Complexity: O(1) 
-Search Employee:
Time Complexity: O(n) 
-Traverse Employees:
Time Complexity: O(n) 
Delete Employee:
-Time Complexity: O(n) 
-Limitations of Arrays
Fixed Size.
Inefficient Insertions,Deletions.*/
