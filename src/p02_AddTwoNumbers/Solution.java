package p02_AddTwoNumbers;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode();
        ListNode current = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int value = carry;

            if (l1 != null) {
                value += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }

            if (value >= 10) {
                value -= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            current.next = new ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();


    }
}