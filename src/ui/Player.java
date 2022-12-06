package ui;

public class Player extends PlayerStats {
	
	private String username;
	
	public Player(String username, long ResetCurrencyAmount) {
		super(ResetCurrencyAmount);
		this.username = username;
	}
	
	public Player(String username, long ResetCurrencyAmount, long TotalCowCoinsAmount, int bigMult) {
		super(ResetCurrencyAmount, TotalCowCoinsAmount, bigMult);
		this.username = username;
	}
	
	
	public Player() {
		this("default-user", 0);
	}
	
	public void setPlayerTotalEarnedCowCoins(long value) {
		this.setTotalCowCoinsAmount(value);
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}
}
