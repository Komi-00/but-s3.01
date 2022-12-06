package ui;

import java.util.Scanner;

public class MinigameInput  extends InputGlobal implements InputProperty{

	private String minigame;
	private int value;
	
	public MinigameInput(String minigameNbr) {
		super(InputName.MINIGAME, true);
		this.minigame = command.toString() + minigameNbr;
		this.value = 100*Integer.parseInt(minigameNbr);
	}

	@Override
	public boolean isGameCommand() {
		return false;
	}

	@Override
	public boolean isStatusCommand() {
		return false;
	}

	@Override
	public boolean isMinigame() {
		return true;
	}

	@Override
	public boolean isAvailable() {
		return this.isAvailable;
	}
	
	public void setAvailability(boolean available) {
		this.isAvailable = available;
	}

	@Override
	public String getCommand() {
		return this.command.toString();
	}
	
	public String getMinigame() {
		return this.minigame;
	}
	
	public int getValue() {
		return this.getValue();
	}
	
	public void playMinigame(Player player, RandomComputeQuiz rdmQ, Scanner keyboard) {
		if(this.minigame.equals("MINIGAME3")) {
			rdmQ.newQuiz();
        	if(rdmQ.playQuiz()) {
        		player.increaseCurrencyAmount(this.value * 1,Currency.CowCoins);
        		System.out.println("Bonne réponse.");
        	}else {
        		System.out.println("Mauvaise réponse.");
        	}
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(this.minigame.equals("MINIGAME2")) {
			long minijeu;
			
			System.out.println("Vous devez vous rapprochez le plus possible de 5 secondes après l'apparition du 0.");
        	try {
        		Scanner kd = new Scanner(System.in);
        		Thread.sleep(3000);
        		System.out.println("3");
        		Thread.sleep(1000);
        		System.out.println("2");
        		Thread.sleep(1000);
        		System.out.println("1");
        		Thread.sleep(1000);
        		System.out.println("0");
        		minijeu=System.currentTimeMillis();
        		
        		kd.nextLine();
        		minijeu=System.currentTimeMillis()-minijeu;


        		if(minijeu>5000 || minijeu<=0) {
        			throw new InterruptedException();
        			
        		}else {
        			System.out.println("Vous avez mis "+ minijeu/1000 +" secondes donc le minijeu vous a rapporté "+(minijeu/100)*5+" Cow Coins !");
        			player.increaseCurrencyAmount((minijeu/100)*5,Currency.CowCoins);
        		}
        		
        		Thread.sleep(2000);
        	}catch(InterruptedException ex) {
        		System.out.println("Minijeu annulé veuillez bien mettre jusqu'à 5 secondes maximum.");
        		
        	}
		} else if(this.minigame.equals("MINIGAME1")) {
			QuestionQCM q1 = new QuestionQCM();

            if(q1.displayQuestion()) {
            	player.increaseCurrencyAmount(this.value, Currency.CowCoins);
            }
		}
	}

}
