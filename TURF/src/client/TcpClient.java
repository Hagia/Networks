package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.TurfClient;

public class TcpClient extends Thread implements ITcpOperation {

	private Socket socket;

	private TurfClient turf;

	private int port;

	private PrintWriter dataSender;

	private BufferedReader dataReceiver;

	private boolean flag;

	private int state;

	public TcpClient(TurfClient client) {
		// TODO Auto-generated constructor stub
		try {
			this.turf = client;
			this.flag = true;
			this.state = 0;
			connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void connect() throws UnknownHostException, IOException {
		socket = new Socket("localhost", 17896);

		dataSender = new PrintWriter(this.socket.getOutputStream());
		dataReceiver = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		processConnection();
	}

	@Override
	public void processConnection() {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		try {
			while(flag) {
				if(state == 0) {
					dataSender.println(turf.getDataToSent());
					dataSender.flush();
					state = 1;
				}else {
					String data = dataReceiver.readLine();
					this.turf.getView().updateRace(data);
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
