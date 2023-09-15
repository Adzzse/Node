
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
            tail.next = head; // Make it circular
        } else {
            Node q = new Node(x, null);
            tail.next = q;
            tail = q;
            tail.next = head; // Make it circular
        }
    }

    void traverse() {
        Node p = head;
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        do {
            System.out.print("  " + p.info);
            p = p.next;
        } while (p != head);
        System.out.println();
    }

    Node search(int x) {
        Node p = head;
        if (isEmpty()) {
            return null;
        }
        do {
            if (p.info == x) {
                return p;
            }
            p = p.next;
        } while (p != head);
        return null;
    }

    void dele(int x) {
        if (isEmpty()) {
            
            return;
        }

        if (head.info == x) {
            if (head == tail) {
                clear();
            } else {
                // Move head to the next node and update tail's next
                head = head.next;
                tail.next = head;
            }
            return;
        }

        Node p = head;
        Node prev = null;
        if (isEmpty()) {
            return;
        }
        do {
            if (p.info == x) {
                break;
            }
            prev = p;
            p = p.next;
        } while (p != head);

        if (p == head) {
            // Value not found
            return;
        }

        if (p == tail) {
            // If the node to delete is the tail, update tail and prev's next
            tail = prev;
            prev.next = head;
        } else {
            // Remove the node from the list
            prev.next = p.next;
        }
    }
}
