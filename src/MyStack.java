public class MyStack {
    private int[] elements;
    private int count;
    private int initialSize = 10;
    /** Initialize your data structure here. */
    public MyStack() {
        elements=new int[initialSize];
        count = 0;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(elements.length == count) {
            elements = grow();
        }
        elements[count] = x;
        count++;
    }

    private int[] grow() {
        int newSize = elements.length*2;
        int[] res =new int[newSize];
        System.arraycopy(elements,0,res,0,elements.length);
        return res;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int res = elements[count-1];
        count--;
        return res;
    }

    /** Get the top element. */
    public int top() {
        return elements[count-1];
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return count==0;
    }

    public static void main(String[] args) {
        int x=1;
            MyStack obj = new MyStack();
            obj.push(x);
            int param_2 = obj.pop();
            int param_3 = obj.top();
            boolean param_4 = obj.empty();
    }
}
