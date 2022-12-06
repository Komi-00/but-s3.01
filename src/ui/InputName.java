package ui;

public enum InputName {
	A("A"),
	B("B"),
	AZERTY("AZERTY"),
	DACTY("DACTYLOGRAPHIE"),
	RCA("RCA"),
	RANK("RANK"),
	SHOP("M"),
	RESET("RESET"),
	MINIGAME("MINIGAME");
	
	public String command;
	
	InputName(String command) {
		this.command = command;
	}
	
	@Override
	public String toString() {
		return this.command;
	}

}
