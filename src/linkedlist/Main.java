package linkedlist;

public class Main {
public static void main(String[] args) {
	DoublelyLinkedList<Integer> list=new DoublelyLinkedList<Integer>();
	
	
	list.addFirst(5);
	list.addFirst(2);
	list.addLast(7);
	list.addLast(421);
	list.addFirst(4);
	list.removeLast();
	list.viewAll();
    
}
}
