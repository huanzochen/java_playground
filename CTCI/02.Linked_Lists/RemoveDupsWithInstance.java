import java.util.HashSet;

class LinkedListNode {
    int data;
    LinkedListNode next;

    LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveDupsWithInstance {
    LinkedListNode head = new LinkedListNode(1);

    void initiateLinkedList() {
        this.head.next = new LinkedListNode(2);
        this.head.next.next = new LinkedListNode(2);
        this.head.next.next.next = new LinkedListNode(3);
        this.head.next.next.next.next = new LinkedListNode(4);
        this.head.next.next.next.next.next = new LinkedListNode(2);
        this.head.next.next.next.next.next.next = new LinkedListNode(5);
    }

    void printLinkedList() {
        // System.out.print(this);
        // Print the List after removing duplicates
        LinkedListNode current = this.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    void deleteDups() {
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedListNode current = this.head;
        LinkedListNode previous = null;
        while (current != null) {
            if (set.contains(current.data)) {
                previous.next = current.next;
            } else {
                set.add(current.data);
                previous = current;
            }
            current = current.next;
        }
    }

    void deleteDupsWithNoBuffer() {
        LinkedListNode current = this.head;
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
        RemoveDupsWithInstance remover = new RemoveDupsWithInstance();
        remover.initiateLinkedList();
        remover.deleteDups();
        remover.printLinkedList();

        RemoveDupsWithInstance remover2 = new RemoveDupsWithInstance();
        remover2.initiateLinkedList();
        remover2.deleteDupsWithNoBuffer();
        remover2.printLinkedList();
    }
}
