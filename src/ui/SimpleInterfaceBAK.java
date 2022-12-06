package ui;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import file.SaveScore;

public class SimpleInterfaceBAK {
	
	private Player player;
	
	public SimpleInterfaceBAK(Player player) {
		this.player = player;
	}
	
	public void StartGame() {
		
		// GAME INPUT AVAILABILITY SET TO TRUE BY DEFAULT
		GameInput letterA = new GameInput(InputName.A, 1, 1, true);
		GameInput letterB = new GameInput(InputName.B, 2, 1,  true);
		GameInput azerty = new GameInput(InputName.AZERTY, 10, 1, true);
		GameInput dacty = new GameInput(InputName.DACTY, 20, 1,  true);
		
		StatusInput rCurrencyAm = new StatusInput(InputName.RCA);
		StatusInput rank = new StatusInput(InputName.RANK);
		StatusInput shop = new StatusInput(InputName.SHOP);
		StatusInput reset = new StatusInput(InputName.RESET);
		
		MinigameInput mg1;
		
		long tpinitial=System.currentTimeMillis();
		long tpfinal;
		
		long rdmTpsInit = System.currentTimeMillis();
		long rdmTpsEnd;
		long rdmTpsTotal;
		
        boolean flag = true;
        boolean rdmWordFlag = false;
        String rndWordAnswer = "";
        Random rdm = new Random();
        RandomComputeQuiz rdmQ = new RandomComputeQuiz();
        Scanner keyboard = new Scanner(System.in);

        while (flag) {
            
        	letterB.setMultiplier(player.getCurrentGame().getLetterB());
        	azerty.setMultiplier(player.getCurrentGame().getWordAzerty());
        	dacty.setMultiplier(player.getCurrentGame().getWordDactylographie());
        	
        	
    		tpinitial=System.currentTimeMillis();
    		
        	InterfaceUI.clear();
        	InterfaceUI.display(player);
        	if(rdm.nextInt(10) == 0) {
        		rdmTpsInit=System.currentTimeMillis();
        		InterfaceUI.clear();
            	rndWordAnswer = RdmInterfaceUI.display(player);
            	rdmWordFlag = true;
            	
        	}
        	
            String input = keyboard.nextLine().toUpperCase();
            
            // GAME INPUT PART
            if (input.equals(letterA.getCommand())) {

            	player.increaseCurrencyAmount(letterA.getComputedValue(), Currency.CowCoins);
            } else if (input.equals(letterB.getCommand())) {
            	System.out.println("Done !");
            	player.increaseCurrencyAmount(letterB.getComputedValue(), Currency.CowCoins);
            } else if (input.equals(azerty.getCommand())) {
            	System.out.println("Done !");
            	player.increaseCurrencyAmount(azerty.getComputedValue(), Currency.CowCoins);
            } else if (input.equals(dacty.getCommand())) {
            	System.out.println("Done !");
                player.increaseCurrencyAmount(dacty.getComputedValue(), Currency.CowCoins);
            } 
            
            // STATUS PART
            else if (input.equals(rCurrencyAm.getCommand())) {
            	rCurrencyAm.displayStatus(player, keyboard);
            } else if (input.equals(rank.getCommand())) {
            	rank.displayStatus(player, keyboard);
            } else if (input.equals(shop.getCommand())){
            	shop.displayStatus(player, keyboard);
            } else if(input.equals(reset.getCommand())) {
            	player = reset.displayStatus(player, keyboard);
	        }else if(input.equals("MOTHERLOAD")) {
	        	player.increaseCurrencyAmount(9999999, Currency.CowCoins);
	        }else if(input.equals("CHEAT")) {
	        	player.increaseCurrencyAmount(9999999, Currency.ResetCurrency);
	        }
            
            // MINIGAME PART
            else if (input.equals("MINIGAME")) {
            	
            	mg1 = new MinigameInput(""+InterfaceUI.displayMinigameMenu(keyboard));
            	mg1.playMinigame(player, rdmQ, keyboard);
            }
	        
	        else if (input.equals("EXIT")) {
                flag = false;
                SaveScore save = new SaveScore(player);
                try {
					save.SaveScoreBoard();
				} catch (IOException e) {
					System.err.println("la sauvegarde des scores n'a pas pus etre effectuer");
				}
                
                try {
					save.saveCurrentPlayerCSV();
				} catch (IOException e) {
					System.err.println("la sauvegarde du player n'a pas pus etre effectuer");
				}
            }
            
            // RANDOM BONUS WORD
	        else if(rdmWordFlag && input.equals(rndWordAnswer.toUpperCase())) {
	        	rdmTpsEnd = System.currentTimeMillis();
	        	rdmTpsTotal = rdmTpsEnd - rdmTpsInit;
	        	try {
	        		if(rdmTpsTotal>3000 || rdmTpsTotal<=0) {
	        			throw new InterruptedException();
	        		}else {
	        			System.out.println("Vous avez mis "+ rdmTpsTotal/1000 +" secondes !");
	        			player.increaseCurrencyAmount(player.getCurrentGame().getCowCoin()/4, Currency.CowCoins);
	        		}
	        		
	        		Thread.sleep(2000);
	        		
        		}catch(InterruptedException ex) {
        			System.out.println("Veuillez répondre en moins de trois secondes.");
        			try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		}
	        }
            
            tpfinal=(System.currentTimeMillis()-tpinitial)/100;
            player.increaseCurrencyAmount((tpfinal * player.getCurrentGame().getAutoClick()), Currency.CowCoins);
            rdmWordFlag = false;
	        }

        keyboard.close();
	}
}
