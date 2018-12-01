package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.Socket;

import server.Server;
import service.TcpService;

public class TcpClientManager extends Thread implements ITcpOperation {

	private Socket client;

	private PrintWriter dataSender;

	private BufferedReader dataReceiver;

	private TcpService service;

	private boolean flag;

	public TcpClientManager(Socket client, TcpService service) {
		// TODO Auto-generated constructor stub
		this.client = client;
		this.service = service;
		this.flag = true;

		try {
			this.dataReceiver = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
			this.dataSender = new PrintWriter(this.client.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void stopLoop() {
		this.flag = false;
	}

	@Override
	public void processConnection() {
		// TODO Auto-generated method stub
		try {

			while (flag) {
				String d = dataReceiver.readLine();
				this.service.processInputData(d);
				System.out.println("Data received");
				this.flag = false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendData(String data) {
		dataSender.println(data);
		dataSender.flush();
	}

	public void closeConnection() {

		try {
			dataReceiver.close();
			dataSender.close();
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		processConnection();
	}

}
