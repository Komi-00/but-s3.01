package file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import ui.Player;
import ui.Playing;

public class LoadScore {
	// CSV STRUCT
	// name Player; getTotalCowCoinsAmount; getResetCurrencyAmount; getAutoClick; getCowCoin; getLetterB; getWordAzerty; getWordDactylographie; getBigMult; getSoldes
	
	public static Player loadGame(String name) {
		Player result = new Player();
		Playing currentGame = new Playing();
		String[] dataPlayer = null;
		
		try (BufferedReader br = Files.newBufferedReader(Paths.get("res/save/"+name+".csv"))) {
		    // CSV file delimiter
		    String DELIMITER = ";";

		    // read the file line by line
		    String line;
		    while ((line = br.readLine()) != null) {

		    	dataPlayer = line.split(DELIMITER);

		    }

		} catch (IOException ex) {
		    
		}
		
		result.setUsername(dataPlayer[0]);
		result.setTotalCowCoinsAmount(Long.parseLong(dataPlayer[1]));
		result.setResetCurrencyAmount(Long.parseLong(dataPlayer[2]));
		currentGame.setAutoClick(Integer.parseInt(dataPlayer[3]));
		currentGame.setCowCoin(Integer.parseInt(dataPlayer[4]));
		currentGame.setLetterB(Integer.parseInt(dataPlayer[5]));
		currentGame.setWordAzerty(Integer.parseInt(dataPlayer[6]));
		currentGame.setWordDactylographie(Integer.parseInt(dataPlayer[7]));
		result.setBigMult(Integer.parseInt(dataPlayer[8]));
		result.setSoldes(Integer.parseInt(dataPlayer[9]));
		result.setCurrentGame(currentGame);
		return result;
	}
	
	public static ArrayList<String[]> getScore(){
		ArrayList<String[]> savedScore = new ArrayList<String[]>();
		String[] dataScore = null;
		
		try (BufferedReader br = Files.newBufferedReader(Paths.get("res/score.csv"))) {
		    String DELIMITER = ";";
		    String line;
		    while ((line = br.readLine()) != null) {
		    	dataScore = line.split(DELIMITER);
		    	savedScore.add(dataScore);
		    }
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		
		return savedScore;
	}
	
	
	public static void testaffichegetscore(ArrayList<String[]> oui) {
		
		for (String[] s : oui) {
            System.out.println(s[0] + "\t" + s[1] + "\t" + s[2] + "\t" + s[3] + "\t" + s[4]);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		Player p2 = loadGame("oui");
		System.out.println(p2.getUsername() + p2.getResetCurrencyAmount());
	}
	
}
