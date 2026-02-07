import java.util.Scanner;

class SearchElementLinkedList {

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

    // Search element in linked list
    public int search(int key) {
        // Time Complexity: O(n)
        // Space Complexity: O(1)

        Node temp = head;
        int position = 1; // 1-based index

        while (temp != null) {
            if (temp.data == key) {
                return position; // element found
            }
            temp = temp.next;
            position++;
        }

        return -1; // element not found
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
        SearchElementLinkedList list = new SearchElementLinkedList();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) {
            list.insertAtEnd(sc.nextInt());
        }

        System.out.println("Linked List:");
        list.display();

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        int result = list.search(key);

        if (result != -1) {
            System.out.println("Element found at position: " + result);
        } else {
            System.out.println("Element not found in the linked list");
        }
    }
}
