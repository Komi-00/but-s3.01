package ui;

public class GameInput  extends InputGlobal implements InputProperty{
	
	private int value;
	private int multiplier;
	
	public GameInput(InputName command, int defValue, int multiplier, boolean available) {
		super(command, available);
		this.value = defValue;
		this.multiplier = multiplier;
	}
	
	public GameInput(InputName command, boolean available) {
		this(command, 1, 1, available);
	}
	
	@Override
	public boolean isGameCommand() {
		return true;
	}
	
	@Override
	public boolean isMinigame() {
		return false;
	}

	@Override
	public boolean isStatusCommand() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAvailable() {
		// TODO Auto-generated method stub
		return this.isAvailable;
	}

	@Override
	public String getCommand() {
		// TODO Auto-generated method stub
		return this.command.toString();
	}
	
	public long getComputedValue() {
		return this.value * this.multiplier;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
	}

}
