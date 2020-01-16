package priortyQueue;

import java.util.Comparator;

public abstract class AbstractPriortyQueue<K,V> implements PriortyQueue<K,V> {

	//내부 클래스 
	protected static class PQentry<K,V>implements Entry<K,V>{

		private K key;
		private V value;
		
		public PQentry(K k, V v){
			this.key=k;
			this.value=v;
		}
		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return this.key;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return this.value;
		}
		
		public void setKey(K k) {
			this.key=k;
		}
		
		public void setValue(V v) {
			this.value=v;
		}
		//게터, 세터
	}//내부 클래스 끝
	
	private Comparator<K> comp;//순서 정하기용 멤버변수
	
	//생성자
	protected AbstractPriortyQueue(Comparator<K> c) {
		this.comp=c;
	}
	
	protected AbstractPriortyQueue() {
		this(new DefaultComparator<K>());
	}
	
	//메소드
	protected int compare(K k, K k2) {
		return comp.compare(k,k2);
	}
	
	protected boolean checkKey(K key)throws IllegalArgumentException {
		try {
			return comp.compare(key, key)==0;
		}catch(ClassCastException e) {
			throw new IllegalArgumentException("Incompatible key");
		}
	}
	
	public boolean isEmpty() {
		return getSize()==0;
	}
	
	
}//클래스 끝
