package ui;

import java.util.ArrayList;
import java.util.Random;

public class RdmInterfaceUI {
	
	public static String format(String word, int toSize){
        if(word.length() > toSize){
            word = word.substring(0, toSize - 1);
            word += "…";
        }else{
            for(int i=word.length();i<toSize;i++){
                word += " " ;
            }
            
        }

        return word ;
    }
	
	public static String rndWord() {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Intelligent");
		al.add("Original");
		al.add("Anticonstitutionnellement");
		al.add("Socialisme");
		al.add("Amenagement");
		al.add("Changement");
		Random rnd = new Random();
		return al.get(rnd.nextInt(al.size()));
	}
	
	public static String display(Player player){
        
        String username = "\033[0;1m" +  "\u001B[32m" + format(player.getUsername(), 20) + "\033[0;0m";
        


        long m = Double.valueOf(player.getCurrentGame().getCowCoin()).longValue() ;
        // long m = 0L ;
        String money = Long.toString(m);
        money = format(money, 17);
       
        String isAutoclick ;
        if(player.getCurrentGame().getAutoClick() != 0){
            isAutoclick = "\033[0;1m" +  "\u001B[32m" + format("AutoClick niveau : " + player.getCurrentGame().getAutoClick(), 31) + "\u001B[m" + "\033[0;0m";
        }else{
            isAutoclick = format("", 31);
        }
        
        String rndWord = rndWord();
        String rng = "\033[0;1m" +  "\u001B[32m" + format("Mot secret :" + rndWord, 31) + "\u001B[m" + "\033[0;0m";

        System.out.println("┌────────────────────────────────┬─────────────────────┐");
        System.out.println("│ Nom : "+ username +"     │ M: Shop             │");
        System.out.println("│                                │ minigame : Mini-jeu │");
        System.out.println("│ CowCoins 💩 : "+ money +"│ reset : Recommencer │");
        System.out.println("│ "+ rng +"│ rank : Classement   │");
        System.out.println("│ "+ isAutoclick +"│ exit : Quitter      │");
        System.out.println("└────────────────────────────────┴─────────────────────┘");
        System.out.println();
        System.out.println("Saisie : ");

        return rndWord;

    }
}
