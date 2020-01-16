package priortyQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UnsortedPriortyQueue<K,V> extends AbstractPriortyQueue<K,V>{

	//Entry들 담기용 리스트.
	private List<Entry<K,V>>list=new ArrayList<Entry<K,V>>();
	
	//생성자
	public UnsortedPriortyQueue() {
		super();
	}
	
	public UnsortedPriortyQueue(Comparator<K> comp) {
		super(comp);
	}

	//메소드
	public Entry<K,V> findMin(){
		Entry<K,V>min= list.get(0);
		for(Entry<K, V> iterator:list) {
			if(compare(iterator.getKey(),min.getKey())<0) {
				min=iterator;
			}
		}
		return min;
		
	}

	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		checkKey(key);
		Entry<K,V>newest=new PQentry<K,V>(key, value);
		list.add(newest);
		return newest;
	}

	@Override
	public Entry<K, V> min() {
		// TODO Auto-generated method stub
		if(list.isEmpty()) {
			return null;
		}
		return findMin();
	}

	@Override
	public Entry<K, V> removeMin() {
		// TODO Auto-generated method stub
		if(list.isEmpty()) {
			return null;
		}
		Entry<K,V> removed=findMin();
		list.remove(findMin());
		return removed; 
	}
	
	
}//클래스 끝
