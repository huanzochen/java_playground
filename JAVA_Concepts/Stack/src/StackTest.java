import java.util.EmptyStackException;

class Stack<T> {

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop() {
        if(top == null) throw new EmptyStackException();
        T item = top.data;
        // Go to the next item, like abandon the first item
        top = top.next;
        return item;
    }

    public void push(T item) {
        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
    }

    public T peek() {
        if(top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements into the stack
        stack.push(100);
        stack.push(222);
        stack.push(200);

        System.out.println("Top element(peek):" + stack.peek());

        // Pop all elements and print them
        while(!stack.isEmpty()){
            System.out.println("Pooped:" + stack.pop());
        }


        // Trying to pop more will throw exception
        try {
            stack.pop();
        } catch (EmptyStackException e) {
            System.out.println("Stack is empty. Cannot pop");
        }
    }
}

