package priortyQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HeapPriortyQueue<K,V> extends AbstractPriortyQueue<K,V>{

	//힙구조로 담는 리스트.
	private List<Entry<K,V>>heapList=new ArrayList<Entry<K,V>>();
	
	//생성자
	public HeapPriortyQueue() {
		super();
	}
	
	public HeapPriortyQueue(Comparator<K> comp) {
		super(comp);
	}
	//힙용 메서드
	protected int parent(int j) {
		return (j-1)/2;
	}
	
	protected int left(int j) {
		return 2*j+1;
	}
	
	protected int right(int j) {
		return 2*j+2;
	}
	
	protected boolean hasLeft(int j) {
		return left(j)<heapList.size();
	}
	
	protected boolean hasRight(int j) {
		return right(j)<heapList.size();
	}
	
	protected void swap(int i, int j) {
		Entry<K,V>temp=heapList.get(i);
		heapList.set(i, heapList.get(j));
		heapList.set(j, temp);
	}
	
	protected void upheap(int j) {
		while(j>0) {
			int p=parent(j);
			if(compare(heapList.get(j).getKey(),heapList.get(p).getKey())>=0) {
				break;
			}
			swap(j,p);
			j=p;
		}
	}
	
	protected void downHeap(int j) {
		while(hasLeft(j)) {
			int leftIndex=left(j);
			int smallChildIndex=leftIndex;
			if(hasRight(j)) {
				int rightIndex=right(j);
				if(compare(heapList.get(leftIndex).getKey(),heapList.get(rightIndex).getKey())>0) {
					smallChildIndex=rightIndex;
				}
				if(compare(heapList.get(smallChildIndex).getKey(),heapList.get(j).getKey())>=0) {
					break;
				}
				swap(j,smallChildIndex);
				j=smallChildIndex;
			}
		}
	}
	//메서드

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return heapList.size();
	}

	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		checkKey(key);
		Entry<K,V>newest=new PQentry<K,V>(key, value);
		heapList.add(newest);
		upheap(heapList.size()-1);
		
		return newest;
	}

	@Override
	public Entry<K, V> min() {
		// TODO Auto-generated method stub
		if(heapList.size()==0) {
			return null;
		}
		return heapList.get(0);
	}

	@Override
	public Entry<K, V> removeMin() {
		// TODO Auto-generated method stub
		if(heapList.isEmpty()) {
			return null;
		}
		Entry<K,V>removed=heapList.get(0);
		swap(0,heapList.size()-1);
		heapList.remove(heapList.size()-1);
		downHeap(0);
	
		return removed;
	}
	
	
}
