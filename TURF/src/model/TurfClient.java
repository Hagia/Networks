package model;

import client.TcpClient;
import client.UdpMulticastClient;
import server.UdpAudioService;
import view.TurfView;

public class TurfClient {

	private TcpClient tcpService;

	private UdpMulticastClient udpService;
	
	private TurfView view;
	
	private String dataToSent;

	public TurfClient(TurfView view) {
		// TODO Auto-generated constructor stub
		initializeServices();
		dataToSent = new String();
		this.view = view;
	}

	public void initializeServices() {
		this.tcpService = new TcpClient(this);
		this.udpService = new UdpMulticastClient();
	}

	public void joinRace() {
		tcpService.start();
	}

	public void joinNarration() {
		this.udpService.start();
	}

	public String[] horsesReport() {
		return null;
	}
	
	public String getDataToSent() {
		return dataToSent;
	}

	public void setDataToSent(String dataToSent) {
		this.dataToSent = dataToSent;
	}

	public TurfView getView() {
		return view;
	}

	public void setView(TurfView view) {
		this.view = view;
	}

	public static void main(String[] args) {
//		TurfClient client = new TurfClient();
//		client.joinRace();
	}
}
