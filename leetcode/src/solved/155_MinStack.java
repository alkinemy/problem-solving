/**
 * https://leetcode.com/problems/min-stack/
 */

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> min;
    
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
        this.min = new Stack<>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            min.push(x);
        } else {
            stack.push(x);
            min.push(Math.min(min.peek(), x));
        }
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
