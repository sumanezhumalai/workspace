class Node {
  int data;
  Node next;

  Node(int data) {
    this.data = data;
    this.next = null;
  }
}

public class Queued {
  private static Node head = null;
  private static Node tail = null;

  // Insert at end
  public static void insert(int data) {
    Node newNode = new Node(data);

    if (head == null) {
      head = newNode;
      tail = newNode;
      newNode.next = head; // circular link
    } else {
      tail.next = newNode;
      tail = newNode;
      tail.next = head; // maintain circular linik
    }
  }

  // Display list
  public static void display() {
    if (head == null) {
      System.out.println("List is empty");
      return;
    }

    Node temp = head;
    do {
      System.out.print(temp.data + " ");
      temp = temp.next;
    } while (temp != head);
    System.out.println();
  }

  // Delete from beginning
  public static void delete() {
    if (head == null) {
      System.out.println("List is empty");
      return;
    }

    if (head == tail) {
      head = null;
      tail = null;
    } else {
      head = head.next;
      tail.next = head;
    }
  }

  public static void main(String args[]) {
    insert(100);
    insert(200);
    insert(300);
    display();
  }
}
