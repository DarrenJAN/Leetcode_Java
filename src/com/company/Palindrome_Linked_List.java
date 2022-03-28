package com.company;

public class Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while(head != null)
        {
            stringBuilder.append(head.val);
            head = head.next;
        }
        return check(stringBuilder);
    }

    public boolean check(StringBuilder stringBuilder)
    {
        int l = 0;
        int r = stringBuilder.length()-1;
        while(l < r){
            if(stringBuilder.charAt(l) != stringBuilder.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    //no extra space
    public boolean isPalindrom(ListNode head)
    {
        if(head == null || head.next == null)
            return true;

        ListNode firstHalfEnd = findMid(head);
        ListNode SecondHalfStart = firstHalfEnd.next;

        ListNode SecondHead = reverse(SecondHalfStart);
        ListNode p1 = head;
        ListNode p2 = SecondHead;
        while(p1 != null && p2 != null)
        {
            if(p1.val != p2.val )
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;

    }

    public ListNode findMid(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        if(head == null || head.next == null)
            return head;

        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head)
    {
        ListNode pre = null;
        ListNode cur= head;
        while (cur != null)
        {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
