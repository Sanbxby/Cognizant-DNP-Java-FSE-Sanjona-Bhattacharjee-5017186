*/-Understanding Linked Lists
-Singly Linked List:
 Each node contains data and a reference to the next node.
 Simple structure, efficient for insertions/deletions at the head.
-Doubly Linked List:
 Each node contains data, a reference to the next node, and a reference to the previous node.
 Advantages: Allows for traversal in both directions.*/

public class TaskManagementSystem {

  
    static class Task {
        private int taskId;
        private String taskName;
        private String status;

        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        public int getTaskId() {
            return taskId;
        }

        public String getTaskName() {
            return taskName;
        }

        public String getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return "Task{" +
                   "taskId=" + taskId +
                   ", taskName='" + taskName + '\'' +
                   ", status='" + status + '\'' +
                   '}';
        }
    }


    static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }


    private Node head;
    private Node tail;

    public TaskManagementSystem() {
        head = null;
        tail = null;
    }


    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

  
    public Task searchTaskById(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    
    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    
    public void deleteTaskById(int taskId) {
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                if (previous == null) {
                    head = current.next;
                    if (head == null) {
                        tail = null;
                    }
                } else {
                    previous.next = current.next;
                    if (current.next == null) {
                        tail = previous;
                    }
                }
                return;
            }
            previous = current;
            current = current.next;
        }
        System.out.println("Task not found.");
    }

    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();

        
        tms.addTask(new Task(1, "Pay Bills", "In Progress"));
        tms.addTask(new Task(2, "Grocery Shopping", "Not Started"));
        tms.addTask(new Task(3, "Prepare Meals", "Completed"));
        tms.addTask(new Task(4, "Do Laundry", "In Progress"));
        tms.addTask(new Task(5, "Clean the Kitchen", "Not Started"));
        tms.addTask(new Task(6, "9-5 Job", "Completed"));

        
        System.out.println("All Tasks:");
        tms.traverseTasks();

      
        Task task = tms.searchTaskById(3);
        System.out.println("\nSearch Result:");
        if (task != null) {
            System.out.println(task);
        } else {
            System.out.println("Task not found.");
        }

        
        tms.deleteTaskById(5);
        System.out.println("\nTasks after deletion:");
        tms.traverseTasks();
    }
}


/*-Analysis
Add Task:
Time Complexity: O(1)
Search Task:
Time Complexity: O(n)
Traverse Tasks:
Time Complexity: O(n)
Delete Task:
Time Complexity: O(n)

-Advantages of Linked Lists over Arrays
Linked lists can grow and shrink dynamically, unlike arrays with fixed sizes.
Adding or removing nodes is efficient if done at the head or if the reference to the node is available, as it does not require shifting elements like in arrays.*/
