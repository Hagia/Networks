package view;

import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

import model.Horse;

public class RacePane extends JPanel {

	private HorsePane[] horses;

	public RacePane() {
		// TODO Auto-generated constructor stub
		initialize();
		set();
		add();
	}

	public void initialize() {
		horses = new HorsePane[6];
		int i = 1;
		while (i < 7) {
			horses[i - 1] = new HorsePane(i);
			i++;
		}
	}

	public void set() {
		setLayout(new GridLayout(6, 1));
	}

	public void add() {
		for (int i = 0; i < horses.length; i++) {
			this.add(horses[i]);
		}

	}

	public void updateRace(String data) {
		String[] toUpdate = data.split("-");
		String f = data.charAt(0) + "";
		int i = 0;
		if(!f.equals("f")) {
			for (String s : toUpdate) {

				int v = Integer.parseInt(s);
				horses[i].updateProgres(v);

				i++;
			}
		}else {
			f = data.substring(1);
			toUpdate = data.split("-");
			for (String s : toUpdate) {

				String[] arr = s.split(",");
				horses[i].setBet(arr[1]);
				horses[i].setWin(Integer.parseInt(arr[2]));
//				horses[i].add();
				i++;
			}
		}
	}

	public void setHorse(int j) {
		// TODO Auto-generated method stub
		horses[j-1].setPrefer();
	}

}
