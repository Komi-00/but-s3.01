package ui;

public class Playing {
	private long cowCoin;
	private int autoClick;
	private int letterB;
	private int wordAzerty;
	private int wordDactylographie;
	
	public Playing() {
		cowCoin = 0L;
		autoClick = 0;
		letterB = 0;
		wordAzerty = 0;
		wordDactylographie = 0;
	}
	
	public Playing(long cowCoin, int autoClick, int letterB, int wordAzerty, int wordDactylographie) {
		this.cowCoin = cowCoin;
		this.autoClick = autoClick;
		this.letterB = letterB;
		this.wordAzerty = wordAzerty;
		this.wordDactylographie = wordDactylographie;
	}

	public long getCowCoin() {
		return cowCoin;
	}

	public void setCowCoin(long cowCoin) {
		this.cowCoin = cowCoin;
	}

	public int getAutoClick() {
		return autoClick;
	}

	public void setAutoClick(int autoClick) {
		this.autoClick = autoClick;
	}

	public int getLetterB() {
		return letterB;
	}

	public void setLetterB(int letterB) {
		this.letterB = letterB;
	}

	public int getWordAzerty() {
		return wordAzerty;
	}

	public void setWordAzerty(int wordAzerty) {
		this.wordAzerty = wordAzerty;
	}

	public int getWordDactylographie() {
		return wordDactylographie;
	}

	public void setWordDactylographie(int wordDactylographie) {
		this.wordDactylographie = wordDactylographie;
	}
}
