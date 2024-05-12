import java.util.NoSuchElementException;

class Queue<T> {
    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T item) {
        QueueNode<T> t = new QueueNode<T>(item);
        if(last != null) {
            last.next = t;
        }
        last = t;
        if(first == null) {
            first = last;
        }
    }

    public T remove() {
        if(first == null) throw new NoSuchElementException();
        T data = first.data;
        first = first.next;
        if(first == null) {
            // if first == null, means the last node is already be iterated, so the last node should be clear too.
            last = null;
        }
        return data;
    }

    public T peek() {
        if (first == null) throw new NoSuchElementException();
        return first.data;
    }

    public void printAll() {
        QueueNode<T> current = first;
        System.out.println("pointer first.data:" + current.data);
        System.out.println("last.data:" + last.data); // not manipulating so I can use the original node.
        while(current.next != null) {
            current = current.next;
            System.out.println("current.data:" + current.data);
        }
    }

    public boolean isEmpty() {
        return first == null;
    }
}


public class QueueTest {

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();

        queue.add("aaa");
        queue.add("bbb");
        queue.add("ccc");
        queue.add("ddd");
        queue.add("eee");

        queue.printAll();

        System.out.println("Have a peek on queue's top:" + queue.peek());

        queue.remove();
        queue.printAll();

        System.out.println("Have a peek on queue's top:" + queue.peek());

        System.out.println("queue.isEmpty():" + queue.isEmpty());
    }
}
