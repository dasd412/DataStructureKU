package recursion;
import java.util.Scanner;
public class Palindrome {

	private static boolean isPalinedrome;
	
	public static void isPalinedrome(char[]arr, int start, int end) {
		if(start>end) {
			return;
		}
		else if(arr[start]==arr[end]) {
			isPalinedrome=true;
			isPalinedrome(arr,start+1,end-1);
		}
		else {
			isPalinedrome=false;
			return;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		String str=sc.next();
		
		char[]arr=str.toCharArray();
		
		isPalinedrome(arr,0,arr.length-1);
		
		System.out.println("회문인가?::"+" "+isPalinedrome);
		
		sc.close();
	}

}
