package service;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import server.Server;

public class UdpService extends Service implements  IService{
	
	private DatagramSocket soccket;
	
	private DatagramPacket packet;
	
	public UdpService(Server server) {
		// TODO Auto-generated constructor stub
		super(server);
	}

	@Override
	public void startListening() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopListening() {
		// TODO Auto-generated method stub
		
	}

}
