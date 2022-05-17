package chou.ds;

public class SinglyLinked extends List {

	public SinglyLinked(int[] array) {
		Node newnode;
		first = null;

		for (int i = 0; i < array.length; i++) {
			newnode = new Node(array[i]);
			newnode.next = first;
			first = newnode;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinked sl = new SinglyLinked(new int[] { 1, 2, 3 });
		sl.printList();
		System.out.println();
		sl.deleteNode(sl.searchNode(1));
		sl.printList();
		System.out.println();
		sl.insertNode(null, 4);
		sl.printList();
		System.out.println();
		sl.insertNode(sl.searchNode(4), 5);
		sl.printList();
		System.out.println();
		sl.insertNode(sl.searchNode(2), 6);
		sl.printList();
	}

	@Override
	boolean isListEmpty() {
		// TODO Auto-generated method stub
		if (first == null)
			return true;
		else
			return false;
	}

	@Override
	void printList() {
		// TODO Auto-generated method stub
		Node current = first;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}
	
	Node searchNode(int d) {
		Node current = first;
		while(current!=null) {
			if(current.data==d)
				return current;
			current = current.next;
		}
		return null;
	}

	int deleteNode(Node ptr) {
		Node current = first;
		int value = ptr.data;
		if (isListEmpty())
			return -1;
		if (ptr == first || ptr == null) {
			first = first.next;
		} else {
			while (current.next != ptr)
				current = current.next;
			if (ptr.next == null)
				current.next = null;
			else
				current.next = ptr.next;

		}
		return value;
	}
	
	void insertNode(Node ptr, int d) {
		Node newnode;
		newnode = new Node(d);
		if(ptr==null) {
			newnode.next = first;
			first = newnode;
		}else {
			if(ptr.next==null) {
				ptr.next = newnode;
				newnode.next=null;
			}else {
				newnode.next=ptr.next;
				ptr.next=newnode;
			}
		}
	}
}
