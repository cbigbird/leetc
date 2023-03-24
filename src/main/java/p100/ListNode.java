package main.java.p100;

public class ListNode {
    int val;

    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode gen(int[] numbs) {
        ListNode result = null;
        for (int i = numbs.length - 1; i > -1; i--) {
            result = new ListNode(numbs[i], result);
        }
        return result;
    }

    public static void print(ListNode node) {
        System.out.print("[");
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
        System.out.println("]");
    }
}