public class P24SwapPairs {
    public static void main(String[] args) {
        P24SwapPairs entity = new P24SwapPairs();
        ListNode list1 = null;
        ListNode list2 = ListNode.gen(new int[]{1});
        ListNode list3 = ListNode.gen(new int[]{1,2,3,4,5,6,7,8,9});
        System.out.println();
        ListNode.print(entity.swapPairs(list1));
        ListNode.print(entity.swapPairs(list2));
        ListNode.print(entity.swapPairs(list3));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode a = head;
            ListNode b = a.next;
            ListNode c = b.next;
            b.next = a;
            a.next = swapPairs(c);
            return b;
        }
    }
}
