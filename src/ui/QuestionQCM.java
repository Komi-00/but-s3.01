package ui;

import java.util.Scanner;

import file.QuestionReader;

public class QuestionQCM {
    private String enonce ;

    private boolean response ;

    QuestionQCM(){
    	String[] arr = QuestionReader.read("res/questions");
    	this.enonce = arr[0];
    	if(arr[1].equals("t")) {
    		this.response = true;
    	} else {
    		this.response = false;
    	}
    	
    }

    // If bonne reponse return true 
    public boolean poseQuestion(){
        System.out.println(this.enonce + "\n");
        System.out.println("┌──────────┐");
        System.out.println("│ 0 : Faux │");
        System.out.println("│ 1 : Vrai │");
        System.out.println("└──────────┘");
        

        Scanner Obj = new Scanner(System.in);
        String rep = Obj.next();

        boolean response = false;
        while(!rep.startsWith("0") && !rep.startsWith("1")) {
        	InterfaceUI.clear();
        	
            System.out.println( "\033[0;1m" + "\u001B[31m" + "Veuillez repondre 0 ou 1" + "\u001B[37m" + "\033[0;0m");
            System.out.println(this.enonce + "\n");
            System.out.println("┌──────────┐");
            System.out.println("│ 0 : Faux │");
            System.out.println("│ 1 : Vrai │");
            System.out.println("└──────────┘");
            rep = Obj.next();
        }
        int repI = Integer.valueOf(rep);
        if(repI == 0){
            response = false ;
        }else if(repI == 1){
            response = true ;
        }
        return response == this.response;

    }

    public boolean displayQuestion(){
        boolean rep = this.poseQuestion() ;
        if(rep){
            System.out.println("Bonne réponse !");
            pause(1000);
            return true;
            // Ajouter la thunas
        }else{
            System.out.println("Mauvaise réponse");
            pause(1000);
            return false;
        }
    }
    
    public void pause(long duration) {
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
