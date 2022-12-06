package ui ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import file.LoadScore;


public class InterfaceUI{

    

    public static void display(Player player){
                
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

        System.out.println("┌────────────────────────────────┬─────────────────────┐");
        System.out.println("│ Nom : "+ username +"     │ M: Shop             │");
        System.out.println("│                                │ minigame : Mini-jeu │");
        System.out.println("│ CowCoins 💩 : "+ money +"│ reset : Recommencer │");
        System.out.println("│                                │ rank : Classement   │");
        System.out.println("│ "+ isAutoclick +"│ exit : Quitter      │");
        System.out.println("└────────────────────────────────┴─────────────────────┘");
        System.out.println();
        System.out.println("Saisie : ");



    }
    
    public static void displayReset(Player player,long gain){
        
        
        String solde = format(gain+"",14);
       
        
        System.out.println("┌───────────────────────────────────┬────────────────┐");
        System.out.println("│ Gain potentiel de ResetCoin:      │ "+solde+" │");
        System.out.println("└───────────────────────────────────┴─────────[Y/N]──┘");



        System.out.println();
        System.out.println("Saisie : ");



    }
    
 public static void displayShopReset(Player player){
	 
	 	String mult = format(player.getBigMult()+"",8);
	 	String prixMult=format(Shop.computePrice(player.getBigMult(), 20, 3)+"",20);
	 	
	 	
	 	String soldes = format(player.getSoldes()+"",10);
	 	String prixSoldes=format(Shop.computePrice(player.getSoldes(), 20, 3)+"",20);
	 	
	 	String solde = format(player.getResetCurrencyAmount()+"",14);
        
        System.out.println("┌───────────────────────────────────────┬─────────────────────┬────────────────────────┐");
        System.out.println("│ "+ "\033[0;1m" +  "\u001B[32m" +"Upgrades    "+ "\u001B[m" + "\033[0;0m" +"                          │ "+ "\033[0;1m" +  "\u001B[32m" +"Prix"+ "\u001B[m" + "\033[0;0m" +"                │ "+ "\033[0;1m" +  "\u001B[32m" +"Solde"+ "\u001B[m" + "\033[0;0m" +" : "+solde+" │");
        System.out.println("├───────────────────────────────────────┼─────────────────────┼────────────────────────┘");
        System.out.println("│ "+ "\033[0;1m" +  "\u001B[32m" +"1:"+ "\u001B[m" + "\033[0;0m" +" Multiplicateur : Lvl "+mult+"      │ "+prixMult+"│");
        System.out.println("│ "+ "\033[0;1m" +  "\u001B[32m" +"2:"+ "\u001B[m" + "\033[0;0m" +" Soldes : Lvl "+soldes+"            │ "+prixSoldes+"│");						  
        System.out.println("│ "+ "\033[0;1m" +  "\u001B[32m" +"3:"+ "\u001B[m" + "\033[0;0m" +" Mega Compétence Spéciale : Lvl 0   │ "+999999+"              │");
        System.out.println("│ "+ "\033[0;1m" +  "\u001B[32m" +"4:"+ "\u001B[m" + "\033[0;0m" +" Exit                               │                     │");
        System.out.println("└───────────────────────────────────────┴─────────────────────┘");


        System.out.println();
        System.out.println("Saisie : ");



    }

