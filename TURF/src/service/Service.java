package service;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import server.Server;

public class Service extends Thread{
	
	
	private Server server;
	
	private BufferedWriter writer;
	
	public Service(Server server) {
		this.server = server;
		// TODO Auto-generated constructor stub
		this.writer = new BufferedWriter(new OutputStreamWriter(System.out));
	}
	
	public void printMessage(String message) {
		System.out.println(message);
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}
	
	

}
