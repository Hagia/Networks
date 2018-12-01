package view;

import javax.swing.JProgressBar;

public class ProgressBarThread extends Thread{
	
	private JProgressBar bar;
	
	public ProgressBarThread(JProgressBar bar) {
		// TODO Auto-generated constructor stub
		this.bar = bar;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		while(i < 100) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bar.setValue(i);
			i++;
		}
	}
	

}
