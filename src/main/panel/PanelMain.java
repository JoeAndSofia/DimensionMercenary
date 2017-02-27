package main.panel;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class PanelMain extends JPanel {

	private boolean doDraw = false;
	
	public PanelMain(){
		System.out.println("mainPanel");
	}
	
	public PanelMain(Timer timer){
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				requestFocusInWindow();
				if(doDraw){
					PanelMain.this.repaint();
				}
			}
		}, 0, 10);
	}
}
