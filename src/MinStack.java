import java.util.ArrayList;
import java.util.List;

// Min Stack
    //Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
    // push(x) -- Push element x onto stack.
    // pop() -- Removes the element on top of the stack.
    // top() -- Get the top element.
    // getMin() -- Retrieve the minimum element in the stack.
public class MinStack {

    /** initialize your data structure here. */
    int lowIdx = -1;
    // list to store all/any values entered into the minStack
    List<Integer> list;
    // List to store the indexes of the most minimum value at the end (tail) of the list
    List<Integer> lowest;

    public MinStack() {
        // Initialize the instance variables (Lists/ArrayLists)
        list = new ArrayList<>();
        lowest = new ArrayList<>();
    }

    public void push(int x) {
        // add parameter (x) into the list and increment the lowIdx instance variable
        list.add(x);
        lowIdx++;
        // push into the lowest list if the list is currently empty
        if(lowest.isEmpty()) lowest.add(lowIdx);
        // if the parameter is less than or equal to the most minimum value
        else if(list.get(lowest.get(lowest.size() - 1)) >= x) lowest.add(lowIdx);
    }

    public void pop() {
        // Write logic for MinStack here...
    }

    public int top() {
        return 0;
    }

    public int getMin() {
        return 0;
    }
}