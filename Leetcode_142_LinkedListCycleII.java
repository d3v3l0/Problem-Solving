/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 142. Linked List Cycle II
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
 */
public class Leetcode_142_LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if ( fast == slow) break;
        }
        
        if (fast == null || fast.next == null) return null;
        
        slow = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return fast;
    }
}
