import java.util.Scanner;

class LinkedListRepresentation {

    // Node class represents a single node of the linked list
    static class Node {
        int data;      // stores data
        Node next;     // reference to next node

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;   // head of the linked list

    // Method to create linked list using user input
    public void createList(int n, Scanner sc) {
        // Time Complexity: O(n)
        // Space Complexity: O(n) -> for n nodes

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            Node newNode = new Node(value);

            if (head == null) {
                head = newNode;   // first node
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;  // attach at end
            }
        }
    }

    // Method to display linked list
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
        LinkedListRepresentation list = new LinkedListRepresentation();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter node values:");
        list.createList(n, sc);

        System.out.println("Linked List:");
        list.display();
    }
}
