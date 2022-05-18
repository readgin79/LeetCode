package chou.ds;

public interface ListInterface {
	int length();
	Node getNode(int i);
	Node searchNode(int d);
	void insertNode(Node ptr, int d);
	int deleteNode(Node ptr);
}
