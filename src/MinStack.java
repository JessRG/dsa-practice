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
    int currentIdx = -1;
    // list to store all/any values entered into the minStack
    List<Integer> list;
    // List to store the indexes of the most minimum value at the end of the list
    List<Integer> lowest;

    public MinStack() {
        // Initialize the instance variables (Lists/ArrayLists)
        list = new ArrayList<>();
        lowest = new ArrayList<>();
    }

    public void push(int x) {
        // add parameter (x) into the list and increment the currentIdx instance variable
        list.add(x);
        currentIdx++;
        // push into the lowest list if the list is currently empty
        if(lowest.isEmpty()) lowest.add(currentIdx);
        // if the parameter is less than or equal to the most minimum value
        else if(list.get(lowest.get(lowest.size() - 1)) >= x) lowest.add(currentIdx);
    }

    public void pop() {
        // check if the last element in the list is the current lowest
        // if it is remove the last element from the lowest list
        // remove the last element in the list and decrement the current index
        if(lowest.get(lowest.size() - 1) == currentIdx) lowest.remove(lowest.size() - 1);
        list.remove(currentIdx);
        currentIdx--;
    }

    public int top() {
        return list.get(currentIdx);
    }

    public int getMin() {
        return list.get(lowest.get(lowest.size() - 1));
    }
}