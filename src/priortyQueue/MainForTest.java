package priortyQueue;

public class MainForTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//정렬되지 않은 리스트로 담은 우선순위 큐
		UnsortedPriortyQueue<Integer, String> upq=new UnsortedPriortyQueue <Integer, String>();
		upq.insert(4, "@");
		upq.insert(7, "*");
		upq.insert(2, "^");
		upq.insert(12, "-");
		upq.removeMin();
		Entry<Integer,String>entry=upq.findMin();
		System.out.println(entry.getKey());
		System.out.println(entry.getValue());
		System.out.println(upq.min().getKey());
		System.out.println(upq.min().getValue());
		
//정렬된 리스트로 담은 우선순위 큐	
		SortedPriortyQueue<Integer,String>spq=new SortedPriortyQueue<Integer,String>();
		spq.insert(13, "+");
		spq.insert(5, "|");
		spq.insert(9, ":");
		spq.insert(17, ",");
		System.out.println(spq.min().getKey()+" "+spq.min().getValue());
		spq.removeMin();
		System.out.println(spq.min().getKey()+" "+spq.min().getValue());
		
//힙으로 담은 우선순위 큐
		HeapPriortyQueue<Integer,String> hpq=new HeapPriortyQueue<Integer,String>();
		hpq.insert(3, ";");
		hpq.insert(9, "&");
		hpq.insert(0, "#");
		hpq.insert(8, "~");
        System.out.println(hpq.min().getKey()+" "+hpq.min().getValue());
        hpq.removeMin();
        System.out.println(hpq.min().getKey()+" "+hpq.min().getValue());
        
	}

}
