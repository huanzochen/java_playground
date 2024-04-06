import java.util.HashSet;

class LinkedListNode {
    int data;
    LinkedListNode next;

    LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveDups {
    static LinkedListNode initiateLinkedList() {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(2);
        head.next.next.next = new LinkedListNode(3);
        head.next.next.next.next = new LinkedListNode(4);
        head.next.next.next.next.next = new LinkedListNode(2);
        head.next.next.next.next.next.next = new LinkedListNode(5);
        return head;
    }

    static void printLinkedList(LinkedListNode head) {
        // System.out.print(this);
        // Print the List after removing duplicates
        LinkedListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    static void deleteDups(LinkedListNode n) {
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedListNode previous = null;
        while (n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }

    static void deleteDupsWithNoBuffer(LinkedListNode head) {
        LinkedListNode current = head;
        while (current != null) {
            /* Remove all feature nodes that have the same value */
            LinkedListNode runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {

        // Instantiate RemoveDups, Create the nodes, and call deleteDups()
        LinkedListNode head = initiateLinkedList();
        deleteDups(head);
        printLinkedList(head);

        LinkedListNode head2 = initiateLinkedList();
        deleteDupsWithNoBuffer(head2);
        printLinkedList(head2);
    }
}
