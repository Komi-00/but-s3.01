package ui;

import java.io.IOException;
import java.util.Scanner;

import file.SaveScore;

public class StatusInput  extends InputGlobal implements InputProperty{

	
	public StatusInput(InputName command) {
		super(command, true);
	}
	
	@Override
	public boolean isGameCommand() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isMinigame() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isStatusCommand() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setAvailability(boolean yn) {
		this.isAvailable = yn;
	}
	
	@Override
	public boolean isAvailable() {
		// TODO Auto-generated method stub
		return this.isAvailable;
	}

	@Override
	public String getCommand() {
		return this.command.toString();
	}
	
	public Player displayStatus(Player player, Scanner keyboard) {
		if(this.getCommand().equals("RCA")) {
			System.out.println("Vous avez " + player.getResetCurrencyAmount() + " ResetCurrency !");
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(this.getCommand().equals("RANK")) {
			SaveScore save = new SaveScore(player);
            try {
				save.SaveScoreBoard();
			} catch (IOException e) {
				System.err.println("la sauvegarde des scores n'a pas pus etre effectuer");
			}
            
            System.out.println("save effectuer");
			
            InterfaceUI.clear();
        	InterfaceUI.displayRank();
            keyboard.nextLine();
		} else if(this.getCommand().equals("M")) {
			InterfaceUI.clear();
        	InterfaceUI.displayShop(player);
        	Shop.open(player, keyboard);
		} else if(this.getCommand().equals("RESET")) {
			String input;
			long gain = (player.getCurrentGame().getCowCoin()/100);
        	long resetCurrency = player.getResetCurrencyAmount()+gain;
        	InterfaceUI.displayReset(player, gain);
        	input = keyboard.nextLine().toUpperCase();
        	if(input.equals("Y")) {
        		player = new Player(player.getUsername(),resetCurrency,player.getTotalCowCoinsAmount(),player.getBigMult());
        		boolean flag=true;
        		while(flag) {
        			InterfaceUI.displayShopReset(player);
        			input = keyboard.nextLine();
        			if(input.equals("4")) {
        				flag=false;
        			}else if(input.equals("1")) {
        				Shop.upgradeBigMult(player);
        			}else if(input.equals("2")) {
        				Shop.upgradeSoldes(player);
        			}else if(input.equals("3")) {
        				System.out.println("https://youtu.be/dQw4w9WgXcQ");
        	        	keyboard.nextLine();
        			}
        		}
        	}
		}

		return player;
	}

}
