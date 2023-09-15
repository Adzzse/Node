
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
            tail.next = head; //circular
        } else {
            Node q = new Node(x, null);
            tail.next = q;
            tail = q;
            tail.next = head; //circular
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
                head = head.next;
                tail.next = head;
            }return;
        }

        Node p = head;
        Node prev = null;
        do {
            if (p.info == x) {
                break;
            }
            prev = p;
            p = p.next;
        } while (p != head);

        if (p == head) {return;}

        if (p == tail) {
            tail = prev;
            prev.next = head;
        } else {
            prev.next = p.next;
        }
    }
}
