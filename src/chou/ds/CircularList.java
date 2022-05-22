package chou.ds;

public class CircularList extends List implements ListInterface {

	public CircularList(int[] array) {
		Node last = first;	
		Node newnode;
		for(int i=0; i<array.length; i++) {
			newnode = new Node(array[i]);
			if(i==0) {
				last = newnode;
			}
			newnode.next = first;
			first = newnode;
		}
		last.next = first;
	}
	
	@Override
	boolean isListEmpty() {
		if(first==null) return false;
		else return false;
	}

	@Override
	void printList() {
		Node current = first;
		do {
			System.out.print(current.data + " ");
			current = current.next;
		}while(current!=first);
		System.out.println();
	}

	public static void main(String[] args) {
		CircularList cl = new CircularList(new int[] { 1, 2, 3 });
		cl.printList();
		cl.insertNode(cl.searchNode(4), 4);
		cl.printList();
		cl.insertNode(cl.searchNode(4), 5);
		cl.printList();
		cl.deleteNode(cl.searchNode(4));
		cl.printList();
		cl.deleteNode(cl.searchNode(2));
		cl.printList();
	}

	@Override
	public int length() {
		Node current = first;
		int count =0;
		if(!isListEmpty()) {
			do {
				count++;
				current = current.next;
			}while(current!=first);
		}
		
		return count;
	}

	@Override
	public Node getNode(int i) {
		Node current = first;
		int count =1;
		while (count < i) {
			current = current.next;
			count++;
		}
		
		return current;
	}

	@Override
	public Node searchNode(int d) {
		/*Node current = first;
		if(!isListEmpty()) {
			do {
				if(current.data==d) {
					return current;
				}
				current = current.next;
			}while(current!=first);
		}
		return null;*/
		Node current = first;
		do {
			if (current.data == d)
				return current;
			current = current.next;
		} while (current != first && first != first.next);
		return null;  
	}

	@Override
	public void insertNode(Node ptr, int d) {
		Node previous, newnode;
		newnode = new Node(d);
		if(isListEmpty()) {
			first = newnode;
			first.next = newnode;
		}
		if(ptr==null){
			newnode.next = first;
			previous = first;
			while(previous.next!=first) {
				previous = previous.next;
			}
			previous.next = newnode;
			first = newnode;
		}else {
			 newnode.next = ptr.next;
			 ptr.next = newnode;  
		}
	}

	@Override
	public int deleteNode(Node ptr) {
	      Node previous;
	      int value = ptr.data;
	      if ( isListEmpty() ) return -1;
	      previous = first;
	      if ( first != first.next )
	         while ( previous.next != ptr )
	           previous = previous.next;
	      if ( ptr == first ) {
	         first = first.next;
	         previous.next = ptr.next;
	      }
	      else
	         previous.next = ptr.next;
	      return value;
	}

}
