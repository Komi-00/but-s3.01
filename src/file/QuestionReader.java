package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class QuestionReader {
	
	private static String delimiter = ";";
	
	public static String[] read(String csvFile){
		try {
			FileReader fr = new FileReader(new File(csvFile));
			BufferedReader br = new BufferedReader(fr);
			int maxLine = 11;
			String line = "";
			String[] strArray;
			Random maxRng = new Random();
			for(int i = 0; i < (maxRng.nextInt(maxLine-1)+1); i++) {
				line = br.readLine();
			}
			strArray = line.split(delimiter);
			br.close();
			return strArray;
		} catch (IOException excp){
			excp.printStackTrace();
		}
		return null;
		
	}
}
