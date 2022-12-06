package ui;

public interface InputProperty {

	public boolean isGameCommand();
	
	public boolean isStatusCommand();
	
	public boolean isMinigame();
	
	public boolean isAvailable();
	
	public String getCommand();
}
