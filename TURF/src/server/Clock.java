package server;

import java.io.IOException;

public class Clock extends Thread{
	
	private long timeSeconds;
	
	private long progress;
	
	public Clock(long time) {
		// TODO Auto-generated constructor stub
		this.timeSeconds = time;
		this.progress = 0;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(progress < timeSeconds) {
				sleep(1000);
				if(progress == timeSeconds-1){
					System.out.println((timeSeconds - progress) + " left.");
				}
				progress++;
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	public long getProgress() {
		return progress;
	}

	public void setProgress(long progress) {
		this.progress = progress;
	}
	
	

}
