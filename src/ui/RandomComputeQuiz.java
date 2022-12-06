package ui;

import java.util.Random;
import java.util.Scanner;

public class RandomComputeQuiz {
	
	private int op1;
	private int op2;
	
	public RandomComputeQuiz() {
		newQuiz();
	}
	
	public void newQuiz() {
		Random rdmGen = new Random();
		this.op1 = rdmGen.nextInt(550);
		this.op2 = rdmGen.nextInt(540);
	}
	
	public boolean playQuiz() {
		Scanner sc = new Scanner(System.in);
		int nmb;
		System.out.println(op1 + " + " + op2 + " = ");
		while(!sc.hasNextInt()) {
			InterfaceUI.clear();
			System.out.println(op1 + " + " + op2 + " = ");
			System.out.println("\nEntrez un nombre.");
			sc.next();
		}
		nmb = sc.nextInt();
		int result = this.op1 + this.op2;
		if(nmb == result) {
			return true;
		} else {
			return false;
		}
		
	}
}
