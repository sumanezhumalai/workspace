public class Linkedlst {

    static Node head = null;


    // INSERT AT BEGINNING
    static void insertBeg(int data) {

        Node nn = new Node(data);

        if (head == null) {
            head = nn;
        }
        else {
            nn.next = head;
            head = nn;
        }
    }


    // DELETE AT BEGINNING
    static void deleteBeg() {

        if (head == null)
            return;

        Node x = head;

        head = head.next;

        x.next = null;
    }


    // INSERT AT LAST
    static void insertLast(int data) {

        if (head == null) {
            insertBeg(data);
            return;
        }

        Node x = head;
        Node nn = new Node(data);

        while (x.next != null) {
            x = x.next;
        }

        x.next = nn;
    }


    // DELETE AT LAST
    static void deleteLast() {

        if (head == null)
            return;

        // Only one node
        if (head.next == null) {
            head = null;
            return;
        }

        Node x = head;

        while (x.next.next != null) {
            x = x.next;
        }

        x.next = null;
    }


    // INSERT AT POSITION
    // position starts from 0
    static void insertMid(int data, int pos) {

        if (pos < 0)
            return;

        if (pos == 0) {
            insertBeg(data);
            return;
        }

        if (head == null)
            return;

        Node x = head;

        int c = 0;

        while (c < pos - 1 && x != null) {
            x = x.next;
            c++;
        }

        // Position doesn't exist
        if (x == null)
            return;

        Node nn = new Node(data);

        nn.next = x.next;
        x.next = nn;
    }


    // DELETE AT POSITION
    // position starts from 0
    static void deleteMid(int pos) {

        if (head == null || pos < 0)
            return;

        // Delete first node
        if (pos == 0) {
            deleteBeg();
            return;
        }

        Node x = head;

        int c = 0;

        while (c < pos - 1 && x != null) {
            x = x.next;
            c++;
        }

        // Position doesn't exist
        if (x == null || x.next == null)
            return;

        Node y = x.next;

        x.next = y.next;

        y.next = null;
    }


    // DISPLAY
    static void display() {

        Node x = head;

        while (x != null) {

            System.out.print(x.data + " ");

            x = x.next;
        }

        System.out.println("over");
    }


    // FIND MIDDLE ELEMENT
    static void midElement() {

        if (head == null)
            return;

        Node i = head;
        Node j = head;

        /*
            i = slow pointer
            j = fast pointer

            i moves 1 step
            j moves 2 steps
        */

        while (j != null && j.next != null) {

            i = i.next;
            j = j.next.next;
        }

        System.out.println("Mid element is: " + i.data);
    }


    // FIND MAXIMUM VALUE
    static void maxValue() {

        if (head == null)
            return;

        int max = head.data;

        Node i = head.next;

        while (i != null) {

            if (i.data > max)
                max = i.data;

            i = i.next;
        }

        System.out.println("The Max value: " + max);
    }


    // REVERSE LIST
    static void reverseList() {

        if (head == null)
            return;

        Node pre = null;
        Node c = head;

        while (c != null) {

            Node fr = c.next;

            c.next = pre;

            pre = c;

            c = fr;
        }

        head = pre;

        display();
    }


    // CHECK WHETHER LIST IS CYCLIC
    static void isCyclic() {

        if (head == null)
            return;

        Node i = head;
        Node j = head;

        /*
            Floyd's Cycle Detection

            i = slow
            j = fast
        */

        while (j != null && j.next != null) {

            i = i.next;
            j = j.next.next;

            if (i == j) {

                System.out.println("It is a Cyclic List");
                return;
            }
        }

        System.out.println("It is NOT a Cyclic List");
    }


    public static void main(String[] args) {

        insertBeg(30);
        insertBeg(20);
        insertBeg(10);

        // 10 -> 20 -> 30

        insertLast(40);
        insertLast(50);

        // 10 -> 20 -> 30 -> 40 -> 50

        display();


        insertMid(25, 2);

        // 10 -> 20 -> 25 -> 30 -> 40 -> 50

        display();


        deleteMid(2);

        // 10 -> 20 -> 30 -> 40 -> 50

        display();


        midElement();

        maxValue();


        reverseList();

        // 50 -> 40 -> 30 -> 20 -> 10


        isCyclic();
    }
}


class Node {

    int data;
    Node next;

    Node(int data) {

        this.data = data;
        this.next = null;
    }
}