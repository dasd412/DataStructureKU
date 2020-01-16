package priortyQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortedPriortyQueue<K,V> extends AbstractPriortyQueue<K,V> {

	//요소담는 리스트
	private List<Entry<K,V>> list=new ArrayList<Entry<K,V>>();
	
	//생성자
	public SortedPriortyQueue() {
		super();
	}
	
	public SortedPriortyQueue(Comparator<K> comp) {
		super(comp);
	}

	//메소드들
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		checkKey(key);
		Entry<K,V> newest=new PQentry<K,V>(key, value);
		int i=0;
		for(;i<list.size();i++) {
			if(compare(newest.getKey(),list.get(i).getKey())<0) {
				break;
			}
		}
		list.add(i, newest);
		
		return newest;
	}

	@Override
	public Entry<K, V> min() {
		// TODO Auto-generated method stub
		return this.list.get(0);
	}

	@Override
	public Entry<K, V> removeMin() {
		// TODO Auto-generated method stub
		if(this.list.size()==0) {
			return null;
		}
		Entry<K,V> removed=list.get(0);
		list.remove(0);
		return removed;
	}
	

	
	
}
