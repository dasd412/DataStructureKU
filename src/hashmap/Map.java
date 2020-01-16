package hashmap;

public interface Map<K,V> {

	public int size();
	public boolean isEmpty();
	public V put(K key, V value);
	public V get(K key);
	public V remove(K key);
	public Iterable<K> keySet();
	public Iterable<V> values();
	public Iterable<Entry<K,V>> entrySet();
	
}
