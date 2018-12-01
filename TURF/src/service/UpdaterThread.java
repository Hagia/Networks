package service;

public class UpdaterThread extends Thread {

	private TcpService service;
	
	public UpdaterThread(TcpService service) {
		// TODO Auto-generated constructor stub
		this.service = service;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (service.isUpdateFlag()) {
				sleep(1000);

				service.updateRaceState();
			}
			service.sendRaceFinal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
