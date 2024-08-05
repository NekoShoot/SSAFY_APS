package function_call;

public class Stack_FunctionCcall {

	public static void main(String[] args) {
		System.out.println("main call");

		func1();
		
		System.out.println("main end");
	}
	
	public static void func1() {
		System.out.println("func1 call");
		for(int i = 0; i < 4; i++) {
			func2(i);
		}		
		String name = "Kim";
		System.out.println("func1 end");		
	}
	
	public static void func2(int i) {
		System.out.println(i + " func2 call");

		func3();
		String name = "Lee";
		System.out.println(i + " func2 end");
	}
	
	public static void func3() {
		System.out.println("func3 call");

		
		
		System.out.println("func3 end");
	}

}
