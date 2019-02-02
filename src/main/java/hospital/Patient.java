package hospital;

public class Patient {

	private static final int DEFAULT_HEALTH_LEVEL = 5;
	private int healthLevel;

	// Default no arguments constructor
	public Patient() {
		this.healthLevel = DEFAULT_HEALTH_LEVEL;
	}

	// customized constructor (Method overloaded)
	public Patient(int healthLevel) {
		this.healthLevel = healthLevel;
	}

	public int getHealthLevel() {
		return healthLevel;
	}

	public void increaseHealthLevel(int amount) {
		healthLevel += amount;
	}

}
