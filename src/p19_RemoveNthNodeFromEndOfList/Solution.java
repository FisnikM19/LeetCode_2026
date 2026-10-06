package p19_RemoveNthNodeFromEndOfList;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  Definition for singly-linked list.
class ListNode {

      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode node = head;
        int count = 0;

        while (node != null) {
            node = node.next;
            count++;
        }

        if (count == n) {
            return head.next;
        }

        ListNode current = head;

        for (int i = 1; i < count - n; i++) {
            current = current.next;
        }

        current.next = current.next.next;

        return head;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        ListNode dummy = new ListNode();
        ListNode current = dummy;

        for (int i = 0; i < 5; i++) {
            current.next = new ListNode(i+1);
            current = current.next;
        }

        ListNode res = sol.removeNthFromEnd(dummy.next, 2);

        List<Integer> list = new ArrayList<>();

        while (res != null) {
            list.add(res.val);

            res = res.next;
        }

        list.forEach(System.out::print);

    }
}
