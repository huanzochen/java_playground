class LinkedListNode {
    String data;
    LinkedListNode next;
    LinkedListNode previous;

    LinkedListNode(String data) {
        // singly linked list
        this.data = data;
        this.next = null;

        // doubly linked list
        this.previous = null;
    }
}

public class DeleteMiddleNode {

    private static LinkedListNode initiateLinkedList() {
        LinkedListNode head = new LinkedListNode("a");
        head.next = new LinkedListNode("b");
        head.next.next = new LinkedListNode("c");
        head.next.next.next = new LinkedListNode("d");
        head.next.next.next.next = new LinkedListNode("e");
        return head;
    }

    // This method should be the answer
    boolean deleteNode(LinkedListNode n) {

        // if n node is not a available node, or it is the last node, it should not able
        // to delete.
        if (n == null || n.next == null) {
            return false;
        }

        LinkedListNode next = n.next;
        n.next = next.next;
        n.data = next.data;
        return true;
    }

    public static void main(String[] args) {

        // has no access to entire LinkedList, only the specific node
        LinkedListNode head = initiateLinkedList();
        // no need other fuctions, this question is only about deleteing the middle
        // node.
    }

}
