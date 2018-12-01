package service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import client.TcpClientManager;
import model.TurfRace;
import server.Server;

public class TcpService extends Service implements IService {

	private ArrayList<TcpClientManager> connectedClients;

	private ServerSocket socket;
	
	private UpdaterThread updater;

	private int port;
	
	private boolean updateFlag;

	private boolean listenFlag;

	public TcpService(Server server) {
		// TODO Auto-generated constructor stub
		super(server);
		try {
			this.updater = new UpdaterThread(this);
			this.port = 17896;
			this.listenFlag = true;
			this.updateFlag = true;
			this.connectedClients = new ArrayList<>();
			this.socket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		startListening();
	}

	@Override
	public void startListening() {
		// TODO Auto-generated method stub
		try {
			this.printMessage("TcpService has started listening");
			while (listenFlag) {
				Socket client = this.socket.accept();
				TcpClientManager t = new TcpClientManager(client, this);
				connectedClients.add(t);
				this.printMessage("A new client has been accepted");
				t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.printMessage("TcpService has stopped listening");
	}
	
	@Override
	public void stopListening() {
		// TODO Auto-generated method stub
		try {
			sleep(50);
			this.listenFlag = false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public void starUpdating() {
		this.updater.start();
	}
	
	public void stopUpdating() {
		this.updateFlag = false;
	}
	
	public void processInputData(String data) {
		String[] split = data.split("-");
		getServer().getTurf().betHorse(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
		
	}
	
	public void sendRaceFinal() {
		String u = "f" + getServer().getTurf().raceReport();
		for(TcpClientManager tcm : connectedClients) {
			tcm.sendData(u);
		}
	}

	public void updateRaceState() {
		String u = getServer().getTurf().raceState();
		for(TcpClientManager tcm : connectedClients) {
			tcm.sendData(u);
		}
	}

	public boolean isUpdateFlag() {
		return updateFlag;
	}

	public void setUpdateFlag(boolean updateFlag) {
		this.updateFlag = updateFlag;
	}
	
	
}
