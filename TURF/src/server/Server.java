package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Clock;
import java.util.Timer;

import javax.net.ssl.HttpsURLConnection;

import client.UdpMulticastClient;
import model.TurfRace;
import service.TcpService;
import service.UdpMulticastService;
import com.sun.net.httpserver.*;

public class Server {
	
	private TcpService tcpService;
	
	private UdpMulticastService udpService;
	
	private HttpService httpService;
		
	private TurfRace turf;
	
	public Server() {
		// TODO Auto-generated constructor stub
		initialize();
	}
	
	public void initialize() {
		this.turf = new TurfRace();
		initializeServices();
	}
	
	public void initializeServices() {
		this.tcpService = new TcpService(this);
		this.udpService = new UdpMulticastService();
	}
	
	public void startTcpService() {
		this.tcpService.start();
	}
	
	public void startUdpService() {
		this.udpService.start();
	}
	
	public void startTcpUpdating() {
		this.tcpService.starUpdating();
	}
	
	public TurfRace getTurf() {
		return turf;
	}

	public void setTurf(TurfRace turf) {
		this.turf = turf;
	}

	public TcpService getTcpService() {
		return tcpService;
	}

	public void setTcpService(TcpService tcpService) {
		this.tcpService = tcpService;
	}

	public UdpMulticastService getUdpService() {
		return udpService;
	}

	public void setUdpService(UdpMulticastService udpService) {
		this.udpService = udpService;
	}

	public static void main(String[] args) {
		new Server();
	}
	
	

}
