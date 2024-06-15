package doWhileLoop.examples;

public class DoWhileLoop {
	
	public static void main(String[] args) {
		
		int count = 1;
		do {
			System.out.println("number of iteration is not fixed and you must have to execute the loop at least once: " + count);
			count++;
		}
		while(count<=6);
	}

}
