// This Java code can take 2 linked-list of user-input elements and can add them and can publish a new merged list 

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class AddTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for the first linked list
        System.out.print("Enter the number of elements for the first linked list: ");
        int n1 = scanner.nextInt();
        ListNode head1 = createLinkedList(scanner, n1);

        // Input for the second linked list
        System.out.print("Enter the number of elements for the second linked list: ");
        int n2 = scanner.nextInt();
        ListNode head2 = createLinkedList(scanner, n2);

        // Print both linked lists
        System.out.println("First linked list:");
        printLinkedList(head1);
        System.out.println("Second linked list:");
        printLinkedList(head2);

        // Merge the linked lists
        ListNode result = addTwoNumbers(head1, head2);

        // Print the merged linked list
        System.out.println("Merged linked list:");
        printLinkedList(result);

        scanner.close();
    }

    private static ListNode createLinkedList(Scanner scanner, int n) {
        ListNode head = null;
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
            } else {
                ListNode current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }
        return head;
    }

    private static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;

        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
}
