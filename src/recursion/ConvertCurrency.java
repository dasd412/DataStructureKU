package recursion;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConvertCurrency {

	private static List<Character> converted;
	
	
	public static void convertCurrency(List<Character>list, int dotPoint) {
		
		if((list.size()>=3&&dotPoint<=0)||list.size()<3) {
			return;
		}
		else if(dotPoint!=list.size()) {
			
			converted.add(dotPoint, ',');
			convertCurrency(list, dotPoint-3);
		}
		else {

			convertCurrency(list, dotPoint-3);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		String strCurrency=sc.next();
		char[]chars=strCurrency.toCharArray();
		List<Character>list=new ArrayList<Character>();
		
	    for(int i=0;i<chars.length;i++) {
	    	list.add(chars[i]);
	    }
		
	    converted=list;
	    
	    convertCurrency(list,list.size());
	    
		for(int i=0;i<converted.size();i++) {
			System.out.print(converted.get(i));
		}
		
		sc.close();
	}

}
