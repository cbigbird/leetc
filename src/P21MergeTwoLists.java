public class P21MergeTwoLists {
    public static void main(String[] args) {
        P21MergeTwoLists entity = new P21MergeTwoLists();
        System.out.println();
        entity.print(entity.mergeTwoLists(entity.gen(new int[]{1,2,3}), entity.gen(new int[]{1,2,4})));
        entity.print(entity.mergeTwoLists(entity.gen(new int[]{1,2,3,10,15,18}), entity.gen(new int[]{1,2,4,11,12,13,15})));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode current = result;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = new ListNode(list1.val);
                current = current.next;
                list1 = list1.next;
            } else {
                current.next = new ListNode(list2.val);
                current = current.next;
                list2 = list2.next;
            }
        }
        ListNode remain = list1 == null ? list2 : list1;
        while (remain != null) {
            current.next = new ListNode(remain.val);
            current = current.next;
            remain = remain.next;
        }
        return result.next;
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
