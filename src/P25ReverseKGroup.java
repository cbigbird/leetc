public class P25ReverseKGroup {
    public static void main(String[] args) {
        P25ReverseKGroup entity = new P25ReverseKGroup();
        ListNode list1 = null;
        ListNode list2 = ListNode.gen(new int[]{1});
        ListNode list3 = ListNode.gen(new int[]{1,2,3,4,5,6,7,8,9});
        System.out.println();
        ListNode.print(entity.reverseKGroup(list1, 1));
        ListNode.print(entity.reverseKGroup(list2, 1));
        ListNode.print(entity.reverseKGroup(list3, 3));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        return null;
    }
}
