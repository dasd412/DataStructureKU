package queue;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str="abcdefghijklmnopqrstuvwxyz";
		
		//1
		Queue<Character> q1=new CircularQueue<Character>(100);
		for(int i=0;i<str.length();i++) {
			try {
				q1.enqueue(str.charAt(i));
			} catch (FullQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i=0;i<str.length();i++) {
			try {
				System.out.println(q1.dequeue());
			} catch (EmptyQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
