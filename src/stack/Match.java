package stack;
import java.util.Scanner;
public class Match {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		Stack<Character> stack=new ArrayStack<Character>(100);
		
		System.out.println("괄호들을 입력하세요.");
		
		String symbolSet=sc.nextLine();
		
		char[]arrays=symbolSet.toCharArray();
		
		for(int i=0;i<arrays.length;i++) {
			if(arrays[i]=='('||arrays[i]=='['||arrays[i]=='{') {
				stack.Push(arrays[i]);
			}
			
			else if(arrays[i]==')') {
				if(stack.top()=='(') {
					stack.pop();
				}
				else {
					break;
				}
			}
			else if(arrays[i]==']') {
				if(stack.top()=='[') {
					stack.pop();
				}
				else {
					break;
				}
			}
			else if(arrays[i]=='}') {
				if(stack.top()=='{') {
					stack.pop();
				}
				else {
					break;
				}
			}
		}
		
		
		if(stack.isEmpty()) {
			System.out.println("괄호들이 짝이 맞습니다.");
		}
		else {
			System.out.println("괄호들이 짝이 맞지 않습니다.");
		}
		
		sc.close();
		
	}

}
