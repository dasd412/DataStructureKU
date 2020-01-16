package dequeue;

public class DQTest {
	public static void main(String[] args) {

        char deletedItem;

        Dequeue<Character> DQ = new Dequeue<Character>();

        DQ.addFirst('A');
        DQ.addFirst('c');
        DQ.addFirst('b');
        DQ.addLast('D');

        DQ.removeLast();
        DQ.viewAll();


       
    }

}
