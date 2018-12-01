package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import org.jline.terminal.spi.Pty;

import model.Horse;

public class HorsePane extends JPanel {

	private JProgressBar prbBar;

	private ProgressBarThread thread;

	private JLabel labName;

	private JLabel labWin;

	private JLabel labBet;

	private int code;

	public HorsePane(int code) {
		// TODO Auto-generated constructor stub
		this.code = code;
		initialize();
		set();
		add();
	}

	public void initialize() {
		this.labName = new JLabel("Horse " + code);
		this.labBet = new JLabel();
		this.labWin = new JLabel();
		this.prbBar = new JProgressBar(0, 100);
	}

	public void set() {
		this.prbBar.setForeground(Color.GRAY);
		this.setLayout(new GridLayout(1, 4, 40, 40));
	}

	public void add() {
		this.add(labName);
		this.add(prbBar);
		this.add(labBet);
		this.add(labWin);
	}

	public void updateProgres(int i) {
		this.prbBar.setValue(prbBar.getValue() + i);
	}

	public void setBet(String bet) {
		this.labBet.setText("Amount : " + bet);
	}

	public void setWin(int i) {
		if (i == 0) {
			labWin.setText("Lost");
		} else {
			labWin.setText("Winner");
		}
	}

	public void setPrefer() {
		// TODO Auto-generated method stub
		prbBar.setBackground(Color.RED);
	}

}
