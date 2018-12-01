package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.accessibility.Accessible;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class BetPane extends JPanel implements ActionListener {

	private final static String BET = "Bet";
	
	private JButton btnBet;

	private JTextField txtBet;

	private JLabel labInfo;
	
	private TurfView main;

	public BetPane(TurfView main) {
		// TODO Auto-generated constructor stub
		this.main = main;
		initialize();
		set();
		add();
	}

	public void initialize() {
		this.btnBet = new JButton(BET);
		this.txtBet = new JTextField();
		this.labInfo = new JLabel();
	}

	public void set() {
		this.setLayout(new GridLayout(2, 2, 7, 7));

		this.btnBet.setActionCommand(BET);
		this.btnBet.addActionListener(this);

	}

	public void add() {
		this.add(this.txtBet);
		this.add(this.btnBet);
		this.add(this.labInfo);

	}
	
	public String getBet() {
		return txtBet.getText();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String c = e.getActionCommand();
		if (c.equals(BET)) {
			this.main.betHorse();
		}
	}

}
