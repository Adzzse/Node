
public class Tester {

    public static void main(String[] args) {
        MyList myList = new MyList();

        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);

        myList.traverse();

        int search = 3;
        Node result = myList.search(search);
        if (result != null) {
            System.out.println("Found " + search);
        } else {
            System.out.println("not found");
        }

        int del = 2;
        myList.dele(del);
        System.out.println("Deleted "+ del);

        myList.traverse();
    }
}
