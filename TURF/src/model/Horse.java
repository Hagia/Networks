package model;

public class Horse {

	private int code;

	private int pos;

	private int betAmount;

	private int speed;

	public Horse(int code) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.pos = -1;
		this.betAmount = 0;
		this.speed = (int) ((Math.random() * 10) + 1);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public int getBetAmount() {
		return betAmount;
	}

	public void setBetAmount(int betAmount) {
		this.betAmount += betAmount;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getAdvance() {
		int a = (int) ((Math.random()*speed)+1);
		pos+= a;
		return a;
	}

}
