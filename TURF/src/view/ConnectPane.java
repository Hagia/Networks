package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.TurfRace;

public class ConnectPane extends JPanel implements ActionListener{
	
	private final static String CONNECT = "Connect";
	
	private JButton btnConnect;
	
	private TurfView main;
	
	public ConnectPane(TurfView main) {
		// TODO Auto-generated constructor stub
		this.main = main;
		initialize();
		set();
		add();
	}
	
	public void initialize() {
		this.btnConnect = new JButton(CONNECT);
	}
	
	public void set() {
		this.btnConnect.setActionCommand(CONNECT);
		this.btnConnect.addActionListener(this);
	}
	
	public void add() {
		this.add(this.btnConnect);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String c = e.getActionCommand();
		if(c.equals(CONNECT)) {
//			main.connect();
		}
	}

}
