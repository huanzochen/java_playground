class LinkedListNode {
    String data;
    LinkedListNode next;

    LinkedListNode(String data) {
        this.data = data;
        this.next = null;
    }
}

public class IterativeLinkedListNode {
    LinkedListNode head = new LinkedListNode("a");

    void initiateLinkedList() {
        this.head.next = new LinkedListNode("b");
        this.head.next.next = new LinkedListNode("c");
        this.head.next.next.next = new LinkedListNode("d");
        this.head.next.next.next.next = new LinkedListNode("e");
        this.head.next.next.next.next.next = new LinkedListNode("f");
    }

    LinkedListNode nthToLast(int k) {
        LinkedListNode p1 = this.head;
        LinkedListNode p2 = this.head;

        /* Move p1 to the index of k node */
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        System.out.println("p1.data now is:" + p1.data);

        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        System.out.println("p2.data:" + p2.data);
        return p2;
    }

    public static void main(String[] args) {
        IterativeLinkedListNode instance = new IterativeLinkedListNode();
        instance.initiateLinkedList();

        instance.nthToLast(2);

    }
}
