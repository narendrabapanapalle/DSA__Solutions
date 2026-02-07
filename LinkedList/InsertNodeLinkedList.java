import java.util.Scanner;

class InsertNodeLinkedList {

    // Node representation
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    // Insert at beginning
    public void insertAtBeginning(int value) {
        // Time Complexity: O(1)
        // Space Complexity: O(1)

        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    public void insertAtEnd(int value) {
        // Time Complexity: O(n)
        // Space Complexity: O(1)

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Insert at given position (1-based index)
    public void insertAtPosition(int value, int position) {
        // Time Complexity: O(n)
        // Space Complexity: O(1)

        if (position <= 0) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            insertAtBeginning(value);
            return;
        }

        Node newNode = new Node(value);
        Node temp = head;

        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of range");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Display linked list
    public void display() {
        // Time Complexity: O(n)
        // Space Complexity: O(1)

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InsertNodeLinkedList list = new InsertNodeLinkedList();

        System.out.print("Enter initial number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) {
            list.insertAtEnd(sc.nextInt());
        }

        System.out.println("Original Linked List:");
        list.display();

        System.out.print("Enter value to insert: ");
        int value = sc.nextInt();

        System.out.print("Enter position to insert (1-based): ");
        int pos = sc.nextInt();

        list.insertAtPosition(value, pos);

        System.out.println("Linked List after insertion:");
        list.display();
    }
}
