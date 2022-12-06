package ui;

public class PlayerStats {
	
	private long  ResetCurrencyAmount;
	private long TotalCowCoinsAmount;
	private int bigMult;
	private int soldes;
	private Playing currentGame;
	
	public PlayerStats(long ResetMoney) {
		this.ResetCurrencyAmount = ResetMoney;
		this.TotalCowCoinsAmount = 0;
		this.bigMult = 1;
		this.soldes = 1;
		this.currentGame = new Playing();
	}
	
	public Playing getCurrentGame() {
		return this.currentGame;
	}
	
	public PlayerStats(long ResetMoney, long TotalCowCoinsAmount, int bigMult) {
		this.ResetCurrencyAmount = ResetMoney;
		this.TotalCowCoinsAmount = TotalCowCoinsAmount;
		this.bigMult = bigMult;
		this.soldes = 1;
		this.currentGame = new Playing();
	}

	public void setTotalCowCoinsAmount(long amount) {
		this.TotalCowCoinsAmount = amount;
	}
	
	public long getTotalCowCoinsAmount() {
		return this.TotalCowCoinsAmount;
	}
	
	public long getResetCurrencyAmount() {
		return ResetCurrencyAmount;
	}

	public void setResetCurrencyAmount(long resetCurrencyAmount) {
		ResetCurrencyAmount = resetCurrencyAmount;
	}
	
	public void setCurrentGame(Playing game) {
		this.currentGame = game;
	}
	
	public boolean increaseCurrencyAmount(long value, Currency currency) {
		if(currency.equals(Currency.CowCoins)) {
			value = value * bigMult;
			this.currentGame.setCowCoin(this.currentGame.getCowCoin() + value);
			this.TotalCowCoinsAmount += value;
			return true;
		} else if(currency.equals(Currency.ResetCurrency)) {
			this.ResetCurrencyAmount += value;
			return true;
		}
		return false;
	}

	public boolean decreaseCurrencyAmount(int value, Currency currency) {
		if(currency.equals(Currency.CowCoins) && (this.currentGame.getCowCoin() - value) > 0) {

			
			this.currentGame.setCowCoin(this.currentGame.getCowCoin() - value/soldes);
			return true;
		} else if(currency.equals(Currency.ResetCurrency) && (this.ResetCurrencyAmount - value) > 0) {
			this.ResetCurrencyAmount -= value;
			return true;
		}
		return false;
	}
	
	public int getBigMult() {
		return bigMult;
	}
	
	public void setBigMult(int bigMult ) {
		this.bigMult=bigMult;
	}
	
	public int getSoldes() {
		return soldes;
	}
	
	public void setSoldes(int soldes) {
		this.soldes=soldes;
	}
	
	
	public void increaseBigMult() {
		bigMult++;
	}
}
