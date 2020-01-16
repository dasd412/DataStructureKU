package heap;

public class HeapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Heap<Integer, String>heap=new Heap<>();
		
		Entry<Integer,String>entry1=new Entry<>(32,"ad");
		Entry<Integer,String>entry2=new Entry<>(76,"asdasd");
		Entry<Integer,String>entry3=new Entry<>(34,"aasada");
		Entry<Integer,String>entry4=new Entry<>(42,"asadasda");
		Entry<Integer,String>entry5=new Entry<>(68,"asddhg");
		Entry<Integer,String>entry6=new Entry<>(17,"hgfgj");
		Entry<Integer,String>entry7=new Entry<>(14,"asdad");
		Entry<Integer,String>entry8=new Entry<>(46,"adcvh");
		
		heap.insert(entry1);
		heap.insert(entry2);
		heap.insert(entry3);
		heap.insert(entry4);
		heap.insert(entry5);
		heap.insert(entry6);
		heap.insert(entry7);
		heap.insert(entry8);
		
		heap.print();
		
		
		System.out.println("-----");
		heap.removeMin();

		
		System.out.println(heap.min());
		
		heap.print();
	}
	

}
