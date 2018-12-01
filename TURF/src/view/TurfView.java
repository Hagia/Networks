package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.TurfClient;
import model.TurfRace;
import server.ServerManager;

public class TurfView extends JFrame{
	
	private RacePane racePane;
	
	private BetPane betPane;
	
	private ConnectPane connectPane;
			
	private JTextArea area;
	
	private TurfClient client;
		
	public TurfView() {
		// TODO Auto-generated constructor stub
		initialize();
		set();
		add();
	}
	
	public void initialize() {
		this.racePane = new RacePane();
		this.betPane = new BetPane(this);
		this.connectPane = new ConnectPane(this);
		this.area = new JTextArea();
		this.client = new TurfClient(this);
	}
	
	public void set() {
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(600, 250));
	}
	
	public void add() {
		this.add(racePane, BorderLayout.NORTH);
		this.add(betPane, BorderLayout.SOUTH);
	}
	
	public void updateRace(String data) {
		racePane.updateRace(data);
	}
	
	public void betHorse() {
		String i = betPane.getBet();
		int j = Integer.parseInt(i.charAt(0)+"");
		racePane.setHorse(j);
		client.setDataToSent(betPane.getBet());
		client.joinRace();
		client.joinNarration();
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TurfView t = new TurfView();
		t.setVisible(true);
	}

}
