package Arrays.NonStriverQuestions;

import java.util.*;

public class Reverse_Nodes_in_Even_Length_Groups_2074 {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode prev = head;
        int groupSize = 2;

        while (prev != null && prev.next != null) {
            ListNode start = prev.next;
            ListNode end = start;
            int count = 1;

            while (count < groupSize && end.next != null) {
                end = end.next;
                count++;
            }

            if ((count & 1) == 0) {
                ListNode next = end.next;
                ListNode p = next;
                ListNode curr = start;

                while (curr != next) {
                    ListNode temp = curr.next;
                    curr.next = p;
                    p = curr;
                    curr = temp;
                }

                prev.next = end;
                prev = start;
            } else {
                prev = end;
            }

            groupSize++;
        }

        return head;
    }
}
