class LinkedListNode {
    String data;
    LinkedListNode next;

    LinkedListNode(String data) {
        this.data = data;
        this.next = null;
    }
}

public class FindKthToLastElement {
    LinkedListNode head = new LinkedListNode("a");

    void initiateLinkedList() {
        this.head.next = new LinkedListNode("b");
        this.head.next.next = new LinkedListNode("c");
        this.head.next.next.next = new LinkedListNode("d");
        this.head.next.next.next.next = new LinkedListNode("e");
    }

    int printKthToLastElement(LinkedListNode head, int k) {
        if (head == null) {
            return 0;
        }
        int index = printKthToLastElement(head.next, k) + 1;
        System.out.println("index:" + index);
        System.out.println("head.data:" + head.data);
        if (index == k) {
            System.out.println(k + "th to last node is " + head.data);
        }
        return index;
    }

    public static void main(String[] args) {
        FindKthToLastElement instance = new FindKthToLastElement();
        instance.initiateLinkedList();

        int resultIndex = instance.printKthToLastElement(instance.head, 2); // 2th to last node is 3

        // this will print the last index, should be 5
        System.out.println("resultIndex should be 2, resultIndex:" + resultIndex);

    }
}
