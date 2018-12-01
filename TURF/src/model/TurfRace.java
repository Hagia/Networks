package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

public class TurfRace {

	private HashMap<Integer, Horse> horses;

	public TurfRace() {
		// TODO Auto-generated constructor stub
		this.horses = new HashMap<>();
		prepareHorses(6);
	}

	public void prepareHorses(int horseAmount) {
		for (int i = 0; i < horseAmount; i++) {
			horses.put(i, new Horse(i));
		}
	}

	public String reportBeforeStart() {
		String report = "";
		Iterator<Integer> i = horses.keySet().iterator();
		while (i.hasNext()) {
			int code = i.next();
			report += "Horse with code " + code + "\n";
		}
		return report;

	}

	public void startRace() {

	}

	public void betHorse(int horseId, int amount) {
		System.out.println("Horse bet");
		horses.get(horseId-1).setBetAmount(amount);
	}

	public String raceState() {
		String report = new String();
		Iterator<Integer> i = horses.keySet().iterator();
		while (i.hasNext()) {
			int code = i.next();
			report += horses.get(code).getAdvance() + "-";
		}

		return report;
	}

	private int winner() {
		int pos = 0;
		int winnerKey = 0;
		Iterator<Integer> i = horses.keySet().iterator();
		while (i.hasNext()) {
			int k = i.next();
			int p = horses.get(k).getPos();
			if (p > pos) {
				pos = p;
				winnerKey = k;
			}
		}

		return winnerKey;
	}

	public String raceReport() {
		String report = new String();
		int horseWinner = winner();
		int i = 0;
		while (i < 6) {
			int key = i;
			Horse h = horses.get(key);
			if (key == horseWinner)
				report += h.getPos() + "," + h.getBetAmount() + ",1-";
			else
				report += h.getPos() + "," + h.getBetAmount() + ",0-";
			i++;
		}

		return report;
	}

}
