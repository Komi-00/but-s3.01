package ui;

public class InputGlobal {

	protected InputName command;
	protected boolean isAvailable;
	
	public InputGlobal(InputName command, boolean available){
		this.command = command;
		this.isAvailable = available;
	}
}
