import org.w3c.dom.NodeList;

import java.util.*;

public class P23MergeKLists {
    public static void main(String[] args) {
        P23MergeKLists entity = new P23MergeKLists();
        ListNode[] lists1 = new ListNode[] {
            ListNode.gen(new int[]{1,4,5}),
            ListNode.gen(new int[]{1,3,4}),
            ListNode.gen(new int[]{2,6}),
        };
        ListNode[] lists2 = new ListNode[0];
        ListNode[] lists3 = new ListNode[] { null };
        System.out.println();
        ListNode.print(entity.mergeKLists(lists1));
        ListNode.print(entity.mergeKLists(lists2));
        ListNode.print(entity.mergeKLists(lists3));
        System.out.println();
        ListNode.print(entity.mergeKLists2(lists1));
        ListNode.print(entity.mergeKLists2(lists2));
        ListNode.print(entity.mergeKLists2(lists3));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        Map<Integer, Integer> map = new HashMap<>();
        if (lists != null && lists.length > 0) {
            ListNode result = new ListNode();
            ListNode current = result;
            for (ListNode node : lists) {
                while (node != null) {
                    map.put(node.val, map.getOrDefault(node.val, 0) + 1);
                    node = node.next;
                }
            }
            List<Integer> keys = new ArrayList(map.keySet());
            keys.sort(Comparator.comparingInt(a -> a));
            for (Integer key : keys) {
                for (int i = 0; i < map.get(key); i++) {
                    current.next = new ListNode(key);
                    current = current.next;
                }
            }
            return result.next;
        }
        return null;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode result = new ListNode();
        ListNode current = result;

        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        while (!minHeap.isEmpty()) {
            current.next = minHeap.poll();
            current = current.next;
            if (current.next != null) {
                minHeap.offer(current.next);
            }
        }
        return result.next;
    }
}
