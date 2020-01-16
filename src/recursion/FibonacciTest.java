package recursion;

public class FibonacciTest {

	public static void getFibo(Fibonacci fibo, int number) {
		if(number==1) {
			System.out.print(fibo.first+" "+fibo.second+" ");
			return;
		}
		else {
	    getFibo(fibo,number-1);
	    int temp=fibo.first;
	    fibo.first=fibo.second;
	    fibo.second+=temp;
	    System.out.print(fibo.second+" ");
	   
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Fibonacci fibo=new Fibonacci();
		getFibo(fibo, 12);
		
	}

}
