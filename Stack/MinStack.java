import java.util.*;

public class MinStack {
    //Approach 1
    Stack<int[]> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
        } else {
            int min = Math.min(val, stack.peek()[1]);
            stack.push(new int[]{val, min});
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }

    // Approach 2
    // Stack<Long> stack;
    // long minVal;
    // public MinStack() {
    //     stack = new Stack<>();
    // }
    
    // public void push(int val) {
    //     long x = val;

    //     if (stack.isEmpty()) {
    //         stack.push(x);
    //         minVal = x;
    //     } else {
    //         if (x < minVal) {
    //             stack.push(2 * x - minVal);   // encoded value
    //             minVal = x;
    //         } else {
    //             stack.push(x);
    //         }
    //     }
    // }
    
    // public void pop() {
    //     if (stack.peek() < minVal) {
    //         minVal = 2 * minVal - stack.peek();   // restore previous min
    //     }
    //     stack.pop();
    // }
    
    // public int top() {
    //     if (stack.peek() < minVal) {
    //         return (int) minVal;
    //     }
    //     return stack.peek().intValue();
    // }
    
    // public int getMin() {
    //     return (int) minVal;
    // }

}