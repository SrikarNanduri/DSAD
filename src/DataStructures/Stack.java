package DataStructures;

/**
 * Created by srikar on 18-06-2021.
 */

/**
 * A stack is a linear data structure that follows the principle of Last In First Out (LIFO).
 * This means the last element inserted inside the stack is removed first.
 *
 * The operations work as follows:
 *
 * 1. A pointer called TOP is used to keep track of the top element in the stack.
 * 2. When initializing the stack, we set its value to -1 so that we can check if the stack is empty by comparing TOP == -1.
 * 3. On pushing an element, we increase the value of TOP and place the new element in the position pointed to by TOP.
 * 4. On popping an element, we return the element pointed to by TOP and reduce its value.
 * 5. Before pushing, we check if the stack is already full
 * 6. Before popping, we check if the stack is already empty
 * */

// Stack implementation in Java

class Stack {
    private int arr[];
    private int top;
    private int capacity;

    // Creating a stack
    Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    // Add elements into stack
    public void push(int x) {
        if (isFull()) {
            System.out.println("OverFlow\nProgram Terminated\n");
            System.exit(1);
        }

        System.out.println("Inserting " + x);
        /*
        1) Post-Increment (i++): we use i++ in our statement if we want to use the current value, and then we want to increment the value of i by 1.
        2) Pre-Increment(++i): We use ++i in our statement if we want to increment the value of i by 1 and then use it in our statement.
        */
        arr[++top] = x;
    }

    // Remove element from stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("STACK EMPTY");
            System.exit(1);
        }
        System.out.println("\npopping: " + arr[top]);
        return arr[top--];
    }

    // Utility function to return the size of the stack
    public int size() {
        return top + 1;
    }

    // Check if the stack is empty
    public Boolean isEmpty() {
        return top == -1;
    }

    // Check if the stack is full
    public Boolean isFull() {
        return top == capacity - 1;
    }

    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.println(arr[i]);
        }
    }

    public void peek() {
        System.out.println("\nTop element:");
        System.out.println(arr[top]);
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        // peek top element
        stack.peek();
        // pop top element
        stack.pop();
        System.out.println("\nAfter popping out");
        // print stack
        stack.printStack();
        // peek top element
        stack.peek();
        // pop top element
        stack.pop();
        System.out.println("\nAfter popping out");
        // print stack
        stack.printStack();
    }
}
