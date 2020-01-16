package hashtable;

public class TestForHashT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashTable table=new HashTable(5);
		table.put("1234", "val");
		table.put("5674", "gfh");
		table.put("8797", "jgyh");
		table.put("1224", "vsl");
		table.put("1562", "vdd");
		
		table.print();
		
		table.put("6765", "hggf");
		table.put("5793", "fdcv");
		table.put("2672", "sdfs");
		table.put("1567", "vbn");
		table.put("1556", "vqrt");
		table.put("1131", "vdfh");
		
		table.print();
		
	}

}
