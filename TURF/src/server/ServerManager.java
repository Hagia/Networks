package server;

public class ServerManager {

	private final static long BEFORE_RACE = 30;

	private final static long RACE_TIME = 15;

	private Clock clock;

	private Server server;

	public ServerManager() {
		// TODO Auto-generated constructor stub
		server = new Server();
	}

	public void start() {
		clock = new Clock(BEFORE_RACE);
		clock.start();
		server.startTcpService();
//		server.getTcpService().adviceAll("Race is starting in " + BEFORE_RACE + " seconds");
		while (clock.isAlive()) {

		}
//		server.getTcpService().adviceAll("Race has started." + "\n" + "Race will finish is " + RACE_TIME + " seconds");
		clock = new Clock(RACE_TIME);
		server.startTcpUpdating();
		server.startUdpService();
//		server.getTcpService().startRace();
		clock.start();
		while (clock.isAlive()) {

		}
		server.getTcpService().stopUpdating();
	}

	public Clock getClock() {
		return clock;
	}

	public void setClock(Clock clock) {
		this.clock = clock;
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public static void main(String[] args) {
		ServerManager sm = new ServerManager();
		sm.start();
	}

}
