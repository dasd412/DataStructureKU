package recursion;

public class Factorial {

	public static int getFac(int number) {
		if(number==0) {
			return 1;
		}
		else {
			return number*getFac(number-1);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(getFac(6));
	}

}