    public static void displayRank(){
        System.out.println("┌──────────────────────────┬──────────────────────┬─────────────────────┬─────────────────────┬─────────────────────────────┐");
        System.out.println("│           " + "\033[0;1m" +  "\u001B[32m" +"Nom" + "\u001B[m" + "\033[0;0m"+"            │       " + "\033[0;1m" +  "\u001B[32m" +"CowCoins" + "\u001B[m" + "\033[0;0m"+"       │       " + "\033[0;1m" +  "\u001B[32m" +"Valeur B" + "\u001B[m" + "\033[0;0m"+"      │    " + "\033[0;1m" +  "\u001B[32m" +"Valeur Azerty" + "\u001B[m" + "\033[0;0m"+"    │    " + "\033[0;1m" +  "\u001B[32m" +"Valeur Dactylographie" + "\u001B[m" + "\033[0;0m"+"    │");
        System.out.println("├──────────────────────────┼──────────────────────┼─────────────────────┼─────────────────────┼─────────────────────────────┤");

        ArrayList<String[]> tmp = LoadScore.getScore();

        Collections.sort(tmp,new Comparator<String[]>() {
            public int compare(String[] strings, String[] otherStrings) {
                return Integer.parseInt(strings[1]) - Integer.parseInt(otherStrings[1]);
            }
        });
        ArrayList<String[]> ranked = new ArrayList<String[]>();
        for (String[] sa : tmp) {
            ranked.add(sa);
        }
        Collections.reverse(ranked);
        for(int i=0;i<ranked.size();i++){

            
            String name = format(ranked.get(i)[0], 25);
            String cow = format(ranked.get(i)[1], 20);
            String valueB = format(ranked.get(i)[2], 20);
            String valueAzerty = format(ranked.get(i)[3], 20);
            String ValueDacty = format(ranked.get(i)[4], 28);

            name = "\033[0;1m" + "\u001B[34m" + name + "\u001B[m" + "\033[0;0m" ;


            System.out.println("│ "+ name +"│ "+ cow +" │ "+ valueB +"│ "+ valueAzerty +"│ " + ValueDacty +"│");

            if(i != ranked.size() -1){
                System.out.println("├──────────────────────────┼──────────────────────┼─────────────────────┼─────────────────────┼─────────────────────────────┤");
            }else{
                System.out.println("└──────────────────────────┴──────────────────────┴─────────────────────┴─────────────────────┴─────────────────────────────┘");

            }
        }


    }
    
    
    public static void displayShop(Player player){
        
        
        String prixAutoClick = format(""+Shop.computePrice(player.getCurrentGame().getAutoClick(), 20, 2.3),20);
        String autoClick = format(player.getCurrentGame().getAutoClick()+"",3);
        
        String prixLetterB = format(""+Shop.computePrice(player.getCurrentGame().getLetterB(), 20, 2.3),20);
        String letterB = format(player.getCurrentGame().getLetterB()+"",3);
        		
        String prixWordAzerty = format(""+Shop.computePrice(player.getCurrentGame().getWordAzerty(), 20, 2.3),20);
        String wordAzerty = format(""+player.getCurrentGame().getWordAzerty(),3);
        
        String prixWordDactylographie= format(""+Shop.computePrice(player.getCurrentGame().getWordDactylographie(), 20, 2.3),20); 
        String wordDactylographie = format(""+player.getCurrentGame().getWordDactylographie(),3);
        
        String solde = format(player.getCurrentGame().getCowCoin()+"",14);

        long m = Double.valueOf(player.getCurrentGame().getCowCoin()).longValue() ;
        // long m = 0L ;
        String money = Long.toString(m);
        money = format(money, 20);
       
        
        System.out.println("┌───────────────────────────────────┬─────────────────────┬────────────────────────┐");
        System.out.println("│ "+ "\033[0;1m" +  "\u001B[32m" +"Upgrades"+ "\u001B[m" + "\033[0;0m" +"                          │ "+ "\033[0;1m" +  "\u001B[32m" +"Prix"+ "\u001B[m" + "\033[0;0m" +"                │ "+ "\033[0;1m" +  "\u001B[32m" +"Solde"+ "\u001B[m" + "\033[0;0m" +" : "+solde+" │");
        System.out.println("├───────────────────────────────────┼─────────────────────┼────────────────────────┘");
        System.out.println("│ "+ "\033[0;1m" +  "\u001B[32m" +"1:"+ "\u001B[m" + "\033[0;0m" +" Autoclick : Lvl "+autoClick+"            │ "+prixAutoClick+"│");
        System.out.println("│ "+ "\033[0;1m" +  "\u001B[32m" +"2:"+ "\u001B[m" + "\033[0;0m" +" Lettre B : Lvl "+letterB+"             │ "+prixLetterB+"│");						  
        System.out.println("│ "+ "\033[0;1m" +  "\u001B[32m" +"3:"+ "\u001B[m" + "\033[0;0m" +" Mot Azerty : Lvl "+wordAzerty+"           │ "+prixWordAzerty+"│");
        System.out.println("│ "+ "\033[0;1m" +  "\u001B[32m" +"4:"+ "\u001B[m" + "\033[0;0m" +" Mot Dactylographie : Lvl "+wordDactylographie+"   │ "+prixWordDactylographie+"│");
        System.out.println("│ "+ "\033[0;1m" +  "\u001B[32m" +"5:"+ "\u001B[m" + "\033[0;0m" +" Exit                           │                     │");
        System.out.println("└───────────────────────────────────┴─────────────────────┘");

        System.out.println();
        System.out.println("Saisie : ");



    }

    public static int displayMinigameMenu(Scanner keyboard){
        
        
        String key = "" ;
        do {
            clear();
            System.out.println("┌─────┬─────────────────────┐");
            System.out.println("│  1: │         QCM         │");
            System.out.println("│  2: │  5 secondes chrono  │");
            System.out.println("│  3: │    Calcul mental    │");
            System.out.println("└─────┴─────────────────────┘");
            System.out.println();
            System.out.println("Saisie : ");
            key = keyboard.next();
        } while (!key.equals("1") && !key.equals("2") && !key.equals("3"));
        
        return Integer.parseInt(key);

    
    }

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


    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }




 

}