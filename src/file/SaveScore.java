package file;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import ui.Player;

public class SaveScore {
	// CSV STRUCT
	// name Player; getTotalCowCoinsAmount; getResetCurrencyAmount; getAutoClick; getCowCoin; getLetterB; getWordAzerty; getWordDactylographie; getBigMult; getSoldes
	private Player player;
	
	public SaveScore(Player player) {
		this.player = player;
	}
	
	public void saveCurrentPlayerCSV() throws IOException {
		String[] dataPlayer = getDataPlayer();
		
		FileWriter csvWriter = new FileWriter("res/save/"+dataPlayer[0]+".csv");

        for (int i = 0; i < dataPlayer.length; i++) {
            csvWriter.append(dataPlayer[i]);
            csvWriter.append(";");
        }
        csvWriter.append("\n");
        csvWriter.flush();
        csvWriter.close();
		
	}
	
	String[] getDataPlayer() {
		String[] result = new String[10];
		result[0] = player.getUsername();
		result[1] = player.getTotalCowCoinsAmount()+"";
		result[2] = player.getResetCurrencyAmount()+"";
		result[3] = player.getCurrentGame().getAutoClick()+"";
		result[4] = player.getCurrentGame().getCowCoin()+"";
		result[5] = player.getCurrentGame().getLetterB()+"";
		result[6] = player.getCurrentGame().getWordAzerty()+"";
		result[7] = player.getCurrentGame().getWordDactylographie()+"";
		result[8] = player.getBigMult()+"";
		result[9] = player.getSoldes()+"";
		
		return result;
		
	}
	
	
	
	public void SaveScoreBoard() throws IOException {
		
		/*lecture des data*/
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
		
		String[] DataCurrent = new String[5];
		DataCurrent[0] = player.getUsername();
		DataCurrent[1] = player.getCurrentGame().getCowCoin()+"";
		DataCurrent[2] = player.getCurrentGame().getLetterB()+"";
		DataCurrent[3] = player.getCurrentGame().getWordAzerty()+"";
		DataCurrent[4] = player.getCurrentGame().getWordDactylographie()+"";
		
		boolean existPas = true;
		
		for (String[] string : savedScore) {
			if(DataCurrent[0].equals(string[0])) {
				string[1] = DataCurrent[1];
				string[2] = DataCurrent[2];
				string[3] = DataCurrent[3];
				string[4] = DataCurrent[4];
				existPas = false;
			}
		}
		
		if(existPas) {
			savedScore.add(DataCurrent);
		}
		
		
		
		/*reecriture des data dans le fichier*/
		FileWriter csvWriter = new FileWriter("res/score.csv");
		

        for (String[] string : savedScore) {
        	for (int i = 0; i < string.length; i++) {
                csvWriter.append(string[i]);
                csvWriter.append(";");
            }
        	csvWriter.append("\n");
		}
        
        csvWriter.flush();
        csvWriter.close();
		
        /*for (int i = 0; i < DataCurrent.length; i++) {
            csvWriter.append(DataCurrent[i]);
            csvWriter.append(";");
        }
        csvWriter.append("\n");*/
	}
	
	public static void main(String[] args) throws IOException {
		Player p2 = LoadScore.loadGame("oui");
		System.out.println(p2.getUsername() + p2.getResetCurrencyAmount());
		
		SaveScore s = new SaveScore(p2);
		s.SaveScoreBoard();
	}
	
}
