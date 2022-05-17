package chou.pr;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(7);
		
		AddTwoNumbers_Solution solution = new AddTwoNumbers_Solution();
		ListNode ans = solution.addTwoNumbers(l1, l2);
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

class AddTwoNumbers_Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode ans;
    	
    	int a1 = l1.val + l2.val; 
    	
    	if(a1>9) {
    		ans = new ListNode(a1-10);
    		ans.next = new ListNode(l1.next.val + l2.next.val + 1);
    	}else {
    		ans = new ListNode(a1);
    		ans.next = new ListNode(l1.next.val + l2.next.val); 
    	}
    	
    	
    	
		return l2;
    }
}
