package main.java.p100;

public class P19RemoveNthFromEnd {
    public static void main(String[] args) {
        P19RemoveNthFromEnd entity = new P19RemoveNthFromEnd();
        ListNode list1 = entity.gen(new int[]{1,2,3,4,5});
        ListNode list2 = entity.gen(new int[]{1});
        ListNode list3 = entity.gen(new int[]{1,2});
        ListNode list4 = entity.gen(new int[]{1,2});
        System.out.println();
//        entity.print(entity.removeNthFromEnd(list1, 2));
//        entity.print(entity.removeNthFromEnd(list2, 1));
//        entity.print(entity.removeNthFromEnd(list3, 1));
//        entity.print(entity.removeNthFromEnd(list4, 2));
        entity.print(entity.removeNthFromEnd2(list1, 2));
        entity.print(entity.removeNthFromEnd2(list2, 1));
        entity.print(entity.removeNthFromEnd2(list3, 1));
        entity.print(entity.removeNthFromEnd2(list4, 2));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = head;
        ListNode r = head;
        int length = 0;
        while (head != null) {
            length = length + 1;
            head = head.next;
        }
        if (n == length) {
            result = result.next;
        } else if (n < length) {
            for (int i = 1; i < length - n; i++) {
                r = r.next;
            }
            r.next = r.next.next;
        }

        return result;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        while (n > 0) {
            fast = fast.next;
            n = n - 1;
        }
        if (fast == null) {
            return head.next;
        } else {
            fast = fast.next;
            while(fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }
        slow.next = slow.next.next;

        return head;
    }

    public class ListNode {
        int val;
        public ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private ListNode gen(int[] numbs) {
        ListNode result = null;
        for (int i = numbs.length - 1; i > -1; i--) {
            result = new ListNode(numbs[i], result);
        }
        return result;
    }

    private void print(ListNode node) {
        System.out.print("[");
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
        System.out.println("]");
    }
}
