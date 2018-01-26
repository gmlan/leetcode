package leetcode.stack;

import java.util.Stack;

import org.junit.Test;

public class MaxStack_713 {
	
	@Test
	public void test(){
		
		MaxStack st = new MaxStack();
		st.push(1);
		System.out.println(st.peekMax());
		st.push(4);
		System.out.println(st.peekMax());
		st.push(5);
		System.out.println(st.peekMax());
		st.push(2);
		System.out.println(st.peekMax());
		st.push(4);
		System.out.println(st.peekMax());
		st.push(8);
		System.out.println(st.peekMax());
		
		
		st.popMax();
		System.out.println(st.peekMax());

		st.popMax();
		System.out.println(st.peekMax());
	}
}

class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        int max = maxStack.isEmpty() ? x : maxStack.peek();
        maxStack.push(max > x ? max : x);
        stack.push(x);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = peekMax();
        Stack<Integer> buffer = new Stack<>();
        while (top() != max) buffer.push(pop());
        pop();
        while (!buffer.isEmpty()) push(buffer.pop());
        return max;
    }
}