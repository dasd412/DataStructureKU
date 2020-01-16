package priortyQueue;

import java.util.Comparator;

public class StringLengthComparator implements Comparator<String>{

	@Override
	public int compare(String a, String b) {
		// TODO Auto-generated method stub
		if(a.length()<b.length()) {
			return -1;
		}
		else if(a.length()==b.length()) {
			return 0;
		}
		else return 1;
	}

}
