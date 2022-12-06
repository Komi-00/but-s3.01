package ui;

import java.util.Scanner;

public class Shop {
	
	public static boolean open(Player player, Scanner keyboard) {
		boolean res = false;
		
		String input = keyboard.nextLine();
        input = input.toUpperCase();
        if (input.equals("1")) {
        	upgradeAutoclick(player);
        } else if (input.equals("2")) {
        	upgradeLetterB(player);
        }else if (input.equals("3")) {
        	upgradeWordAzerty(player);
        }else if (input.equals("4")) {
        	upgradeWordDactylographie(player);
        }else if (input.equals("5")) {
        	res=true;
        }
        
        
        return res;
	}
	
	public static int computePrice(int level,int startingPrice, double rate) {
		int result = startingPrice;
		for(int i =0;i<level;i++) {
			result = (int) (result*rate);
		}
		return result;
	}
	
	public static int upgradeAutoclick(Player player) {
		int price = computePrice(player.getCurrentGame().getAutoClick(),20,2.3);
		int level = player.getCurrentGame().getAutoClick();
		if(player.getCurrentGame().getCowCoin()<price) {
			return level;
		}else {
			player.decreaseCurrencyAmount(price, Currency.CowCoins);
			level++;
		}
		player.getCurrentGame().setAutoClick(level);
		return level;
	}
	
	public static int upgradeLetterB(Player player) {
		int price = computePrice(player.getCurrentGame().getLetterB(),20,2.3);
		int level = player.getCurrentGame().getLetterB();
		if(player.getCurrentGame().getCowCoin()<price) {
			return level;
		}else {
			player.decreaseCurrencyAmount(price, Currency.CowCoins);
			level++;
		}
		player.getCurrentGame().setLetterB(level);
		return level;
	}
	
	public static int upgradeWordAzerty(Player player) {
		int price = computePrice(player.getCurrentGame().getWordAzerty(),20,2.3);
		int level = player.getCurrentGame().getWordAzerty();
		if(player.getCurrentGame().getCowCoin()<price) {
			return level;
		}else {
			player.decreaseCurrencyAmount(price, Currency.CowCoins);
			level++;
		}
		player.getCurrentGame().setWordAzerty(level);
		return level;
	}
	
	public static int upgradeWordDactylographie(Player player) {
		int price = computePrice(player.getCurrentGame().getWordDactylographie(),20,2.3);
		int level = player.getCurrentGame().getWordDactylographie();
		if(player.getCurrentGame().getCowCoin()<price) {
			return level;
		}else {
			player.decreaseCurrencyAmount(price, Currency.CowCoins);
			level++;
		}
		player.getCurrentGame().setWordDactylographie(level);
		return level;
	}
	
	public static int upgradeBigMult(Player player) {
		int level = player.getBigMult();
		int price = computePrice(level,20,2.3);
		if(player.getResetCurrencyAmount()<price) {
			return level;
		}else {
			player.decreaseCurrencyAmount(price, Currency.ResetCurrency);
			level++;
		}
		player.setBigMult(level);
		return level;
	}
	
	public static int upgradeSoldes(Player player) {
		int level = player.getSoldes();
		int price = computePrice(level,20,2.3);
		if(player.getResetCurrencyAmount()<price) {
			return level;
		}else {
			player.decreaseCurrencyAmount(price, Currency.ResetCurrency);
			level++;
		}
		player.setSoldes(level);
		return level;
	}
}
