
class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void add(int x) {
        if (isEmpty()) {
            head = tail = new Node(x, null);
        } else {
            Node q = new Node(x, null);
            tail.next = q;
            tail = q;
        }
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            System.out.print("  " + p.info);
            p = p.next;
        }
        System.out.println();
    }

    Node search(int x) {
        Node p = head;
        while (p != null) {
            if (p.info == x) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    void dele(int x) {
        if (isEmpty()) {
            // List is empty, nothing to delete
            return;
        }

        if (head.info == x) {
            // Special case: if the value to delete is in the head node
            if (head == tail) {
                // Only one node in the list, set head and tail to null
                head = tail = null;
            } else {
                // Move head to the next node
                head = head.next;
            }
            return; // Value found and deleted
        }

        // Search for the node with the value x
        Node p = head;
        while (p.next != null && p.next.info != x) {
            p = p.next;
        }

        if (p.next != null) {
            // Found the node to delete
            if (p.next == tail) {
                // If the node to delete is the tail, update tail
                tail = p;
            }
            // Remove the node from the list
            p.next = p.next.next;
        }
    }
}
