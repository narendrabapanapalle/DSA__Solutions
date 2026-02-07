import java.util.Scanner;

class LinkedListLength {

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

    // Insert at end to create linked list
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

    // Find length of linked list using traversal
    public int findLength() {
        // Time Complexity: O(n)
        // Space Complexity: O(1)

        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
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
        LinkedListLength list = new LinkedListLength();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) {
            list.insertAtEnd(sc.nextInt());
        }

        System.out.println("Linked List:");
        list.display();

        int length = list.findLength();
        System.out.println("Length of Linked List = " + length);
    }
}
