import java.util.Scanner;

public class MarksEx {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);	
		
		System.out.print("Enter Your Marks: ");
		int marks = scanner.nextInt();
		
		if(marks>85) {
			System.out.println("Excellent, You got A Grade");
		}
		
		else if(marks>75) {
			System.out.println("Very goog, You got B Grade");
		}
		
		else if(marks>55) {
			System.out.println("Good, You got C Grade");
		}
		
		else if(marks>45) {
			System.out.println("Average, You got D Grade");
		}
		
		else if(marks>35) {
			System.out.println("You got E Grade");
		}else {
			System.out.println("Next Time Better Luck, Your Fail.");	
		}
		scanner.close();
	}

}
