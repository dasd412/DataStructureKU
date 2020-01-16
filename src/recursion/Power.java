package recursion;

public class Power {
	
	public static int power(int number, int pow) {
		if(pow==0) {
			return 1;
		}
		else if(pow%2==1) {
			int x=power(number, pow/2);
			return number*x*x;
		}
		else {
			int x=power(number,pow/2);
			return x*x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(power(2,5));
		System.out.println(power(3,4));
	}

}
