class LinkedListNode {
    String data;
    LinkedListNode next;

    LinkedListNode(String data) {
        this.data = data;
        this.next = null;
    }
}

class Index {
    public int value = 0;
}

public class FindKthToLastElementWithWrapperClass {
    LinkedListNode head = new LinkedListNode("a");

    void initiateLinkedList() {
        this.head.next = new LinkedListNode("b");
        this.head.next.next = new LinkedListNode("c");
        this.head.next.next.next = new LinkedListNode("d");
        this.head.next.next.next.next = new LinkedListNode("e");
    }

    LinkedListNode kthToLast(LinkedListNode head, int k) {
        Index idx = new Index();
        return kthToLast(head, k, idx);
    }

    private LinkedListNode kthToLast(LinkedListNode head, int k, Index idx) {
        if (head == null) {
            return null;
        }

        // debug
        System.out.println("the node is now: " + head.data);

        LinkedListNode node = kthToLast(head.next, k, idx);

        // debug
        System.out.println("the index is now: " + idx.value);
        System.out.println("the current head is now: " + head.data);

        if (node != null) {
            System.out.println("the current on hand recursive node is: " + node.data);
        } else {
            System.out.println("the current on hand recursive node is: " + node);
        }

        idx.value = idx.value + 1;
        if (idx.value == k) {
            return head;
        }
        return node;
    }

    public static void main(String[] args) {
        FindKthToLastElementWithWrapperClass instance = new FindKthToLastElementWithWrapperClass();
        instance.initiateLinkedList();

        LinkedListNode targetNode = instance.kthToLast(instance.head, 2); // 2th to last node is d

        // this will print the last index, should be 5
        System.out.println("The target node is targetNode: " + targetNode.data);
        System.out.println("The next node of TargetNode is: " + targetNode.next.data);

    }
}
